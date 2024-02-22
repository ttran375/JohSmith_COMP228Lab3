package exercise3;

import java.util.Scanner;

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
