package exercise2;

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
