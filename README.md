# Secure Data Hiding in Image Using Steganography

This Java project implements **image steganography** to hide and extract secret messages in images.

## Features

- Hides a message inside an image by modifying pixel values.
- Extracts the hidden message using the correct passcode.
- Uses simple Least Significant Bit (LSB) encoding for data hiding.

## Project Structure

SecureDataHidingStegoJava/

├── src/
│   ├── Encoder.java
│   ├── Decoder.java
│   ├── Main.java
|
├── images/
│   ├── input.png
│   ├── encryptedImage.png
|
├── README.md

## How to Run

1. **Place your image** in the `images/` folder and name it `input.png`.
2. **Run the program** using:

3. **Enter the message** and passcode when prompted.
4. **To decrypt**, enter the correct passcode.

## Requirements

- Java 8 or later
- An image file in PNG format

## Future Enhancements

- Encrypt the message before embedding it in the image.
- Support for multiple image formats (JPEG, BMP, etc.).
- Improve security using stronger encoding techniques.
