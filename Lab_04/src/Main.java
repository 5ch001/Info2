public class Main {
    public static void main(String[] args) {
        char originalChar = 'a';
        char normalizedChar = normalizeChar(originalChar);
        System.out.println("Original character: " + originalChar);
        System.out.println("Normalized character: " + normalizedChar);
    }

    public static char normalizeChar(char ch) {
        // Check if the character is a lowercase letter
        if (ch >= 'a' && ch <= 'z') {
            // Convert to uppercase by subtracting the ASCII difference
            return (char) (ch - 'a' + 'A');
        }
        // Check if the character is an uppercase letter
        else if (ch >= 'A' && ch <= 'Z') {
            // Convert to lowercase by adding the ASCII difference
            return (char) (ch - 'A' + 'a');
        }
        // If the character is not a letter, return it unchanged
        else {
            return ch;
        }
    }
}