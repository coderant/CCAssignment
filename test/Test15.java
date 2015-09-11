package test;

import ch1.Solution15;

public class Test15 {
    public static void main(String[] args) {
        test(new String[]{"1213", "1234"},
                new String[]{"121", "123"},
                new String[]{"113", "123"},
                new String[]{"12", "12"},
                new String[]{"1", "2"},
                new String[]{"", ""},
                new String[]{"14", "1"}
        );
    }

    private static void test(String[]... strings) {
        for(String[] strings1 : strings) {
            System.out.println(strings1[0] + " and " + strings1[1] + " is : " + Solution15.oneAway(strings1[0], strings1[1]));
        }
    }
}
