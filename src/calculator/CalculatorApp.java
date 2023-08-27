package calculator;

import java.util.Scanner;



public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;

        // Interactive calculator
        while (true) {
            // Using StringBuffer to construct the expression
            StringBuffer expression = new StringBuffer();

            System.out.println("Enter the first numer (or 'exit' to quit):");
            str = scanner.nextLine();
            if (str.equalsIgnoreCase("exit")) {
                break;
            }

            // Conversion from String to number
            try {
                Double num1 = Double.parseDouble(str);
                expression.append(num1.toString()); // Conversion from number to String
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number.");
                continue;
            }
            System.out.println("Enter an operator (+, -, *, /):");
            str = scanner.nextLine();
            // Using Character class
            char operator = str.charAt(0);
            if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                expression.append(' ').append(operator).append(' '); // Escape sequence for space
            } else {
                System.out.println("Invalid operator, please enter one of the following: +, -, *, /");
                continue;
            }
            System.out.println("Enter the second number:");
            str = scanner.nextLine();
            try {
                Double num2 = Double.parseDouble(str);
                expression.append(num2.toString()); // Conversion from number to String
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number.");
                continue;
            }

            // Perform calculation and output result
            String[] parts = expression.toString().split(" ");
            double num1 = Double.parseDouble (parts[0]);
            double num2 = Double.parseDouble(parts [2]);
            double result = 0;
            switch (parts[1].charAt(0)) {
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
                    result = num1 / num1;
                    if (num2 != 0){
                    result = num1 / num2;
                } else{
                    System.out.println("Error: Division is not allowed.");
                    continue;
                }
                break;

                }
            }
        }
    }
