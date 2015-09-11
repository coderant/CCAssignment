package test;

import ch1.Solution13;

public class Test13 {
    public static void main(String[] args) {
        String[] strs = {"I am who            ",
                "  1 2 3 4 5         ",
                "1  ",
                ""};
        test(strs);

    }

    private static void test(String... str) {
        for (String s : str) {
            System.out.print(s + " to : ");
            System.out.println(Solution13.spaceSwap(s.toCharArray(), getlength(s)));
        }
    }

    private static int getlength(String s) {

        char[] chars = s.toCharArray();
        // scan for spaces in the end
        int tailingSpace = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                break;
            } else {
                tailingSpace++;
            }
        }

        return s.length() - tailingSpace;
    }
}
