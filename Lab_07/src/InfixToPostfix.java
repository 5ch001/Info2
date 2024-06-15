import java.util.ArrayList;
import java.util.List;

public class InfixToPostfix extends Scanner {
    public InfixToPostfix(String input) {
        super(input);
    }

    public String toPostfix() throws StackUnderflowException {
        List<String> tokens = tokenize();
        Stack<String> stack = new Stack<>();
        List<String> output = new ArrayList<>();

        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))) {
                output.add(token);
            } else if (isOperator(token.charAt(0))) {
                while (!stack.isEmpty() && isOperator(stack.peek().charAt(0)) &&
                        ((isLeftAssociative(token.charAt(0)) && precedence(token.charAt(0)) <= precedence(stack.peek().charAt(0))) ||
                                (!isLeftAssociative(token.charAt(0)) && precedence(token.charAt(0)) < precedence(stack.peek().charAt(0))))) {
                    output.add(stack.pop());
                }
                stack.push(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    output.add(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek().equals("(")) {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            output.add(stack.pop());
        }

        return String.join(" ", output);
    }

    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    private boolean isLeftAssociative(char operator) {
        switch (operator) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
            default:
                return false;
        }
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private boolean isParenthesis(char c) {
        return c == '(' || c == ')';
    }
}