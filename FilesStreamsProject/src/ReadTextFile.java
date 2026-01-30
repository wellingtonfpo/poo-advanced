import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadTextFile {
    private static Scanner input;

    static void main(String[] args) {
        openFile();
        readFile();
        closeFile();
    }

    private static void openFile() {
        try {
            input = new Scanner(Paths.get("src/clients.txt"));
        } catch (IOException ioException) {
            System.err.println("Error opening file: " + ioException.getMessage());
            System.exit(1);
        }
    }

    private static void readFile() {
        System.out.printf("%-10s%-12s%-12s%10s%n", "Account", "First Name", "Last Name", "Balance");

        try {
            while (input.hasNext()) {
                System.out.printf("%-10d%-12s%-12s%10.2f%n",
                        input.nextInt(), input.next(), input.next(), input.nextDouble());
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("File improperly formed.");
            System.exit(1);
        } catch (IllegalStateException illegalStateException) {
            System.err.println("Error reading from file.");
            System.exit(1);
        }
    }

    private static void closeFile() {
        if (input != null) input.close();
    }
}
