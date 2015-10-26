package ch8;

import java.util.Arrays;

public class MultipleSteps {

    static long[] countPaths(int[] A, int[] T) {

        int[] T1 = T.clone();

        Arrays.sort(T1);

        long[] result = new long[T.length];

        int t = T1[T1.length - 1];

        long[] f = new long[t + 1];

        f[0] = 1;

        for (int step : A) {
            if (step < f.length) {
                f[step] = 1;
            }
        }

        for (int i = 1; i < f.length; i++) {
            for (int step : A) {
                if (i > step) {
                    f[i] += f[i - step];
                    f[i] %= 1E9 + 7;
                }
            }
        }



        for (int j = 0; j < T.length; j++) {
            result[j] = f[T[j]];
        }

        return result;

    }

    static long[] countPaths2(int[] A, int[] T) {

        long[] result = new long[T.length];

        for (int j = 0; j < T.length; j++) {

            int t = T[j];

            if (t == 0) {
                result[j] = 1;
                continue;
            }

            long[] f = new long[t + 1];

            for (int step : A) {
                if (step < f.length) {
                    f[step] = 1;
                }
            }

            for (int i = 1; i < f.length; i++) {
                for (int step : A) {
                    if (i > step) {
                        f[i] += f[i - step];
                        f[i] %= 1E9 + 7;
                    }
                }
            }

            result[j] = (long) (f[t] % (1E9+7));
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(countPaths(new int[]{5,9,13,33,40,49}, new int[]{4,5,21,53,74}));
    }

}
