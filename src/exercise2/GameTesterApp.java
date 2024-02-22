package exercise2;

import java.util.Scanner;

// Main class for console application
public class GameTesterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.println("Enter the name of the game tester:");
        String name = scanner.nextLine();

        System.out.println("Choose game tester type (1 for Full-time, 2 for Part-time):");
        int choice = scanner.nextInt();

        // Create objects based on user input
        if (choice == 1) {
            FullTimeGameTester fullTimeTester = new FullTimeGameTester(name);
            System.out.println("Full-time game tester created.");
            System.out.println("Salary: $" + fullTimeTester.calculateSalary());
        } else if (choice == 2) {
            System.out.println("Enter the number of hours worked by the part-time game tester:");
            int hoursWorked = scanner.nextInt();
            PartTimeGameTester partTimeTester = new PartTimeGameTester(name, hoursWorked);
            System.out.println("Part-time game tester created.");
            System.out.println("Salary: $" + partTimeTester.calculateSalary());
        } else {
            System.out.println("Invalid choice. Please choose 1 for Full-time or 2 for Part-time.");
        }

        // Close the scanner
        scanner.close();
    }
}
