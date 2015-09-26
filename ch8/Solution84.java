package ch8;


import java.util.ArrayList;

public class Solution84 {

    public static ArrayList<String> getSubsets(String str) {
        ArrayList<String> results = new ArrayList<>();

        subsetHelper("", str, 0, results);

        return results;

    }

    private static void subsetHelper(String prefix,
                                     String str,
                                     int currentAt,
                                     ArrayList<String> results) {

        results.add(prefix);

        for (int i = currentAt; i < str.length(); i++) {
            subsetHelper(prefix + str.charAt(i), str, i + 1, results);
        }

    }

    // Test Method Below

    public static void main(String[] args) {
        ArrayList<String> result = getSubsets("123456");

        for (String string : result) {
            System.out.println(string);
        }
    }


}
