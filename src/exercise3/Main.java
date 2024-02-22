package exercise3;

public class Main {
    public static void main(String[] args) {
        // Create an array of 3 mortgages
        Mortgage[] mortgages = new Mortgage[3];

        // Prompt the user for the current interest rate
        // For simplicity, let's assume it's 0.05
        double currentPrimeRate = 0.05;

        // Then in a loop prompts the user for a mortgage type and all relevant information for that mortgage.
        // For simplicity, let's assume we have the following data
        mortgages[0] = new BusinessMortgage(1, "Business 1", 200000, MortgageConstants.SHORT_TERM, currentPrimeRate);
        mortgages[1] = new PersonalMortgage(2, "Person 1", 250000, MortgageConstants.MEDIUM_TERM, currentPrimeRate);
        mortgages[2] = new BusinessMortgage(3, "Business 2", 300000, MortgageConstants.LONG_TERM, currentPrimeRate);

        // When data entry is complete, display all mortgages.
        for (Mortgage mortgage : mortgages) {
            System.out.println(mortgage.getMortgageInfo());
        }
    }
}
