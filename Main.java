import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter secret message: ");
            String message = scanner.nextLine();
            System.out.print("Enter passcode: ");
            String passcode = scanner.nextLine();

            Encoder.encode("../images/image.png", message, "../images/encryptedImage.png");
            System.out.println("Message hidden in image!");

            System.out.print("Enter passcode for decryption: ");
            String enteredPasscode = scanner.nextLine();

            if (enteredPasscode.equals(passcode)) {
                String decryptedMessage = Decoder.decode("../images/encryptedImage.png", message.length());
                System.out.println("Decryption successful: " + decryptedMessage);
            } else {
                System.out.println("Unauthorized access!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}