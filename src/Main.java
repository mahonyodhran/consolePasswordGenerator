public class Main {
    public static void main(String[] args) {
        helper.pinCheck();
        int passwordLength = helper.getPasswordLength();
        String password = helper.generatePassword(passwordLength);
        String passwordPair = helper.getPasswordPair();
        helper.saveToFile(password, passwordPair);
    }
}