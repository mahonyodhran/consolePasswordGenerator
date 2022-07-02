import java.util.Random;
import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

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
        String LOWER = "abcdefghijklmnopqrstuvwxyz";
        String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String DIGITS = "0123456789";
        String PUNCTUATION = "!@#$%&*()_+-=[]|,./?><";
        String all = LOWER + UPPER + DIGITS + PUNCTUATION;

        String password = "";
        Random r = new Random();
        for (int i = 0; i < passwordLength; i++) {
            password += (char) all.charAt(r.nextInt(all.length()));
        }
        return password;
    }
}