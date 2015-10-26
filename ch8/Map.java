package ch8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Map {

    static void getPath(boolean[][] map) {

        LinkedList<int[]> queue = new LinkedList<int[]>();
        long[][] numberOfPath = new long[map.length][map[0].length];
        long[][] distance = new long[map.length][map[0].length];
        boolean[][] visited = new boolean[map.length][map[0].length];

        numberOfPath[0][0] = 1;
        distance[0][0] = 0;
        visited[0][0] = true;

        queue.add(new int[]{0,0});
        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();

                int x = point[0];
                int y = point[1];

                if (x - 1 >= 0 && x - 1 < numberOfPath.length && y >= 0 && y < numberOfPath[0].length && map[x - 1][y]) {

                    if (visited[x - 1][y]) {
                        if (distance[x - 1][y] > distance[x][y] + 1) {
                            distance[x - 1][y] = distance[x][y] + 1;
                            numberOfPath[x - 1][y] = numberOfPath[x][y];
                        } else if (distance[x - 1][y] == distance[x][y] + 1) {
                            numberOfPath[x - 1][y] += numberOfPath[x][y];
                            numberOfPath[x - 1][y] %= 1E9 + 7;
                        }
                    } else {
                        queue.add(new int[]{x - 1, y});

                        visited[x - 1][y] = true;
                        distance[x - 1][y] = distance[x][y] + 1;
                        numberOfPath[x - 1][y] = numberOfPath[x][y];
                    }
                }

                if (x + 1 >= 0 && x + 1 < numberOfPath.length && y >= 0 && y < numberOfPath[0].length && map[x + 1][y]) {
                    if (visited[x + 1][y]) {
                        if (distance[x + 1][y] > distance[x][y] + 1) {
                            distance[x + 1][y] = distance[x][y] + 1;
                            numberOfPath[x + 1][y] = numberOfPath[x][y];
                        } else if (distance[x + 1][y] == distance[x][y] + 1) {
                            numberOfPath[x + 1][y] += numberOfPath[x][y];
                            numberOfPath[x + 1][y] %= 1E9 + 7;
                        }
                    } else {
                        queue.add(new int[]{x + 1, y});

                        visited[x + 1][y] = true;
                        distance[x + 1][y] = distance[x][y] + 1;
                        numberOfPath[x + 1][y] = numberOfPath[x][y];
                    }

                }

                if (x >= 0 && x < numberOfPath.length && y - 1 >= 0 && y - 1 < numberOfPath[0].length && map[x][y - 1]) {
                    if (visited[x][y - 1]) {
                        if (distance[x][y - 1] > distance[x][y] + 1) {
                            distance[x][y - 1] = distance[x][y] + 1;
                            numberOfPath[x][y - 1] = numberOfPath[x][y];
                        } else if (distance[x][y - 1] == distance[x][y] + 1) {
                            numberOfPath[x][y - 1] += numberOfPath[x][y];
                            numberOfPath[x][y - 1] %= 1E9 + 7;
                        }
                    } else {
                        queue.add(new int[]{x, y - 1});

                        visited[x][y - 1] = true;
                        distance[x][y - 1] = distance[x][y] + 1;
                        numberOfPath[x][y - 1] = numberOfPath[x][y];
                    }
                }

                if (x >= 0 && x < numberOfPath.length && y + 1 >= 0 && y + 1 < numberOfPath[0].length && map[x][y + 1]) {
                    if (visited[x][y + 1]) {
                        if (distance[x][y + 1] > distance[x][y] + 1) {
                            distance[x][y + 1] = distance[x][y] + 1;
                            numberOfPath[x][y + 1] = numberOfPath[x][y];
                        } else if (distance[x][y + 1] == distance[x][y] + 1) {
                            numberOfPath[x][y + 1] += numberOfPath[x][y];
                            numberOfPath[x][y + 1] %= 1E9 + 7;
                        }
                    } else {
                        queue.add(new int[]{x, y + 1});

                        visited[x][y + 1] = true;
                        distance[x][y + 1] = distance[x][y] + 1;
                        numberOfPath[x][y + 1] = numberOfPath[x][y];
                    }

                }
                System.out.println("Distance is: ");
                print(distance, map);
                System.out.println("Number of shortest path is: ");
                print(numberOfPath, map);
                System.out.println("Visited is :");
                print(visited, map);
                System.out.println("------------------------------------------");
            }
        }

        System.out.println(numberOfPath[numberOfPath.length - 1][numberOfPath[0].length - 1]);

        if (distance[distance.length - 1][distance[0].length - 1] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(distance[distance.length - 1][distance[0].length - 1]);
        }

    }

    private static void print(LinkedList<int[]> queue) {
        for (int[] point : queue) {
            System.out.print(Arrays.toString(point));
            System.out.print("  ");
        }
        System.out.println();
    }

    private static void print(boolean[][] matrix, boolean[][] map) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (map[i][j]) {
                    if (matrix[i][j]) {
                        System.out.print("√");
                    } else {
                        System.out.print("O");
                    }
                } else {
                    System.out.print("X");
                }
                System.out.print("   ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void print(long[][] matrix, boolean[][] map) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (map[i][j]) {
                    System.out.print(matrix[i][j]);
                } else {
                    System.out.print("X");
                }
                System.out.print("   ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void processPoint(int x, int y, long[][] numberOfPath, long[][] distance, boolean[][] visited, boolean[][] map, LinkedList<int[]> queue) {



        if (map[x][y + 1] && x >= 0 && x < numberOfPath.length && y - 1 >= 0 && y - 1 < numberOfPath[0].length) {
            if (visited[x - 1][y]) {
                if (distance[x - 1][y] > distance[x][y] + 1) {
                    distance[x - 1][y] = distance[x][y] + 1;
                } else if (distance[x - 1][y] == distance[x][y] + 1) {
                    numberOfPath[x - 1][y] += numberOfPath[x][y];
                }
            } else {
                queue.add(new int[]{x - 1, y});

                visited[x - 1][y] = true;
                distance[x - 1][y] = distance[x][y] + 1;
                numberOfPath[x - 1][y] = numberOfPath[x][y];
            }

        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] dimension = in.nextLine().split(" ");
        boolean[][] matrix = new boolean[Integer.parseInt(dimension[0])][Integer.parseInt(dimension[1])];

        for (int j = 0; j < matrix.length; j++) {

            boolean[] rowRead = new boolean[matrix[0].length];

            String rowString = in.nextLine();

            for (int i = 0; i < rowRead.length; i++) {
                rowRead[i] = rowString.charAt(i) == 'o';
            }
            matrix[j] = rowRead;
        }
        getPath(matrix);
    }
}
