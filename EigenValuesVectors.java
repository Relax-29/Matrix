import java.util.Scanner;

public class EigenValuesVectors {

    // Function to compute Eigenvalues of a 2x2 matrix
    public static double[] eigenValues2x2(double[][] matrix) {
        double a = matrix[0][0], b = matrix[0][1];
        double c = matrix[1][0], d = matrix[1][1];

        double trace = a + d;
        double determinant = (a * d) - (b * c);
        double discriminant = Math.sqrt(trace * trace - 4 * determinant);

        double lambda1 = (trace + discriminant) / 2;
        double lambda2 = (trace - discriminant) / 2;

        return new double[]{lambda1, lambda2};
    }

    // Function to compute Eigenvectors for a 2x2 matrix
    public static double[][] eigenVectors2x2(double[][] matrix, double[] eigenValues) {
        double[][] eigenVectors = new double[2][2];

        for (int i = 0; i < 2; i++) {
            double lambda = eigenValues[i];
            double a = matrix[0][0] - lambda, b = matrix[0][1];
            double c = matrix[1][0], d = matrix[1][1] - lambda;

            if (b != 0) {
                eigenVectors[i][0] = 1;
                eigenVectors[i][1] = -a / b;
            } else if (c != 0) {
                eigenVectors[i][0] = -d / c;
                eigenVectors[i][1] = 1;
            } else {
                eigenVectors[i][0] = 1;
                eigenVectors[i][1] = 0;
            }
        }

        return eigenVectors;
    }

    // Function to compute Eigenvalues of a 3x3 matrix using characteristic equation
    public static double[] eigenValues3x3(double[][] matrix) {
        double a = matrix[0][0], b = matrix[0][1], c = matrix[0][2];
        double d = matrix[1][0], e = matrix[1][1], f = matrix[1][2];
        double g = matrix[2][0], h = matrix[2][1], i = matrix[2][2];

        double trace = a + e + i;
        double determinant = a * (e * i - f * h) - b * (d * i - f * g) + c * (d * h - e * g);

        double p = trace / 3;
        double q = determinant / 2;
        double discriminant = Math.sqrt(p * p - q);

        double lambda1 = p + discriminant;
        double lambda2 = p - discriminant;
        double lambda3 = trace - lambda1 - lambda2;

        return new double[]{lambda1, lambda2, lambda3};
    }

    // Power Iteration method for finding dominant Eigenvalue and Eigenvector
    public static void powerIteration(double[][] matrix, int n, int iterations) {
        double[] vec = new double[n];
        double[] newVec = new double[n];

        for (int i = 0; i < n; i++) vec[i] = 1; // Start with a random vector

        double lambda = 0;
        for (int iter = 0; iter < iterations; iter++) {
            for (int i = 0; i < n; i++) {
                newVec[i] = 0;
                for (int j = 0; j < n; j++)
                    newVec[i] += matrix[i][j] * vec[j];
            }

            lambda = newVec[0]; // Take first element as approx eigenvalue
            for (int i = 0; i < n; i++) vec[i] = newVec[i] / lambda; // Normalize
        }

        System.out.println("\nApproximate Dominant Eigenvalue: " + lambda);
        System.out.print("Approximate Eigenvector: [");
        for (int i = 0; i < n; i++) {
            System.out.print(vec[i] + (i < n - 1 ? ", " : ""));
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter matrix size (2 or 3): ");
        int n = scanner.nextInt();

        double[][] matrix = new double[n][n];

        System.out.println("Enter matrix elements row-wise:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("\nMatrix Entered:");
        for (double[] row : matrix) {
            for (double num : row) {
                System.out.printf("%6.2f ", num);
            }
            System.out.println();
        }

        if (n == 2) {
            double[] eigenValues = eigenValues2x2(matrix);
            double[][] eigenVectors = eigenVectors2x2(matrix, eigenValues);

            System.out.println("\nEigenvalues:");
            for (double value : eigenValues) System.out.println(value);

            System.out.println("\nEigenvectors:");
            for (int i = 0; i < 2; i++) {
                System.out.println("Eigenvector for Eigenvalue " + eigenValues[i] + ": [" + eigenVectors[i][0] + ", " + eigenVectors[i][1] + "]");
            }
        } else if (n == 3) {
            double[] eigenValues = eigenValues3x3(matrix);
            System.out.println("\nEigenvalues:");
            for (double value : eigenValues) System.out.println(value);

            System.out.println("\nApplying Power Iteration for Approximate Eigenvector...");
            powerIteration(matrix, 3, 100);
        } else {
            System.out.println("Currently, only 2x2 and 3x3 matrices are supported.");
        }

        scanner.close();
    }
}
