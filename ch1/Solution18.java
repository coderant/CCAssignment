package ch1;

public class Solution18 {

    /* two runs
    *  first run: whenever encountered with a 0, mark all unit in row and column in a separate
    *             two-dimensional boolean array as true
    *  second run: according to the boolean array, when the corresponding boolean is true, set mat to 0*/

    public static void setZero(int[][] mat) {

        if (mat.length != 0) {

            boolean[][] zeros = new boolean[mat.length][mat[0].length];

            // first run
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] == 0) {
                        markZero(zeros, i, j);
                    }
                }
            }

            // second run
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (zeros[i][j]) {
                        mat[i][j] = 0;
                    }
                }
            }
        }
    }

    // helper method to mark units in this row and column
    private static void markZero(boolean[][] booleans, int i, int j) {
        for (int foo = 0; foo < booleans[0].length; foo++) {
            booleans[i][foo] = true;
        }
        for (int foo = 0; foo < booleans.length; foo++) {
            booleans[foo][j] = true;
        }
    }
}
