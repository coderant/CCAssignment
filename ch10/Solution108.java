package ch10;

public class Solution108 {

    // Use a bitVector to mark all numbers' occurrence
    // Whenever a existing number was detected, print it out.

    public static void printAllDup(int[] numbers) {

        byte[] bitVector = new byte[32000 / 8];

        for (int i : numbers) {

            if ((bitVector[i / 8] & (1 << (i % 8))) == 0) {
                bitVector[i / 8] |= (1 << (i % 8));
            } else {
                System.out.println(i);
            }
        }
    }

    // Test Method Below

    public static void main(String[] args) {
        int[] numbers = new int[]{1,2,3,4,5,1,1,1,2,2,2,3,3,3,4,4,4};

        printAllDup(numbers);
    }
}
