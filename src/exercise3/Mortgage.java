package exercise3;

abstract class Mortgage implements MortgageConstants {
    protected int mortgageNumber;
    protected String customerName;
    protected double mortgageAmount;
    protected double interestRate;
    protected int term;

    public Mortgage(int mortgageNumber, String customerName, double mortgageAmount, double interestRate, int term) {
        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;
        this.mortgageAmount = Math.min(mortgageAmount, MAX_MORTGAGE_AMOUNT);
        this.interestRate = interestRate;
        this.term = term == SHORT_TERM || term == MEDIUM_TERM || term == LONG_TERM ? term : SHORT_TERM;
    }

    public String getMortgageInfo() {
        return "Mortgage Number: " + mortgageNumber + "\nCustomer Name: " + customerName + "\nMortgage Amount: " + mortgageAmount + "\nInterest Rate: " + interestRate + "\nTerm: " + term;
    }
}
