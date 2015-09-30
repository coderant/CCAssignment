package ch10;

import java.util.Arrays;
import java.util.Random;

public class Solution109 {

    // search starts from the lower left corner
    // if the element is larger than target, move up
    // if the element is smaller than target, move right
    // if the element is target, return the index
    // if moving out of range, return NOT FOUND

    public static int[] search(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int currentM = m - 1;
        int currentN = 0;

        while (true) {

            if (currentM < 0 || currentN >= n) {
                return new int[]{-1, -1};
            }

            int current = matrix[currentM][currentN];

            if (current == target) {
                return new int[]{currentM, currentN};
            }

            if (current > target) {
                currentM--;
                continue;
            }

            if (current < target) {
                currentN++;
                continue;
            }
        }
    }

    // Test Method Below

    public static void main(String[] args) {
        int[][] matrix = getMatrix(10,10);

        print2DArray(matrix);

        System.out.println("[-1, -1] means not found");

        for (int i = 0; i < 20; i++) {
            int target = ((int) (Math.random() * matrix[9][9]));

            int[] result = search(matrix, target);


            System.out.println(target + "  is at: " + Arrays.toString(result));

        }

    }

    private static void print2DArray(int[][] array) {

        for (int[] row : array) {
            for (int foo : row) {

                System.out.format("%4d, ", foo);

            }
            System.out.println();
        }

    }

    private static int[][] getMatrix(int m, int n) {

        int[][] result = new int[m][n];

        result[0][0] = 0;

        Random generator = new Random();

        for (int i = 1; i < m; i++) {
            while (true) {
                int candidate = generator.nextInt(2*i + 3);
                if (candidate > result[i - 1][0]) {
                    result[i][0] = candidate;
                    break;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            while (true) {
                int candidate = generator.nextInt(2*i+3);
                if (candidate > result[0][i - 1]) {
                    result[0][i] = candidate;
                    break;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                while (true) {
                    int candidate = generator.nextInt(5*(i+j)+20);
                    if (candidate > result[i - 1][j] && candidate > result[i][j - 1]) {
                        result[i][j] = candidate;
                        break;
                    }
                }
            }
        }

        return result;

    }

}
