package ch1;

import java.util.Arrays;

public class Solution12 {
    public static boolean isPermutation(String str1, String str2) {

        // if two strings are of different length, then must not be permutations
        if (str1.length() != str2.length()) {
            return false;
        }

        // convert two string to their corresponding char array
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        // sort two char array
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        // once sorted, just compare two arrays against one another
        for (int i = 0; i < chars1.length; i++) {

            // once found different char at same place, then not permutation
            if (chars1[i] != chars2[i]) {
                System.out.println("Not permutations");
                return false;
            }
        }

        // all chars are the same
        System.out.println("Are permutations");
        return true;
    }
}
