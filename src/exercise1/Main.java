package exercise1;

import java.util.Scanner;

public final class Main {
    private Main() {
        // Prevent instantiation
    }

    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of insurances: ");
        int numInsurances = scanner.nextInt();
        scanner.nextLine();

        Insurance[] insurances = new Insurance[numInsurances];

        for (int i = 0; i < numInsurances; i++) {
            System.out.print("Enter type of insurance (Health/Life): ");
            String type = scanner.nextLine();

            System.out.print("Enter monthly fee: ");
            double monthlyFee = scanner.nextDouble();
            scanner.nextLine();

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

    private static void displayInsuranceInfo(final Insurance[] insurances) {
        for (Insurance insurance : insurances) {
            insurance.displayInfo();
        }
    }
}

abstract class Insurance {
    private String type;
    private double monthlyCost;

    public Insurance(final String insuranceType) {
        this.type = insuranceType;
    }

    public String getType() {
        return type;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(double cost) {
        this.monthlyCost = cost;
    }

    public abstract void setInsuranceCost(final double cost);

    public abstract void displayInfo();
}

class Health extends Insurance {
    public Health(final String type) {
        super(type);
    }

    @Override
    public void setInsuranceCost(final double cost) {
        super.setMonthlyCost(cost);
    }

    @Override
    public void displayInfo() {
        System.out.println("Health Insurance: Type - " + getType() 
            + ", Monthly Cost - $" + getMonthlyCost());
    }
}

class Life extends Insurance {
    public Life(final String type) {
        super(type);
    }

    @Override
    public void setInsuranceCost(final double cost) {
        super.setMonthlyCost(cost);
    }

    @Override
    public void displayInfo() {
        System.out.println("Life Insurance: Type - " + getType() 
            + ", Monthly Cost - $" + getMonthlyCost());
    }
}
