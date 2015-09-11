package test;

import ch1.Solution14;

public class Test14 {

    public static void main(String[] args) {
        test("12321","23 42 3 4","1","1132");
    }

    private static void test(String... strings) {
        for (String str : strings) {
            System.out.println(str + " is " + Solution14.detectPermu(str));
        }
    }
}
