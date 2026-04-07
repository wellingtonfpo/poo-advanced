package without;

public class LimitedLogger extends Logger{
    private final int maxLength;

    public LimitedLogger(int maxLength) {
        this.maxLength = maxLength;
    }

    public void log(String message) {
        if (message.length() > this.maxLength) {
            throw new IllegalArgumentException("Message exceeds maximum length of " + this.maxLength);
        }
    }
}
