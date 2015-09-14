package ch1;

public class Solution19 {

    /* A string: abcdefg, after rotated becomes efgabcde
    *  this can be written as AB -> BA, where A represent the first part of the string and B the latter
    *  thus the rotated BA will always be a substring of ABAB */

    public static boolean isRotation(String str1, String str2) {
        return isSubString(str2, str1 + str1);
    }

    private static boolean isSubString(String subString, String target) {
        if (subString.length() == 0 && target.length() == 0) {
            return true;
        } else if (subString.length() <= target.length()) {
            char[] subChar = subString.toCharArray();
            char[] targetChar = target.toCharArray();

            OUTER:
            for (int i = 0; i <= targetChar.length - subChar.length; i++) {
                for (int shift = 0; shift < subChar.length; shift++) {
                    if (targetChar[i + shift] != subChar[shift]) {
                        continue OUTER;
                    }
                }
                return true;
            }
            return false;
        } else {
            return false;
        }
    }


}
