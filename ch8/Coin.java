package ch8;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Coin {


    static long[] countCoin(int[] coins, int[] sums) {
        long[] result = new long[sums.length];

        Arrays.sort(coins);

        int[] sums2 = sums.clone();

        Arrays.sort(sums2);

        long[][] f = count(coins, sums2[sums2.length]);

        for (int j = 0; j < sums.length; j++) {

            int target2 = sums[j];

            result[j] = ((long) (f[coins.length][target2] % (1E9 + 7)));

        }

        return result;
    }

    public static long[][] count2(int[] coins, int target) {

        long[][] f = new long[coins.length + 1][target + 1];

        for (int coinIndex = 0; coinIndex <= coins.length; coinIndex++) {
            f[coinIndex][0] = 1;
        }

        for (int sum = 1; sum <= target; sum++) {
            f[0][sum] = 0;
        }

        for (int coinIndex = 1; coinIndex <= coins.length; coinIndex++) {
            for (int sum = 1; sum <= target; sum++) {

                int k = 0;

                while (sum - k * coins[coinIndex - 1] >= 0) {
                    f[coinIndex][sum] += f[coinIndex - 1][sum - k * coins[coinIndex - 1]];
                }
            }
        }

        return f;

    }

    public static long[][] count(int[] coins, int target) {

        long[][] f = new long[coins.length + 1][target + 1];

        for (int coinIndex = 0; coinIndex <= coins.length; coinIndex++) {
            f[coinIndex][0] = 1;
        }

        for (int sum = 0; sum <= target; sum++) {
            f[0][sum] = 0;
        }


        for (int coinIndex = 1; coinIndex <= coins.length; coinIndex++) {
            for (int sum = 1; sum <= target; sum++) {

                f[coinIndex][sum] += f[coinIndex - 1][sum];
                f[coinIndex][sum] %= 1E9 + 7;

                if (sum - coins[coinIndex - 1] >= 0) {
                    f[coinIndex][sum] += f[coinIndex][sum - coins[coinIndex - 1]];
                    f[coinIndex][sum] %= 1E9 + 7;
                }
            }
        }

        return f;
    }


    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        int[] A = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            A[i] = Integer.parseInt(split[i]);
        }

        int N = Integer.parseInt(in.nextLine().trim());
        int[] T = new int[N];

        for (int i = 0; i < N; i++) {
            T[i] = Integer.parseInt(in.nextLine().trim());
        }

        long[] count = countCoin(A, T);

        for (long i : count) {
            System.out.println(i);
        }
        in.close();


    }

}
