package ch1;

import java.util.HashMap;

public class Solution14 {

    public static boolean detectPermu(String str) {

        int realLength = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                realLength++;
            }
        }

        HashMap<Character, Integer> countTable = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                if (countTable.containsKey(str.charAt(i))) {
                    countTable.put(str.charAt(i), countTable.get(str.charAt(i)) + 1);
                } else {
                    countTable.put(str.charAt(i), 1);
                }
            }
        }

        if (realLength % 2 == 0) {
            for (int i : countTable.values()) {
                if (i % 2 == 1) {
                    return false;
                }
            }

            return true;
        } else {

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
}
