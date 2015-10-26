package ch8;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Box {

    static long highestStack(int[][] boxes) {

//        int[][] sorted = new int[boxes.length][2];

        int[][] sorted = boxes;

//        for (int i = 0; i < boxes.length; i++) {
//            sorted[i][0] = boxes[i][0] * boxes[i][1];
//            sorted[i][1] = boxes[i][2];
//        }

        Arrays.sort(sorted, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] < o2[0]) {
                    return -1;
                } else {
                    return new Integer(o1[1]).compareTo(o2[1]);
                }
            }
        });

        long[] f = new long[sorted.length];

        f[0] = sorted[0][2];

        for (int i = 1; i < sorted.length; i++) {

            long max = 0;

            for (int j = 0; j < i; j++) {

                if (sorted[i][0] > sorted[j][0] && sorted[i][1] > sorted[j][1]) {
                    if (f[j] > max) {
                        max = f[j];
                    }
                }
            }
            f[i] = max + sorted[i][2];
        }

        long max = -1;

        for (int i = 0; i < sorted.length; i++) {
            if (max < f[i]) {
                max = f[i];
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine().trim());
        int[][] boxes = new int[N][3];
        for (int i = 0; i < N; i++) {
            String[] split = in.nextLine().split(" ");
            for (int j = 0; j < split.length; j++) {
                boxes[i][j] = Integer.parseInt(split[j]);
            }
        }
        System.out.println(highestStack(boxes));
        in.close();
    }
}
