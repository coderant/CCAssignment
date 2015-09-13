package ch1;

import java.util.Arrays;

public class Solution11 {

    public static boolean isUnique(String str) {

        if (str == null) {
            return true;
        }

        // convert original string to a char array
        char[] chars = str.toCharArray();

        // sort char array
        Arrays.sort(chars);

        // check neighboring chars to see of any two pair are the same
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                // once same elements are found, return false
                System.out.println(str + " is not unique");
                return false;
            }
        }

        // no same char are found
        System.out.println(str + " is unique");
        return true;
    }

    public static void main(String[] args) {
        test("Unique wr˜˚∆¨ˆ\"09876œ∑ßåΩ",
                "Uni df123",
                "Unique wr˜˚∆¨ˆ\"09876œ∑ßåΩ",
                "NotUnique˜˜",
                "  ",
                "", null);
    }

    public static void test(String... strs) {
        for (String str : strs) {
            isUnique(str);
        }
    }
}
