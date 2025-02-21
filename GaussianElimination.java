import java.util.Scanner;

public class GaussianElimination {

    // Function to perform Gaussian Elimination
    public static void gaussianElimination(double[][] matrix, int n) {
        System.out.println("\nStep-by-Step Gaussian Elimination Process:\n");

        for (int i = 0; i < n; i++) {
            // Partial Pivoting (Ensures numerical stability)
            int maxRow = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(matrix[k][i]) > Math.abs(matrix[maxRow][i])) {
                    maxRow = k;
                }
            }

            // Swap maximum row with current row
            double[] temp = matrix[i];
            matrix[i] = matrix[maxRow];
            matrix[maxRow] = temp;

            System.out.println("Pivoting: Swapped row " + (i + 1) + " with row " + (maxRow + 1));
            printMatrix(matrix, n);

            // Make diagonal element 1
            double diagElement = matrix[i][i];
            if (diagElement == 0) {
                System.out.println("No unique solution exists!");
                return;
            }

            for (int j = 0; j <= n; j++) {
                matrix[i][j] /= diagElement;
            }
            System.out.println("Making leading coefficient 1 in row " + (i + 1));
            printMatrix(matrix, n);

            // Make below rows 0
            for (int k = i + 1; k < n; k++) {
                double factor = matrix[k][i];
                for (int j = i; j <= n; j++) {
                    matrix[k][j] -= factor * matrix[i][j];
                }
                System.out.println("Eliminating element in row " + (k + 1) + ", column " + (i + 1));
                printMatrix(matrix, n);
            }
        }

        // Back Substitution
        double[] solution = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            solution[i] = matrix[i][n];
            for (int j = i + 1; j < n; j++) {
                solution[i] -= matrix[i][j] * solution[j];
            }
        }

        System.out.println("\nSolution:");
        for (int i = 0; i < n; i++) {
            System.out.println("x" + (i + 1) + " = " + solution[i]);
        }
    }

    // Function to print the matrix
    public static void printMatrix(double[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.printf("%8.3f", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    // Main function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of equations (size of matrix)
        System.out.print("Enter number of equations (size of matrix): ");
        int n = scanner.nextInt();

        double[][] matrix = new double[n][n + 1];

        System.out.println("Enter the augmented matrix (coefficients and constants):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        // Display initial matrix
        System.out.println("\nInitial Matrix:");
        printMatrix(matrix, n);

        // Solve using Gaussian Elimination
        gaussianElimination(matrix, n);

        scanner.close();
    }
}
