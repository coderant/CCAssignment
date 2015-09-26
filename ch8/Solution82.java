package ch8;

import java.util.ArrayList;

public class Solution82 {

    public static ArrayList<int[]> getPath(boolean[][] grid) {

        return getPath(null, grid, new int[]{0, 0});

    }

    private static ArrayList<int[]> getPath(ArrayList<int[]> pathToken,
                                boolean[][] grid,
                                int[] current) {

        if (pathToken == null) {
            pathToken = new ArrayList<>();
        }

        if (current[0] == grid.length - 1 && current[1] == grid[0].length - 1) {
            pathToken.add(current);
            return pathToken;
        }

        if (current[0] >= grid.length || current[1] >= grid[0].length) {
            return null;
        }

        if (!grid[current[0]][current[1]]) {
            return null;
        }

        pathToken.add(current);

        ArrayList<int[]> downResult = getPath(pathToken, grid, new int[]{current[0] + 1, current[1]});
        ArrayList<int[]> rightResult = getPath(pathToken, grid, new int[]{current[0], current[1] + 1});

        if (downResult != null) {
            return downResult;
        }

        if (rightResult != null) {
            return rightResult;
        }

        pathToken.remove(current);

        return null;

    }

    // Test Method Below

    public static void main(String[] args) {
        boolean[][] grid = generateMatrix(12,6);

        printGrid(grid);

        ArrayList<int[]> path = getPath(grid);

        if (path == null) {
            System.out.println();
            System.out.println("Path does not exist!!!!");
            return;
        }

        printGrid(grid, path);

    }

    private static void printGrid(boolean[][] grid, ArrayList<int[]> steps) {
        System.out.println();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (i == steps.get(0)[0] && j == steps.get(0)[1]) {
                    sb.append(">, ");
                    steps.remove(0);
                } else {
                    if (grid[i][j]) {
                        sb.append("0, ");
                    } else {
                        sb.append("X, ");
                    }
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }

    private static void printGrid(boolean[][] grid) {

        for (boolean[] row : grid) {
            for (boolean vertice : row) {

                if (vertice) {
                    System.out.print("0, ");
                } else {
                    System.out.print("X, ");
                }
            }
            System.out.println();
        }

    }

    private static boolean[][] generateMatrix(int r, int c) {
        boolean[][] result = new boolean[r][c];

        double threshold = 0.9;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (Math.random() < threshold) {
                    result[i][j] = true;
                }
            }
        }

        return result;
    }

}
