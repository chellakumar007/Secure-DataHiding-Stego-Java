package com.example.stegoproject.service;

import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;

@Service
public class DecoderService {

    public String decode(InputStream imageInput, String inputPasscode) throws Exception {
        BufferedImage img = ImageIO.read(imageInput);
        int width = img.getWidth();
        int height = img.getHeight();

        StringBuilder message = new StringBuilder();
        int maxPixels = width * height;

        for (int i = 0; i < maxPixels; i++) {
            int x = i % width;
            int y = i / width;
            int pixel = img.getRGB(x, y);
            char ch = (char) (pixel & 0xFF);

            if (ch == '\0') break;  // message end
            message.append(ch);
        }

        String fullMessage = message.toString();
        String[] parts = fullMessage.split(":", 2);

        if (parts.length != 2) {
            return "❌ Invalid or corrupted image.";
        }

        String extractedPass = parts[0];
        String extractedMsg = parts[1];

        if (!extractedPass.equals(inputPasscode)) {
            return "❌ Incorrect passcode.";
        }

        return "✅ Message: " + extractedMsg;
    }
}
