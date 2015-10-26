package ch5;

public class Solution54 {

    public static void run(int number) {
        int cur = number;
        System.out.println(number + " has " + Integer.bitCount(cur) + " of 1s");
        while (cur-- > 0) {
            if (Integer.bitCount(cur) == Integer.bitCount(number)) {
                System.out.println("-> " + cur + " has " + Integer.bitCount(cur) + " of 1s");
                break;
            }
        }

        cur = number;

        while (true) {
            if (Integer.bitCount(++cur) == Integer.bitCount(number)) {
                System.out.println("-> " + cur + " has " + Integer.bitCount(cur) + " of 1s");
                break;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        for (int i = 1002; i < 100000; i += 123) {
            run(i);
        }
    }
}
