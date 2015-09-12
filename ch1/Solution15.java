package ch1;

public class Solution15 {
    public static boolean oneAway(String str1, String str2) {

        // if two strings has different length, return false
        if (Math.abs(str1.length() - str2.length()) >= 2) {
            return false;
        }

        // let shortie be the shorter string
        // let longer be the longer string
        String shortie = str1.length() < str2.length() ? str1 : str2;
        String longer = str1.length() < str2.length() ? str2 : str1;

        // set a flag to determine if a difference has been previously found
        boolean differenceFound = false;

        // two indexes in their respective strings
        for (int index1 = 0, index2 = 0;
             index1 < shortie.length() && index2 < longer.length();
             index1++, index2++) {

            // two situations
            if (differenceFound) {

                // one : a difference has been previously found, then all trailing letter must be the same
                //       otherwise, return false
                if (shortie.charAt(index1) != longer.charAt(index2)) {
                    return false;
                }
            } else {

                // two : no difference has been previously found, then there are two situations:
                //       a) shortie and longer has different length, then we can add a letter,
                //          thus increment the longer string index
                //       b) has same length, then we can change a letter, thus both indexes must increment
                //
                //       set flag to true
                if (shortie.charAt(index1) != longer.charAt(index2)) {
                    if (shortie.length() != longer.length()) {
                        index2++;
                    }
                    differenceFound = true;
                }
            }
        }

        return true;
    }
}
