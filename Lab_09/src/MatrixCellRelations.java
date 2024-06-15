public class MatrixCellRelations {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int r1 = 0, c1 = 1; // First cell (0, 1)
        int r2 = 2, c2 = 1; // Second cell (2, 1)

        // Check if cells are in the same row
        boolean sameRow = (r1 == r2);

        // Check if cells are in the same column
        boolean sameColumn = (c1 == c2);

        // Check if cells are in the same ascending diagonal (lower left to upper right)
        boolean sameAscendingDiagonal = (r1 - c1 == r2 - c2);

        // Check if cells are in the same descending diagonal (upper left to lower right)
        boolean sameDescendingDiagonal = (r1 + c1 == r2 + c2);

        // Output results
        System.out.println("Cells are in the same row: " + sameRow);
        System.out.println("Cells are in the same column: " + sameColumn);
        System.out.println("Cells are in the same ascending diagonal: " + sameAscendingDiagonal);
        System.out.println("Cells are in the same descending diagonal: " + sameDescendingDiagonal);
    }
}