package exercise3;

import java.util.Scanner;

interface MortgageConstants {
    String BANK_NAME = "CityToronto";
    int MAXIMUM_AMOUNT = 300000;
    int SHORT_TERM = 1;
    int MEDIUM_TERM = 3;
    int LONG_TERM = 5;
}

abstract class Mortgage implements MortgageConstants {
    private int mortgageNumber;
    private String customerName;
    private double mortgageAmount;
    protected double interestRate;
    private int term;

    public Mortgage(int mortgageNumber, String customerName, double mortgageAmount, int term) {
        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;

        // Ensure mortgage amount does not exceed the maximum limit
        if (mortgageAmount > MAXIMUM_AMOUNT) {
            this.mortgageAmount = MAXIMUM_AMOUNT;
        } else {
            this.mortgageAmount = mortgageAmount;
        }

        // Set the term to a valid value defined in MortgageConstants
        if (term == SHORT_TERM || term == MEDIUM_TERM || term == LONG_TERM) {
            this.term = term;
        } else {
            this.term = SHORT_TERM; // Default to short-term for undefined terms
        }
    }

    public abstract void setInterestRate(double rate);

    public double calculateTotalAmountOwed() {
        double interest = mortgageAmount * interestRate * term;
        return mortgageAmount + interest;
    }

    public void getMortgageInfo() {
        System.out.println("Mortgage Number: " + mortgageNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Mortgage Amount: $" + mortgageAmount);
        System.out.println("Interest Rate: " + interestRate * 100 + "%");
        System.out.println("Term: " + term + " years");
        System.out.println("Total Amount Owed: $" + calculateTotalAmountOwed());
    }
}

class BusinessMortgage extends Mortgage {
    public BusinessMortgage(int mortgageNumber, String customerName, double mortgageAmount, int term) {
        super(mortgageNumber, customerName, mortgageAmount, term);
        setInterestRate(0.01); // 1% over the current prime rate
    }

    @Override
    public void setInterestRate(double rate) {
        super.interestRate = rate;
    }
}

class PersonalMortgage extends Mortgage {
    public PersonalMortgage(int mortgageNumber, String customerName, double mortgageAmount, int term) {
        super(mortgageNumber, customerName, mortgageAmount, term);
        setInterestRate(0.02); // 2% over the current prime rate
    }

    @Override
    public void setInterestRate(double rate) {
        super.interestRate = rate;
    }
}

public class ProcessMortgage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the current interest rate: ");

        Mortgage[] mortgages = new Mortgage[3];

        for (int i = 0; i < mortgages.length; i++) {
            System.out.println("Enter mortgage type (1. Business, 2. Personal): ");
            int mortgageType = scanner.nextInt();

            System.out.print("Enter mortgage number: ");
            int mortgageNumber = scanner.nextInt();

            System.out.print("Enter customer name: ");
            String customerName = scanner.next();

            System.out.print("Enter mortgage amount: ");
            double mortgageAmount = scanner.nextDouble();

            System.out.print("Enter mortgage term (1. Short-term, 2. Medium-term, 3. Long-term): ");
            int term = scanner.nextInt();

            if (mortgageType == 1) {
                mortgages[i] = new BusinessMortgage(mortgageNumber, customerName, mortgageAmount, term);
            } else {
                mortgages[i] = new PersonalMortgage(mortgageNumber, customerName, mortgageAmount, term);
            }
        }

        // Display all mortgages
        for (Mortgage mortgage : mortgages) {
            mortgage.getMortgageInfo();
            System.out.println();
        }

        scanner.close();
    }
}
