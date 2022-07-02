import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int passwordLength = getPasswordLength();
        String password = generatePassword(passwordLength);
        System.out.println(password);
    }

    static int getPasswordLength() {
        Scanner input = new Scanner(System.in);
        int length = 0;

        do {
            System.out.print("How long would you like your password: ");
            while (!input.hasNextInt()) {
                System.out.println("Please enter a value greater than 5");
                input.next();
            }
            length = input.nextInt();
        } while (length <= 6);

        input.close();
        return length;
    }

    static String generatePassword(int passwordLength) {
        String password = "";
        for (int i = 0; i < passwordLength; i++) {
            password += i;
        }
        return password;
    }
}