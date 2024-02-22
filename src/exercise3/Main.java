package exercise3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mortgage[] mortgages = new Mortgage[3];
        double currentInterestRate;

        // Prompt user for current interest rate
        System.out.print("Enter the current interest rate: ");
        currentInterestRate = scanner.nextDouble();

        // Consume newline character after reading double
        scanner.nextLine();

        // Loop to prompt user for mortgage information
        for (int i = 0; i < mortgages.length; i++) {
            System.out.println("\nEnter details for Mortgage " + (i + 1) + ":");

            // Prompt user for mortgage type
            System.out.print("Enter mortgage type (1 for Business, 2 for Personal): ");
            int mortgageType = scanner.nextInt();

            // Consume newline character after reading int
            scanner.nextLine();

            // Prompt user for common mortgage information
            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine();

            System.out.print("Enter mortgage amount: ");
            double mortgageAmount = scanner.nextDouble();

            System.out.print("Enter term (1 for short term, 3 for medium term, 5 for long term): ");
            int term = scanner.nextInt();

            // Create mortgage object based on user input
            if (mortgageType == 1) {
                mortgages[i] = new BusinessMortgage(i + 1, customerName, mortgageAmount, term, currentInterestRate);
            } else if (mortgageType == 2) {
                mortgages[i] = new PersonalMortgage(i + 1, customerName, mortgageAmount, term, currentInterestRate);
            } else {
                System.out.println("Invalid mortgage type. Skipping this mortgage.");
                continue;
            }
        }

        // Display all mortgages
        System.out.println("\n--- All Mortgages ---");
        for (Mortgage mortgage : mortgages) {
            System.out.println(mortgage.getMortgageInfo());
            System.out.println("---------------------");
        }

        scanner.close();
    }
}
