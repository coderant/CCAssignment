package ch7;

public class Stemming {

    static String stemmer(String inputTerms) {
        String[] strs = inputTerms.split(" ");

        int minLength = Integer.MAX_VALUE;
        String minString = "";


        for (String str : strs) {
            if (str.length() <= minLength) {
                minLength = str.length();
                minString = str;
            }
        }

        for (int i = minLength / 2; i < minLength; i++) {
            int score = 0;

            for (String str : strs) {
                if (!str.contains(minString.substring(0, i))) {
                    score++;
                }
            }

            if (score >= strs.length / 2) {
                return minString.substring(0, i - 1);
            }
        }

        return minString;

    }

    public static void main(String[] args) {

        String str = "computer computed computes compute";

        System.out.println(stemmer(str));
    }

}
