package ch8;

public class Solution85 {

    public static int multiply(int number1, int number2) {

        if (number1 == 1 && number2 == 1) {
            return 1;
        }

        if (number2 == 1) {
            return number1;
        }

        return number1 + multiply(number1, number2 - 1);
    }

    // Test Method Below

    public static void main(String[] args) {
        System.out.println(multiply(100,5));
    }
}
