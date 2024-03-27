import entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        List<Employee> employeeList = new ArrayList<>();

        System.out.print("Enter full file path: ");
        String path = scanner.nextLine();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = bufferedReader.readLine();
            do {
                String[] stringList = line.split(",");
                employeeList.add(new Employee(stringList[0], stringList[1], Double.parseDouble(stringList[2])));
                line = bufferedReader.readLine();
            } while (line != null);

            System.out.print("Enter salary: ");
            double baseSalaty = scanner.nextDouble();

            Comparator<String> comparator = (o1, o2) -> o1.toUpperCase().compareTo(o2.toUpperCase());

            List<String> stringList = employeeList.stream()
                    .filter(employee -> employee.getSalary() > baseSalaty)
                    .map(Employee::getEmail)
                    .sorted(comparator)
                    .collect(Collectors.toList());

            stringList.forEach(System.out::println);

            double sumSalary = employeeList.stream()
                    .filter(employee -> employee.getName().charAt(0) == 'M')
                    .map(Employee::getSalary)
                    .reduce(0.00, Double::sum);

            System.out.println("Sum of salary of people whose name starts with 'M': " + sumSalary);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}