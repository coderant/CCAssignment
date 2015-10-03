package ch5;

public class Solution52 {

    public static String tostring(double number) {

        StringBuilder sb = new StringBuilder();
        int base = 1;

        while (number != 0 && sb.length() < 33) {

            int digit = helper(number, base);

            sb.append(digit);
            number -=  digit * Math.pow(0.5, base++);
        }

        if (number == 0) {
            return sb.toString();
        } else {
            return "ERROR";
        }

    }

    private static int helper(double number, int foo) {

        return ((int) (number / Math.pow(0.5, foo)));

    }

    // Test Method Below

    public static void main(String[] args) {

        System.out.println(tostring(0.5));

    }
}
