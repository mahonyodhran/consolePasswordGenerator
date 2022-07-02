public class Main {
    public static void main(String[] args) {
        helper.pinCheck();
        int passwordLength = helper.getPasswordLength();
        String password = helper.generatePassword(passwordLength);
        // set up separate flow to ask if you want to save it
        boolean save = helper.savePassword();

        if (save) {
            String passwordPair = helper.getPasswordPair();
            helper.saveToFile(password, passwordPair);
        } else {
            System.out.println("Your password is: " + password);
        }
    }
}