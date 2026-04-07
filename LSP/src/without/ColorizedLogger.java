package without;

public class ColorizedLogger extends Logger {
    public void log(String message) {
        System.out.println("\u001B[32m[LOG]: " + message + "\u001B[0m");
    }
}
