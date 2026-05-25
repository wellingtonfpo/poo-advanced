void main() {
    List<Employee> employees = new ArrayList<>() {{
        add(new Employee("Wellington", "Menezes", 20000.0, "IT"));
        add(new Employee("Luan", "Marx", 7000.0, "IT"));
        add(new Employee("Luanny", "Maria", 8500.0, "RH"));
        add(new Employee("Rosimeire", "Melo", 9500.0, "Finance"));
    }};

    IO.println("Complete employee list");
    employees.forEach(System.out::println);

    List<Employee> sortedBySalary = employees.stream()
            .sorted(Comparator.comparing(Employee::getSalary).reversed())
            .toList();

    IO.println();
    IO.println("Employees sorted by Salary:");
    sortedBySalary.forEach(System.out::println);

    IO.println();

    // Empregados com salário entre 5000 e 10000
    Predicate<Employee> fiveToTenThousand = e -> (e.getSalary() >= 5000.0 && e.getSalary() <= 10000.0);
    IO.println("Employee earnings between $5,000 and $10,000");
    employees.stream().filter(fiveToTenThousand)
            .sorted(Comparator.comparing(Employee::getSalary))
            .forEach(System.out::println);

    System.out.println();

    // Imprime os funcionários agrupados por departamento
    System.out.println("Employees by department:");
    Map<String, List<Employee>> employeesByDepartment = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));

    employeesByDepartment.forEach((department, employeesInDepartment) -> {
    System.out.println(department);
    employeesInDepartment.forEach(employee -> System.out.printf("  %s %s%n",
            employee.getFirstName(), employee.getLastName()));
    });

    System.out.println();

    // somando e calculando a média dos salários
    System.out.printf("Total salary: %.2f%n", employees.stream()
            .mapToDouble(Employee::getSalary)
            .sum());

    System.out.printf("Average salary: %.2f%n", employees.stream()
            .mapToDouble(Employee::getSalary)
            .average()
            .orElse(0.0));
}
