package ch10;

public class Solution107 {

    // Use a bitVector to mark all numbers' occurrence
    // after all numbers are marked, search for the first missing int and return

    public static int getNumber(int[] numbers) {

        byte[] bitVector = new byte[Integer.MAX_VALUE / 8];

        for (int i = 0; i < numbers.length; i++) {
            bitVector[numbers[i] / 8] |= (1 << (numbers[i] % 8));
        }

        for (int i = 0; i < bitVector.length; i++) {
            for (int j = 0; j < 8; j++) {
                if ((bitVector[i] & (1 << j)) == 0) {
                    return i * 8 + j;
                }
            }
        }
        return -1;
    }

    // Test Method Below

    public static void main(String[] args) {
        int[] numbers = new int[]{0,1,2,3,5,6,7,8,9};

        System.out.println(getNumber(numbers));
    }

}
