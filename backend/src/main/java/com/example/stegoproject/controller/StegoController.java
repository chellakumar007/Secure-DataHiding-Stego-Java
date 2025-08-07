package com.example.stegoproject.controller;

import com.example.stegoproject.service.EncoderService;
import com.example.stegoproject.service.DecoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class StegoController {

    @Autowired
    private EncoderService encoderService;

    @Autowired
    private DecoderService decoderService;

    @PostMapping("/encode")
    public ResponseEntity<byte[]> encodeMessage(
            @RequestParam("image") MultipartFile image,
            @RequestParam("message") String message,
            @RequestParam("passcode") String passcode
    ) {
        try {
            byte[] encoded = encoderService.encode(image.getInputStream(), message, passcode);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
            headers.setContentDisposition(ContentDisposition.attachment().filename("encoded_image.png").build());

            return new ResponseEntity<>(encoded, headers, HttpStatus.OK);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/decode")
    public ResponseEntity<String> decodeMessage(
            @RequestParam("image") MultipartFile image,
            @RequestParam("passcode") String passcode
    ) {
        try {
            // Read image and calculate capacity (max characters can be read)
            BufferedImage img = ImageIO.read(image.getInputStream());
            int expectedLength = img.getWidth() * img.getHeight();

            String result = decoderService.decode(image.getInputStream(), passcode);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }
}
