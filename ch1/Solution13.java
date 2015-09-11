package ch1;

public class Solution13 {
    public static char[] spaceSwap(char[] chars, int length) {

        if (length == 0) {
            return chars;
        }

        // count spaces
        int spaceCount = 0;
        for (int i = 0; i <= length - 1; i++) {
            if (chars[i] == ' ') {
                spaceCount++;
            }
        }

        if (spaceCount == 0) {
            return chars;
        } else if (spaceCount * 2 + length > chars.length - 1) {
            System.out.print("Chars length is too short");
            return chars;
        }

        //add %20
        for (int i = length - 1; i >= 0 && spaceCount > 0; i--) {
            if (chars[i] == ' ') {
                spaceCount--;
                chars[i + 2 * spaceCount] = '%';
                chars[i + 1 + 2 * spaceCount] = '2';
                chars[i + 2 + 2 * spaceCount] = '0';
            } else {
                chars[i + 2 * spaceCount] = chars[i];
            }
        }
        return chars;

    }
}
