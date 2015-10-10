package ch5;

public class Solution51 {

    public static int updateBits(int n, int m, int i, int j) {

        int all1 = ~0;

        int mask = (all1 << (j + 1)) | ((1 << i) - 1);

        int clearBit = n & mask;
        int shiftM = m << i;

        return clearBit | shiftM;
    }

}
