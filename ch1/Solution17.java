package ch1;

public class Solution17 {
    public static void rotateInPlace(byte[][] matrix) {

        if (matrix == null) {
            return;
        }

        // check if a square matrix
        if (matrix[0].length != matrix.length) {
            throw new IllegalArgumentException("Not a Square matrix");
        }

        // begin recursive call
        rotateInPlace(matrix, matrix.length - 1);
    }

    // every call rotates the layerIndex-th layer in the matrix
    private static void rotateInPlace(byte[][] matrix, int layerIndex) {

        // there is only matrix.length / 2 number of layers
        if (layerIndex >= matrix.length / 2) {
            int layer = matrix.length - layerIndex - 1;
            for (int i = 0; i < matrix.length - 2 * layer - 1; i++) {
                rotatePoint(matrix, layer + i, layer);
            }

            // rotate next inner layer
            rotateInPlace(matrix, layerIndex - 1);
        }
    }

    // helper method to rotate the point at (x1, y1) and all four corresponding places
    private static void rotatePoint(byte[][] matrix, int x1, int y1) {
        int n = matrix.length - 1;
        byte foo = matrix[y1][n - x1];
        matrix[y1][n - x1] = matrix[x1][y1];
        matrix[x1][y1] = matrix[n - y1][x1];
        matrix[n - y1][x1] = matrix[n - x1][n - y1];
        matrix[n - x1][n - y1] = foo;
    }

    public static void main(String[] args) {
        testMatrix(generate(1), generate(2), generate(3), generate(12));
    }

    private static void testMatrix(byte[][]... matrix) {
        for (byte[][] b : matrix) {
            print(b);
            System.out.println("|");
            System.out.println("V");
            rotateInPlace(b);
            print(b);
            System.out.println("-----------------------------");
        }
    }

    private static byte[][] generate(int n) {
        byte[][] matrix = new byte[n][n];

        for (byte i = 0; i < n; i++) {
            for (byte j = 0; j < n; j++) {
                matrix[i][j] = (byte) (i * n + j + 1);
            }
        }
        return matrix;
    }

    private static void print(byte[][] a) {
        for (byte[] b : a) {
            for (byte c : b) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
