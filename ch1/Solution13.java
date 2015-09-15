package ch1;

// idea shared with Minhui Jiang

public class Solution13 {
    public static char[] spaceSwap(char[] chars, int length) {

        // if there's no actual string, then return original string
        if (length == 0) {
            return chars;
        }

        // one run, count how many spaces there are
        int spaceCount = 0;
        for (int i = 0; i <= length - 1; i++) {
            if (chars[i] == ' ') {
                spaceCount++;
            }
        }

        // if there's no space, return original string
        // check if the char array length is long enough
        if (spaceCount == 0) {
            return chars;
        } else if (spaceCount * 2 + length > chars.length - 1) {
            System.out.print("Chars length is too short");
            return chars;
        }

        // work backwards
        // copy every char to it's new place in the longer string
        // if encounted a space, add %20
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

    // Test Method Below

    public static void main(String[] args) {
        String[] strs = {"I am who            ",
                "  1 2 3 4 5                          ",
                "1  ",
                "",
                "hah hahah two                   "};
        test(strs);

    }

    private static void test(String... str) {
        for (String s : str) {
            System.out.print(s + " is converted to : ");
            System.out.println(spaceSwap(s.toCharArray(), getlength(s)));
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
