package exercise3;

class PersonalMortgage extends Mortgage {
    public PersonalMortgage(int mortgageNumber, String customerName, double mortgageAmount, int term, double currentPrimeRate) {
        super(mortgageNumber, customerName, mortgageAmount, currentPrimeRate + 0.02, term);
    }
}
