import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class helper {
    private static User user = new User("john", 1234);
    static Scanner input = new Scanner(System.in);

    static String getPasswordPair() {
        System.out.print("What is the password for: ");
        return input.nextLine();
    }

    static boolean pinCheck() {
        int answer = 0;
        System.out.println("Welcome back " + user.getUsername() + "!");
        do {
            System.out.print("Please enter your pin to continue: ");
            while (!input.hasNextInt()) {
                System.out.print("Incorrect! Please enter your pin to continue: ");
                input.next();
            }
            answer = input.nextInt();
        } while (answer != user.getPin());

        input.nextLine();
        return true;
    }

    static int getPasswordLength() {
        int length = 0;

        do {
            System.out.print("How long would you like your password: ");
            while (!input.hasNextInt()) {
                System.out.print("Please enter a value greater than 10: ");
                input.next();
            }
            length = input.nextInt();
        } while (length <= 9);

        input.nextLine();
        return length;
    }

    static String generatePassword(int passwordLength) {
        final String LOWER = "abcdefghijklmnopqrstuvwxyz";
        final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String DIGITS = "0123456789";
        final String PUNCTUATION = "!@#$%&*()_+-=[]|,./?><";
        final String all = LOWER + UPPER + DIGITS + PUNCTUATION;

        String password = "";
        Random r = new Random();
        for (int i = 0; i < passwordLength; i++) {
            password += (char) all.charAt(r.nextInt(all.length()));
        }
        return password;
    }

    static void saveToFile(String password, String passwordPair) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter("passwords.txt", true))) {
            try {
                out.write(passwordPair + " : " + password + '\n');
            } catch (IOException e) {
                System.out.println("Exception ");
            } finally {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Your password for " + passwordPair + " is " + password);
    }

    static boolean savePassword() {
        System.out.println("Would you like to save this password: ");
        System.out.print("Enter 'Y' or 'y' otherwise program will exit : ");

        String answer = input.nextLine();
        if (answer.length() == 0) {
            answer = "No";
        }
        if (answer.charAt(0) == 'Y' || answer.charAt(0) == 'y') {
            return true;
        } else {
            return false;
        }
    }

    static boolean wantReadFile() {
        System.out.println("Would you like to view saved passwords: ");
        System.out.print("Enter 'Y' or 'y' otherwise program will exit : ");

        String answer = input.nextLine();
        if (answer.length() == 0) {
            answer = "No";
        }
        if (answer.charAt(0) == 'Y' || answer.charAt(0) == 'y') {
            return true;
        } else {
            return false;
        }
    }

    static String readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("passwords.txt"))) {
            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                String everything = sb.toString();

                return everything;
            } finally {
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Error: File Empty or Not Found";
    }
}
