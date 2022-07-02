public class Main {
    public static void main(String[] args) {
        helper.pinCheck();
        int passwordLength = helper.getPasswordLength();
        String password = helper.generatePassword(passwordLength);
        boolean save = helper.savePassword();

        if (save) {
            String passwordPair = helper.getPasswordPair();
            helper.saveToFile(password, passwordPair);
        } else {
            System.out.println("Your password is: " + password);
        }

        boolean read = helper.wantReadFile();
        if (read) {
            System.out.println(helper.readFile());
        }

        System.out.println("Thanks for using the system - Goodbye . . .");
    }
}