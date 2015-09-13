package ch1;

import java.util.HashMap;

public class Solution14 {

    public static boolean detectPermu(String str) {

        // count actual number of letters, leave out whitespaces
        int realLength = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                realLength++;
            }
        }

        // establish a letter count hashTable
        HashMap<Character, Integer> countTable = new HashMap<>();

        // iterate through the string to count all instance of a letter
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                if (countTable.containsKey(str.charAt(i))) {
                    countTable.put(str.charAt(i), countTable.get(str.charAt(i)) + 1);
                } else {
                    countTable.put(str.charAt(i), 1);
                }
            }
        }

        // two situation, str is odd number length and even number length
        if (realLength % 2 == 0) {

            // even number length
            // all letter counts must be even
            // otherwise return false
            for (int i : countTable.values()) {
                if (i % 2 == 1) {
                    return false;
                }
            }
            return true;

        } else {

            // odd number length
            // only one 1 count letter is allowed
            // set flag: 1 count letter number oneCount
            // oneCount must be less than 2 and must be 1 in the end
            // otherwise return false
            int oneCount = 0;
            for (int i : countTable.values()) {
                if (i % 2 == 1) {
                    oneCount++;
                    if (oneCount >= 2) {
                        return false;
                    }
                }
            }

            return oneCount == 1;
        }
    }

    public static void main(String[] args) {
        test("12321","23 42 3 4","1","1132");
    }

    private static void test(String... strings) {
        for (String str : strings) {

            String result = detectPermu(str) ? "permutation" : "not permutation";

            System.out.println(str + " is " + result);
        }
    }
}
