package ch10;

import java.util.Arrays;

public class Solution101 {

    // list is in increasing order

    // Merge two lists from backwards
    // At every place select the larger element in two arrays

    public static int[] sortedMerge(int[] a, int aLength, int[] b, int bLength) {

        int currentA = aLength - 1;
        int currentB = bLength - 1;

        int current = aLength + bLength - 1;

        while (currentA >= 0 && currentB >= 0) {
            if (a[currentA] > b[currentB]) {
                a[current--] = a[currentA--];
            } else {
                a[current--] = b[currentB--];
            }
        }

        while (currentA >= 0) {
            a[current--] = a[currentA--];
        }

        while (currentB >= 0) {
            a[current--] = b[currentB--];
        }

        return a;
    }

    // Test Method Below

    public static void main(String[] args) {

        test("125679", "0348");
    }

    private static void test(String a, String b) {

        System.out.println(Arrays.toString(sortedMerge(getInt(a, a.length() + b.length()), a.length(), getInt(b, b.length()), b.length())));
    }

    private static int[] getInt(String str, int length) {
        int[] result = new int[length];

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                result[i] = Integer.parseInt(str.substring(i,i + 1));
            }
        }

        return result;
    }
}
