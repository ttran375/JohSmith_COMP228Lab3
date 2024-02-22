package exercise2;

class FullTimeGameTester extends GameTester {
    public FullTimeGameTester(String name) {
        super(name, true);
    }

    @Override
    public double calculateSalary() {
        return 3000; // base salary
    }
}
