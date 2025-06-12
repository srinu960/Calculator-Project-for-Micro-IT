import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enhanced Calculator");
        System.out.println("------------------");
        
        while (true) {
            try {
                System.out.println("\nOperations available:");
                System.out.println("1. Addition (+)");
                System.out.println("2. Subtraction (-)");
                System.out.println("3. Multiplication (*)");
                System.out.println("4. Division (/)");
                System.out.println("5. Modulus (%)");
                System.out.println("6. Power (^)");
                System.out.println("7. Square Root (√)");
                System.out.println("8. Exit");
                System.out.print("Enter your choice (1-8): ");
                
                int choice = getValidIntegerInput(scanner, 1, 8);
                
                if (choice == 8) {
                    System.out.println("Thank you for using the calculator. Goodbye!");
                    break;
                }
                
                double num1 = 0, num2 = 0, result = 0;
                String operation = "";
                
                if (choice != 7) { // All operations except square root need two numbers
                    System.out.print("Enter first number: ");
                    num1 = getValidDoubleInput(scanner);
                    
                    System.out.print("Enter second number: ");
                    num2 = getValidDoubleInput(scanner);
                } else { // Square root only needs one number
                    System.out.print("Enter number: ");
                    num1 = getValidDoubleInput(scanner);
                }
                
                switch (choice) {
                    case 1:
                        result = num1 + num2;
                        operation = "+";
                        break;
                    case 2:
                        result = num1 - num2;
                        operation = "-";
                        break;
                    case 3:
                        result = num1 * num2;
                        operation = "*";
                        break;
                    case 4:
                        if (num2 == 0) {
                            System.out.println("Error: Division by zero is not allowed!");
                            continue;
                        }
                        result = num1 / num2;
                        operation = "/";
                        break;
                    case 5:
                        result = num1 % num2;
                        operation = "%";
                        break;
                    case 6:
                        result = Math.pow(num1, num2);
                        operation = "^";
                        break;
                    case 7:
                        if (num1 < 0) {
                            System.out.println("Error: Cannot calculate square root of negative number!");
                            continue;
                        }
                        result = Math.sqrt(num1);
                        System.out.printf("\nResult: √%.2f = %.2f\n", num1, result);
                        continue;
                    default:
                        System.out.println("Invalid operation selected!");
                        continue;
                }
                
                System.out.printf("\nResult: %.2f %s %.2f = %.2f\n", num1, operation, num2, result);
                
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                scanner.nextLine(); // Clear the buffer
            }
        }
        
        scanner.close();
    }
    
    private static int getValidIntegerInput(Scanner scanner, int min, int max) {
        while (true) {
            try {
                int input = scanner.nextInt();
                if (input < min || input > max) {
                    System.out.printf("Please enter a number between %d and %d: ", min, max);
                    continue;
                }
                return input;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a valid integer: ");
                scanner.next(); // Clear the invalid input
            }
        }
    }
    
    private static double getValidDoubleInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
                scanner.next(); // Clear the invalid input
            }
        }
    }
}