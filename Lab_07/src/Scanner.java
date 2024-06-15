import java.util.ArrayList;
import java.util.List;

public class Scanner {
    private String input;
    private int index;

    public Scanner(String input) {
        this.input = input;
        this.index = 0;
    }

    public List<String> tokenize() {
        List<String> tokens = new ArrayList<>();

        while (index < input.length()) {
            char currentChar = input.charAt(index);

            if (Character.isWhitespace(currentChar)) {
                // Skip whitespace
                index++;
            } else if (Character.isDigit(currentChar)) {
                // Handle multi-digit numbers
                StringBuilder number = new StringBuilder();
                while (index < input.length() && Character.isDigit(input.charAt(index))) {
                    number.append(input.charAt(index));
                    index++;
                }
                tokens.add(number.toString());
            } else if (isOperator(currentChar) || isParenthesis(currentChar)) {
                // Handle operators and parentheses
                tokens.add(String.valueOf(currentChar));
                index++;
            } else {
                throw new IllegalArgumentException("Invalid character in input: " + currentChar);
            }
        }

        return tokens;
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private boolean isParenthesis(char c) {
        return c == '(' || c == ')';
    }
}