
package exercise1;

import java.util.Scanner;

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

public class InsuranceApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();

        Insurance[] insurances = new Insurance[2];

        System.out.print("Enter Health Insurance type: ");
        String healthType = scanner.nextLine();
        System.out.print("Enter monthly cost for Health Insurance: ");
        double healthCost = scanner.nextDouble();
        scanner.nextLine();

        Health healthInsurance = new Health(healthType);
        healthInsurance.setInsuranceCost(healthCost);
        insurances[0] = healthInsurance;

        System.out.print("Enter Life Insurance type: ");
        String lifeType = scanner.nextLine();
        System.out.print("Enter monthly cost for Life Insurance: ");
        double lifeCost = scanner.nextDouble();

        Life lifeInsurance = new Life(lifeType);
        lifeInsurance.setInsuranceCost(lifeCost);
        insurances[1] = lifeInsurance;

        displayInsuranceInfo(insurances);
    }

    private static void displayInsuranceInfo(Insurance[] insurances) {
        for (Insurance insurance : insurances) {
            insurance.displayInfo();
        }
    }
}
