package exercise1;

import java.util.Scanner;

public class InsuranceApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
        scanner.close();

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
