import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2, result;
        char operator;
        boolean continueCalculation = true;

        while (continueCalculation) {
            System.out.println("Enter first number (or 'E' to exit):");
            String input = scanner.next();

            if (input.equalsIgnoreCase("E")) {
                System.out.println("Exiting calculator.");
                break;
            } else {
                num1 = Double.parseDouble(input);
            }

            System.out.println("Enter an operator (+, -, *, /):");
            operator = scanner.next().charAt(0);

            System.out.println("Enter second number:");
            num2 = scanner.nextDouble();

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Error: Division by zero");
                        continue;
                    }
                    break;
                default:
                    System.out.println("Error: Invalid operator");
                    continue;
            }

            System.out.println("The result is: " + result);
            
            System.out.println("Enter 'C' to continue or 'E' to exit:");
            input = scanner.next();

            if (input.equalsIgnoreCase("C")) {
                continue;
            } else if (input.equalsIgnoreCase("E")) {
                continueCalculation = false;
                System.out.println("Exiting calculator.");
            } else {
                System.out.println("Invalid input. Exiting calculator.");
                continueCalculation = false;
            }
        }
        scanner.close();
    }
}
