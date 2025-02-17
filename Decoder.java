import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Decoder {
    public static String decode(String imagePath, int messageLength) throws Exception {
        BufferedImage img = ImageIO.read(new File(imagePath));
        int width = img.getWidth(), height = img.getHeight();
        StringBuilder message = new StringBuilder();
        int msgIndex = 0;

        for (int y = 0; y < height && msgIndex < messageLength; y++) {
            for (int x = 0; x < width && msgIndex < messageLength; x++) {
                int pixel = img.getRGB(x, y);
                char charValue = (char) (pixel & 0xFF);
                message.append(charValue);
                msgIndex++;
            }
        }
        return message.toString();
    }
}