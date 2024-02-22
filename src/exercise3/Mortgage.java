package exercise3;

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

