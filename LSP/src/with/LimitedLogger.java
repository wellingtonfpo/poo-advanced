package with;

import without.Logger;

public class LimitedLogger extends Logger {
    private final int maxLength;

    public LimitedLogger(int maxLength) {
        this.maxLength = maxLength;
    }

    public void log(String message) {
        String truncateMessage = message.length() > this.maxLength
                ? message.substring(0, this.maxLength) + "..."
                : message;

        System.out.println("[LOG]: " + truncateMessage);
    }
}
