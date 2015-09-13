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

    public static void main(String[] args) {
        test(new String[]{"1213", "1234"},
                new String[]{"123456", "13456"},
                new String[]{"113", "123"},
                new String[]{"12", "12"},
                new String[]{"1", "2"},
                new String[]{"", ""},
                new String[]{"14", "1"}
        );
    }

    private static void test(String[]... strings) {
        for(String[] strings1 : strings) {

            String result = oneAway(strings1[0], strings1[1]) ? "OneAway" : "not OneAway";

            System.out.println(strings1[0] + " and " + strings1[1] + " is " + result);
        }
    }
}
