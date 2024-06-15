public class MatrixExample {

    public static void main(String[] args) {
        int rows = 5;
        int cols = 5;

        int[][] matrix = new int[rows][cols];
        initializeMatrix(matrix);

        // Print the initialized matrix (optional)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void initializeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length; // Assuming all rows have the same length

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = -1;
            }
        }
    }
}