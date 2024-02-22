package exercise2;

class PartTimeGameTester extends GameTester {
    public int hoursWorked;

    public PartTimeGameTester(String name, int hoursWorked) {
        super(name, false);
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * 20; // $20 per hour
    }
}
