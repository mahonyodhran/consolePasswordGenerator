public class User {
    private String username;
    private int pin;

    public User() {
        this.username = "default";
        this.pin = 1234;
    }

    public User(String username, int pin) {
        this.username = username;
        this.pin = pin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "User [pin=" + pin + ", username=" + username + "]";
    }
}
