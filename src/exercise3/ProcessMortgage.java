package exercise3;

import java.util.Scanner;

public class ProcessMortgage {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int numberOfMortgages = 3;
        Mortgage[] mortgages = new Mortgage[numberOfMortgages];
        double currentInterestRate;

        System.out.print("Enter the current interest rate: ");
        currentInterestRate = scanner.nextDouble();

        scanner.nextLine();

        for (int i = 0; i < mortgages.length; i++) {
            System.out.println("\nEnter details for Mortgage " + (i + 1) + ":");

            System.out.print(
                    "Enter mortgage type (1 for Business, 2 for Personal): ");
            int mortgageType = scanner.nextInt();

            scanner.nextLine();

            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine();

            System.out.print("Enter mortgage amount: ");
            double mortgageAmount = scanner.nextDouble();

            System.out.print(
    "Enter term (1 for short term, 3 for medium term, 5 for long term): ");
            int term = scanner.nextInt();

            if (mortgageType == 1) {
                mortgages[i] = new BusinessMortgage(
                        i + 1,
                        customerName,
                        mortgageAmount,
                        term,
                        currentInterestRate);
            } else if (mortgageType == 2) {
                mortgages[i] = new PersonalMortgage(
                        i + 1,
                        customerName,
                        mortgageAmount,
                        term,
                        currentInterestRate);
            } else {
                System.out.println(
                        "Invalid mortgage type. Skipping this mortgage.");
                continue;
            }
        }

        System.out.println("\n--- All Mortgages ---");
        for (Mortgage mortgage : mortgages) {
            System.out.println(mortgage.getMortgageInfo());
            System.out.println("---------------------");
        }

        scanner.close();
    }
}

interface MortgageConstants {
    int SHORT_TERM = 1;
    int MEDIUM_TERM = 3;
    int LONG_TERM = 5;
    String BANK_NAME = "CityToronto Bank";
    double MAX_MORTGAGE_AMOUNT = 300000;
}

abstract class Mortgage implements MortgageConstants {
    private int mortgageNumber;
    private String customerName;
    private double mortgageAmount;
    private double interestRate;
    private int term;

    Mortgage(
            final int mortgageNumber,
            final String customerName,
            final double mortgageAmount,
            final double interestRate,
            final int term) {
        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;
        this.mortgageAmount = Math.min(mortgageAmount, MAX_MORTGAGE_AMOUNT);
        this.interestRate = interestRate;
        this.term = term == SHORT_TERM
                || term == MEDIUM_TERM
                || term == LONG_TERM
                        ? term
                        : SHORT_TERM;
    }

    int getMortgageNumber() {
        return mortgageNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getMortgageAmount() {
        return mortgageAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getTerm() {
        return term;
    }

    public String getMortgageInfo() {
        return "Mortgage Number: "
                + getMortgageNumber()
                + "\nCustomer Name: "
                + getCustomerName()
                + "\nMortgage Amount: "
                + getMortgageAmount()
                + "\nInterest Rate: "
                + getInterestRate()
                + "\nTerm: "
                + getTerm();
    }
}

class BusinessMortgage extends Mortgage {
    private static final double BUSINESS_RATE_ADDITION = 0.01;

    BusinessMortgage(
            final int mortgageNumber,
            final String customerName,
            final double mortgageAmount,
            final int term,
            final double currentPrimeRate) {
        super(mortgageNumber,
                customerName,
                mortgageAmount,
                currentPrimeRate + BUSINESS_RATE_ADDITION,
                term);
    }
}

class PersonalMortgage extends Mortgage {
    private static final double PERSONAL_RATE_ADDITION = 0.02;

    PersonalMortgage(
            final int mortgageNumber,
            final String customerName,
            final double mortgageAmount,
            final int term,
            final double currentPrimeRate) {
        super(
                mortgageNumber,
                customerName,
                mortgageAmount,
                currentPrimeRate + PERSONAL_RATE_ADDITION,
                term);
    }
}
