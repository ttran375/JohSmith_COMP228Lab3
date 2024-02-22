package exercise2;

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
