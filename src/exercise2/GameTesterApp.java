package exercise2;

import java.util.Scanner;

// Abstract class GameTester
abstract class GameTester {
    protected String name;
    protected boolean isFullTime;

    // Constructor
    public GameTester(String name, boolean isFullTime) {
        this.name = name;
        this.isFullTime = isFullTime;
    }

    // Abstract method to determine the salary
    public abstract double calculateSalary();
}

// Subclass FullTimeGameTester
class FullTimeGameTester extends GameTester {
    // Constructor
    public FullTimeGameTester(String name) {
        super(name, true);
    }

    // Override calculateSalary method
    @Override
    public double calculateSalary() {
        return 3000; // Full-time game testers get a base salary of $3000
    }
}

// Subclass PartTimeGameTester
class PartTimeGameTester extends GameTester {
    private int hoursWorked;

    // Constructor
    public PartTimeGameTester(String name, int hoursWorked) {
        super(name, false);
        this.hoursWorked = hoursWorked;
    }

    // Override calculateSalary method
    @Override
    public double calculateSalary() {
        return 20 * hoursWorked; // Part-time game testers get $20 per hour
    }
}

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
