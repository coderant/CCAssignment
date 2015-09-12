package ch1;

public class Solution18NC {
    public static void setZero(int[][] mat) {

        if (mat.length != 0) {

            boolean[][] zeros = new boolean[mat.length][mat[0].length];

            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] == 0) {
                        markZero(zeros, i, j);
                    }
                }
            }

            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (zeros[i][j]) {
                        mat[i][j] = 0;
                    }
                }
            }
        }
    }

    private static void markZero(boolean[][] booleans, int i, int j) {
        for (int foo = 0; foo < booleans[0].length; foo++) {
            booleans[i][foo] = true;
        }
        for (int foo = 0; foo < booleans.length; foo++) {
            booleans[foo][j] = true;
        }
    }
}
