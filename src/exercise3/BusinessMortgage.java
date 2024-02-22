package exercise3;

class BusinessMortgage extends Mortgage {
    public BusinessMortgage(int mortgageNumber, String customerName, double mortgageAmount, int term, double currentPrimeRate) {
        super(mortgageNumber, customerName, mortgageAmount, currentPrimeRate + 0.01, term);
    }
}
