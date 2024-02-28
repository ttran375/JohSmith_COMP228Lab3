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
            System.out.println("Full-Time Tester: " + fullTimeTester.getName());
            System.out.println("Salary: $" + fullTimeTester.calculateSalary());
        } else if (choice == 2) {
            System.out.print("Enter part-time tester name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.print("Enter number of hours worked: ");
            int hoursWorked = scanner.nextInt();
            PartTimeGameTester partTimeTester = new PartTimeGameTester(name,
                    hoursWorked);
            System.out.println("Part-Time Tester: " + partTimeTester.getName());
            System.out.println("Hours Worked: "
                    + partTimeTester.getHoursWorked());
            System.out.println("Salary: $" + partTimeTester.calculateSalary());
        } else {
            System.out.println("Invalid choice");
        }

        scanner.close();
    }
}

abstract class GameTester {
    private String name;
    private boolean isFullTime;

    GameTester(final String name, final boolean isFullTime) {
        this.name = name;
        this.isFullTime = isFullTime;
    }

    public String getName() {
        return this.name;
    }

    public boolean getIsFullTime() {
        return this.isFullTime;
    }

    public abstract int calculateSalary();
}

class FullTimeGameTester extends GameTester {
    private static final int FULL_TIME_SALARY = 3000;

    FullTimeGameTester(final String name) {
        super(name, true);
    }

    @Override
    public int calculateSalary() {
        return FULL_TIME_SALARY;
    }
}

class PartTimeGameTester extends GameTester {
    private int hoursWorked;
    private static final int HOURLY_RATE = 20;

    PartTimeGameTester(final String name, final int hoursWorked) {
        super(name, false);
        this.hoursWorked = hoursWorked;
    }

    @Override
    public int calculateSalary() {
        return hoursWorked * HOURLY_RATE;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(final int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}
