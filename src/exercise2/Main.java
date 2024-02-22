package exercise2;

public class Main {
    public static void main(String[] args) {
        // Create a full-time game tester
        GameTester fullTimeTester = new FullTimeGameTester("Alice");
        System.out.println("Full-time tester's salary: " + fullTimeTester.calculateSalary());

        // Create a part-time game tester
        GameTester partTimeTester = new PartTimeGameTester("Bob", 40); // 40 hours worked
        System.out.println("Part-time tester's salary: " + partTimeTester.calculateSalary());
    }
}
