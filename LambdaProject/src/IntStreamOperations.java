import java.util.stream.IntStream;

public class IntStreamOperations {
    /**
     * {@code IntStream()}
     * <p>Do pacote java.util.stream é um fluxo especializado para manipular valores int.</p>
     **/
    static void main(String[] args) {

        int[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};

        System.out.print("Original values: ");
        IntStream.of(values).forEach(value -> System.out.printf("%d ", value));
        System.out.println();

        //count, min, max, sum, average
        System.out.printf("Count: %d%n", IntStream.of(values).count());
        System.out.printf("Min: %d%n", IntStream.of(values).min().getAsInt());
        System.out.printf("Max: %d%n", IntStream.of(values).max().getAsInt());
        System.out.printf("Sum: %d%n", IntStream.of(values).sum());
        System.out.printf("Average: %.2f%n", IntStream.of(values).average().orElse(0.0));

        //sum of values via reduce method
        System.out.printf("Sum via reduce method: %d%n", IntStream.of(values)
                .reduce(0, (x, y) -> x + y));

        //sum of squares via reduce method
        System.out.printf("Sum of squares via reduce method: %d%n", IntStream.of(values)
                .reduce(0, (x, y) -> x + y * y));

        //product of values via reduce method
        System.out.printf("Product via reduce method: %d%n", IntStream.of(values)
                .reduce(1, (x, y) -> x * y));

        //even values sorted
        System.out.print("Ordered even values: ");
        IntStream.of(values)
                .filter(value -> value % 2 == 0)
                .sorted()
                .forEach(value -> System.out.printf("%d ", value));
        System.out.println();

        //sum range 1-10, exclusive
        System.out.printf("Sum range 1-9, exclusive: %d%n", IntStream.range(1, 10).sum());

        //sum range 1-10, inclusive
        System.out.printf("Sum range 1-10, inclusive: %d%n", IntStream.rangeClosed(1, 10).sum());
    }
}
