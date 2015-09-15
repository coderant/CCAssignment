package ch1;

public class Solution16 {
    public static String strZip(String str) {

        if (str.length() == 0) {
            return str;
        }

        // StringBuilder to store newly formed String
        StringBuilder zipped = new StringBuilder();

        char[] chars = str.toCharArray();

        // the start
        int beginPoint = 0;
        zipped.append(chars[beginPoint]);

        int count = 0;

        for (int endPoint = 0; endPoint <= chars.length; ) {

            if (endPoint == chars.length) {

                if (count > 1) {
                    zipped.append(count);
                }

                break;

            } else if (chars[beginPoint] != chars[endPoint]) {

                if (count > 1) {
                    zipped.append(count);
                }

                // reset counter and add the first instance of a char
                zipped.append(chars[endPoint]);
                beginPoint = endPoint;
                count = 0;

            } else {

                // chars[beginPoint] == chars[endPoint], continue
                endPoint++;
                count++;
            }
        }

        if (zipped.length() >= str.length()) {
            return str;
        } else {
            return zipped.toString();
        }

    }

    // Test Method Below

    public static void main(String[] args) {
        test("aaabbbccc",
                "abc",
                "aabbcc",
                "aaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbb",
                "a",
                "");
    }

    private static void test(String... strings) {
        for (String string : strings) {
            System.out.println(string + " is converted to: " + strZip(string));
        }
    }
}
