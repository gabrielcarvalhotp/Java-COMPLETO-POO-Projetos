import entities.Employee;
import entities.Rectangle;
import entities.Student;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        exercise3();
    }

    public static void exercise1(){
        Scanner scanner = new Scanner(System.in);
        Rectangle rectangle = new Rectangle();

        rectangle.setWidth(scanner.nextDouble());
        rectangle.setHeight(scanner.nextDouble());

        System.out.printf("AREA = %.2f \n", rectangle.getArea());
        System.out.printf("PERIMETER = %.2f \n", rectangle.getPerimeter());
        System.out.printf("DIAGONAL = %.2f \n", rectangle.getDiagonal());

        scanner.close();
    }

    public static void exercise2() {
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();

        System.out.print("Name: ");
        employee.setName(scanner.nextLine());
        System.out.print("Gross salary: ");
        employee.setGrossSalary(scanner.nextDouble());
        System.out.print("Tax: ");
        employee.setTax(scanner.nextDouble());

        System.out.println(employee);

        System.out.print("Which percentage to increase salary?");
        employee.increaseSalary(scanner.nextDouble());

        System.out.println(employee);

        scanner.close();
    }

    public static void exercise3() {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();

        student.setName(scanner.nextLine());
        student.setGrade1(scanner.nextDouble());
        student.setGrade2(scanner.nextDouble());
        student.setGrade3(scanner.nextDouble());

        System.out.printf("FINAL GRADE = %.2f \n", student.getGrade());
        if (student.getGrade() > 60.00)
            System.out.println("PASS");
        else {
            System.out.println("FALL");
            System.out.printf("MISSING %.2f POINTS", 60 - student.getGrade());
        }

        scanner.close();
    }

}