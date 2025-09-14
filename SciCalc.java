package alicekbabieh.projects.scicalc;

import java.util.Scanner;
public class SciCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculations c = new Calculations();
        System.out.println("Welcome to the text-based Scientific Calculator ");

        while (true) {
            System.out.println("\nAvailable operations:");
            System.out.println("Binary: +  -  *  /  ^");
            System.out.println("Unary: √  sin  cos  tan");
            System.out.println("Commands: history  exit");
            System.out.print("Enter operation: ");
            String op = scanner.nextLine().trim();

            if (op.equalsIgnoreCase("exit")) break;
            if (op.equalsIgnoreCase("history")) {
                c.printHistory();
                continue;
            }
            try {
                double a, b = 0;
                // Binary operations
                if (OperationMap.isBinary(op)) {
                    System.out.print("Enter first number: ");
                    a = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter second number: ");
                    b = Double.parseDouble(scanner.nextLine());
                    double result = c.calculate(op, a, b);
                    System.out.println("Result: " + result);
                } 
                // Unary operations
                else if (OperationMap.isUnary(op)) {
                    System.out.print("Enter number: ");
                    a = Double.parseDouble(scanner.nextLine());
                    double result = c.calculate(op, a, null);
                    System.out.println("Result: " + result);
                } 
                // Unknown operation
                else {
                    System.out.println("Unknown operation: " + op);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter a valid number.");
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("Goodbye!");
        scanner.close();
    }
}