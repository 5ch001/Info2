import java.util.Scanner;
import java.util.Stack;

public class Postfix {

    public static double evaluate(String postfixExpression) throws IllegalArgumentException {
        Stack<Double> stack = new Stack<>();
        String[] tokens = postfixExpression.split("\\s+");

        for (String token : tokens) {
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                // If token is a number, push it onto the stack
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                // If token is an operator, pop operands from stack, apply operator, and push result back
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression: insufficient operands for operator " + token);
                }
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = applyOperator(token.charAt(0), operand1, operand2);
                stack.push(result);
            } else {
                throw new IllegalArgumentException("Invalid token in postfix expression: " + token);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression: more than one operand remaining");
        }

        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.length() == 1 && (token.charAt(0) == '+' || token.charAt(0) == '-' ||
                token.charAt(0) == '*' || token.charAt(0) == '/');
    }

    private static double applyOperator(char operator, double operand1, double operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new IllegalArgumentException("Division by zero is not allowed");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
    }

    public static void evaluateAndPrintResultFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a postfix expression: ");
        String postfixExpression = scanner.nextLine().trim();

        try {
            double result = evaluate(postfixExpression);
            System.out.println("Result of postfix expression '" + postfixExpression + "' is: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error evaluating postfix expression: " + e.getMessage());
        }

        scanner.close();
    }

    public static void main(String[] args) {
        // Example usage
        try {
            String postfixExpression = "3 5 10 4 - * +";
            double result = evaluate(postfixExpression);
            System.out.println("Result of postfix expression '" + postfixExpression + "' is: " + result); // Output: 23.0
        } catch (IllegalArgumentException e) {
            System.out.println("Error evaluating postfix expression: " + e.getMessage());
        }

        // Evaluate expression from console input
        evaluateAndPrintResultFromConsole();
    }
}
