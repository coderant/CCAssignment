package ch10;


import java.util.Arrays;

public class Solution1011 {

    public static void weirdSort(int[] ints) {

        for (int i = 1; i < ints.length; i += 2) {

            int biggestIndex = biggestIndex(ints, i);

            if (i != biggestIndex) {
                int tmp = ints[i];
                ints[i] = ints[biggestIndex];
                ints[biggestIndex] = tmp;
            }
        }
    }

    public static int biggestIndex(int[] ints, int i) {

        int number1 = ints[i - 1];
        int number2 = ints[i];
        int number3 = i + 1 < ints.length ? ints[i + 1] : -1;

        if (number2 >= number1 && number2 >= number3) {
            return i;
        } else {
            return number3 > number1 ? i + 1 : i - 1;
        }
    }

    // Test Method Below

    public static void main(String[] args) {
        int length = ((int) (Math.random() * 20 +10));

        int[] ints = new int[length];

        for (int i = 0; i < length; i++) {
            ints[i] = ((int) (Math.random() * 100));
        }

        weirdSort(ints);

        System.out.println(Arrays.toString(ints));
    }

}
