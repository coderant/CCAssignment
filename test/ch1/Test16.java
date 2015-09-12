package test.ch1;

import ch1.Solution16;

public class Test16 {
    public static void main(String[] args) {
        test("aaabbbccc",
                "abc",
                "aabbcc",
                "aaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbb");
    }

    private static void test(String... strings) {
        for (String string : strings) {
            System.out.println(string + " is converted to: " + Solution16.strZip(string));
        }
    }
}
