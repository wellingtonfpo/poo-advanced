import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProcessingEmployees {
    static void main(String[] args) {
        List<Employee> employees = new ArrayList<>() {{
            add(new Employee("Wellington", "Menezes", 20000.0, "IT"));
            add(new Employee("Luan", "Marx", 7000.0, "IT"));
            add(new Employee("Luanny", "Maria", 8500.0, "RH"));
            add(new Employee("Rosimeire", "Melo", 9500.0, "Finance"));
        }};

        System.out.println("Complete employee list");
        employees.forEach(System.out::println);

        List<Employee> sortedBySalary = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .toList();

        System.out.println("\nEmployees sorted by Salary:");
        sortedBySalary.forEach(System.out::println);
    }
}
