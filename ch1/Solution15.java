package ch1;

public class Solution15 {
    public static boolean oneAway(String str1, String str2) {
        if (Math.abs(str1.length() - str2.length()) >= 2) {
            return false;
        }

        String shortie = str1.length() < str2.length() ? str1 : str2;
        String longer = str1.length() < str2.length() ? str2 : str1;

        boolean differenceFound = false;

        for (int index1 = 0, index2 = 0;
             index1 < shortie.length() && index2 < longer.length();
             index1++, index2++) {

            if (differenceFound) {
                if (shortie.charAt(index1) != longer.charAt(index2)) {
                    return false;
                }
            } else {
                if (shortie.charAt(index1) != longer.charAt(index2)) {
                    if (shortie.length() != longer.length()) {
                        index1++;
                    }
                    differenceFound = true;
                }
            }
        }

        return true;
    }
}
