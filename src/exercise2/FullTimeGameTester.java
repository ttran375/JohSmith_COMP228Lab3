package exercise2;

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
