package exercise2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose game tester type:");
        System.out.println("1. Full-Time");
        System.out.println("2. Part-Time");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter full-time tester name: ");
            scanner.nextLine(); // Consume newline
            String name = scanner.nextLine();
            FullTimeGameTester fullTimeTester = new FullTimeGameTester(name);
            System.out.println("Full-Time Tester: " + fullTimeTester.name);
            System.out.println("Salary: $" + fullTimeTester.calculateSalary());
        } else if (choice == 2) {
            System.out.print("Enter part-time tester name: ");
            scanner.nextLine(); // Consume newline
            String name = scanner.nextLine();
            System.out.print("Enter number of hours worked: ");
            int hoursWorked = scanner.nextInt();
            PartTimeGameTester partTimeTester = new PartTimeGameTester(name, hoursWorked);
            System.out.println("Part-Time Tester: " + partTimeTester.name);
            System.out.println("Hours Worked: " + partTimeTester.hoursWorked);
            System.out.println("Salary: $" + partTimeTester.calculateSalary());
        } else {
            System.out.println("Invalid choice");
        }

        scanner.close();
    }
}
