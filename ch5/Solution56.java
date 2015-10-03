package ch5;

public class Solution56 {

    public static int countFlip(int number1, int number2) {

        int count = 0;

        int c = number1 ^ number2;

        while (c != 0) {

            count += c & 1;
            c >>= 1;
        }

        return count;

    }

    // Test Method Below

    public static void main(String[] args) {
        System.out.println(countFlip(29,15));
    }

}
