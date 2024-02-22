package exercise1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of insurances: ");
        int numInsurances = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Insurance[] insurances = new Insurance[numInsurances];

        for (int i = 0; i < numInsurances; i++) {
            System.out.print("Enter type of insurance (Health/Life): ");
            String type = scanner.nextLine();

            System.out.print("Enter monthly fee: ");
            double monthlyFee = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            if ("Health".equalsIgnoreCase(type)) {
                insurances[i] = new Health(type);
            } else if ("Life".equalsIgnoreCase(type)) {
                insurances[i] = new Life(type);
            }

            if (insurances[i] != null) {
                insurances[i].setInsuranceCost(monthlyFee);
            }
        }

        System.out.println("Insurance Information:");
        displayInsuranceInfo(insurances);

        scanner.close();
    }

    private static void displayInsuranceInfo(Insurance[] insurances) {
        for (Insurance insurance : insurances) {
            insurance.displayInfo();
        }
    }
}

abstract class Insurance {
    private String type;
    double monthlyCost;

    public Insurance(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public abstract void setInsuranceCost(double cost);

    public abstract void displayInfo();
}

class Health extends Insurance {
    public Health(String type) {
        super(type);
    }

    @Override
    public void setInsuranceCost(double cost) {
        super.monthlyCost = cost;
    }

    @Override
    public void displayInfo() {
        System.out.println("Health Insurance: Type - " + getType() + ", Monthly Cost - $" + getMonthlyCost());
    }
}

class Life extends Insurance {
    public Life(String type) {
        super(type);
    }

    @Override
    public void setInsuranceCost(double cost) {
        super.monthlyCost = cost;
    }

    @Override
    public void displayInfo() {
        System.out.println("Life Insurance: Type - " + getType() + ", Monthly Cost - $" + getMonthlyCost());
    }
}
