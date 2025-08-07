package com.example.stegoproject.service;

import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

@Service
public class EncoderService {

    public byte[] encode(InputStream imageInput, String message, String passcode) throws Exception {
        BufferedImage img = ImageIO.read(imageInput);

        int width = img.getWidth();
        int height = img.getHeight();

        String fullMessage = passcode + ":" + message + '\0';  // <-- Add null terminator
        char[] chars = fullMessage.toCharArray();
        int msgLen = chars.length;

        if (msgLen > width * height) {
            throw new Exception("Message too long to encode in image.");
        }

        int msgIndex = 0;
        outer:
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (msgIndex < msgLen) {
                    int pixel = img.getRGB(x, y);
                    int newPixel = (pixel & 0xFFFFFF00) | chars[msgIndex];
                    img.setRGB(x, y, newPixel);
                    msgIndex++;
                } else {
                    break outer;
                }
            }
        }

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ImageIO.write(img, "png", output);
        return output.toByteArray();
    }
}
