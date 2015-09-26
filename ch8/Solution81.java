package ch8;

public class Solution81 {

    public static int jump(int n) {

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        }

        int[] f = new int[n];

        f[0] = 1;
        f[1] = 2;
        f[2] = 4;

        for (int i = 3; i < n; i++) {

            f[i] = f[i - 1] + f[i - 2] + f[i - 3];
        }

        return f[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(jump(4));
    }

}
