package exercise2;

import java.util.Scanner;

public class Main {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose game tester type:");
        System.out.println("1. Full-Time");
        System.out.println("2. Part-Time");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter full-time tester name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            FullTimeGameTester fullTimeTester = new FullTimeGameTester(name);
            System.out.println("Full-Time Tester: " + fullTimeTester.name);
            System.out.println("Salary: $" + fullTimeTester.calculateSalary());
        } else if (choice == 2) {
            System.out.print("Enter part-time tester name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.print("Enter number of hours worked: ");
            int hoursWorked = scanner.nextInt();
            PartTimeGameTester partTimeTester = new PartTimeGameTester(name,
                    hoursWorked);
            System.out.println("Part-Time Tester: " + partTimeTester.name);
            System.out.println("Hours Worked: " + partTimeTester.hoursWorked);
            System.out.println("Salary: $" + partTimeTester.calculateSalary());
        } else {
            System.out.println("Invalid choice");
        }

        scanner.close();
    }
}

abstract class GameTester {
    protected String name;
    protected boolean isFullTime;

    public GameTester(String name, boolean isFullTime) {
        this.name = name;
        this.isFullTime = isFullTime;
    }

    public abstract double calculateSalary();
}

class FullTimeGameTester extends GameTester {
    public FullTimeGameTester(String name) {
        super(name, true);
    }

    @Override
    public double calculateSalary() {
        return 3000;
    }
}

class PartTimeGameTester extends GameTester {
    public int hoursWorked;

    public PartTimeGameTester(String name, int hoursWorked) {
        super(name, false);
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * 20;
    }
}
