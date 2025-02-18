import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Encoder {
    public static void encode(String imagePath, String message, String outputPath) throws Exception {
        BufferedImage img = ImageIO.read(new File(imagePath));
        int width = img.getWidth(), height = img.getHeight();
        int msgIndex = 0, msgLength = message.length();

        for (int y = 0; y < height && msgIndex < msgLength; y++) {
            for (int x = 0; x < width && msgIndex < msgLength; x++) {
                int pixel = img.getRGB(x, y);
                int charValue = message.charAt(msgIndex++);
                int newPixel = (pixel & 0xFFFF00) | charValue;
                img.setRGB(x, y, newPixel);
            }
        }
        ImageIO.write(img, "png", new File(outputPath));
    }
}
