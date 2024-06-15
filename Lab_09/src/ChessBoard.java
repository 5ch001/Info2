import javax.swing.*;
import java.awt.*;

public class ChessBoard {

    JFrame frame;
    JPanel squares[][] = new JPanel[8][8];
    char[][] boardState = new char[8][8]; // Board state to track queens ('Q') and empty squares ('-')

    public ChessBoard() {
        frame = new JFrame("Simplified Chess");
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(8, 8));

        // Create the chessboard grid
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squares[i][j] = new JPanel();

                if ((i + j) % 2 == 0) {
                    squares[i][j].setBackground(Color.black);
                } else {
                    squares[i][j].setBackground(Color.white);
                }
                frame.add(squares[i][j]);
            }
        }

        solveNQueens(0); // Start solving from the first row (row 0)

        // Check and print all solutions
        if (!findAllSolutions()) {
            System.out.println("No solutions found.");
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Recursive method to solve N-Queens problem
    private boolean solveNQueens(int row) {
        // Base case: If all queens are placed successfully
        if (row >= 8) {
            return true;
        }

        // Try placing queen in each column of the current row
        for (int col = 0; col < 8; col++) {
            // Check if placing a queen at board[row][col] is safe
            if (isSafe(row, col)) {
                // Place the queen
                boardState[row][col] = 'Q';

                // Recur to place rest of the queens
                if (solveNQueens(row + 1)) {
                    return true; // If placing queens from row+1 onwards is successful, return true
                }

                // Backtrack: Remove the queen and try next column
                boardState[row][col] = '-';
            }
        }

        return false; // No solution found for this row
    }

    // Method to find all solutions to N-Queens problem
    private boolean findAllSolutions() {
        return findSolution(0);
    }

    // Helper method to find solutions recursively
    private boolean findSolution(int row) {
        // Base case: If all queens are placed successfully
        if (row >= 8) {
            printSolution(); // Print the found solution
            return true;
        }

        boolean foundSolution = false;

        // Try placing queen in each column of the current row
        for (int col = 0; col < 8; col++) {
            // Check if placing a queen at board[row][col] is safe
            if (isSafe(row, col)) {
                // Place the queen
                boardState[row][col] = 'Q';

                // Recur to place rest of the queens
                if (findSolution(row + 1)) {
                    foundSolution = true; // Mark solution found
                }

                // Backtrack: Remove the queen and try next column
                boardState[row][col] = '-';
            }
        }

        return foundSolution; // Return whether a solution was found for this row
    }

    // Method to check if placing a queen at board[row][col] is safe
    private boolean isSafe(int row, int col) {
        // Check the column
        for (int i = 0; i < row; i++) {
            if (boardState[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (boardState[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper diagonal on right side
        for (int i = row, j = col; i >= 0 && j < 8; i--, j++) {
            if (boardState[i][j] == 'Q') {
                return false;
            }
        }

        return true; // No conflicts found, safe to place queen at board[row][col]
    }

    // Method to print the current board state as a solution
    private void printSolution() {
        System.out.println("Solution found:");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (boardState[i][j] == 'Q') {
                    System.out.print("Q ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // Main method and other existing code remain unchanged
    public static void main(String[] args) {
        new ChessBoard();
    }
}
