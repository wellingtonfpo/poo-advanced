import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;


public class ArraysAndStreams2 {
    static void main(String[] args) {
        String[] colors = {"Purple", "Red", "Green", "Blue", "Yellow"};

        System.out.printf("Original strings: %s%n", Arrays.asList(colors));

        System.out.printf("String in uppercase: %s%n",
                Arrays.stream(colors)
                        .map(String::toUpperCase)
                        .collect(Collectors.toList()));

        System.out.printf("String in lowercase: %s%n",
                Arrays.stream(colors)
                        .map(String::toLowerCase)
                        .collect(Collectors.toList()));

        System.out.printf("Strings sorted by length: %s%n",
                Arrays.stream(colors)
                        .sorted(Comparator.comparingInt(String::length))
                        .collect(Collectors.toList()));
    }
}
