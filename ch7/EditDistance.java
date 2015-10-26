package ch7;

public class EditDistance {

    static String levenshteinDistance(String misspelledWord, String[] dictionaryWords) {

        int minDist = Integer.MAX_VALUE;
        String minStr = "";

        for (String str : dictionaryWords) {

            int dist = getDist(misspelledWord, str);

            if (dist < minDist) {
                minDist = dist;
                minStr = str;
            }
        }

        return minDist + "," + minStr;

    }

    static int getDist(String target, String string) {

        int[][] f = new int[string.length() + 1][target.length() + 1];

        f[0][0] = 0;

        for (int i = 1; i < f.length; i++) {
            f[i][0] = i;
        }

        for (int j = 1; j < f[0].length; j++) {
            f[0][j] = j;
        }

        for (int i = 1; i < f.length; i++) {
            for (int j = 1; j < f[0].length; j++) {

                if (string.charAt(i - 1) == target.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    f[i][j] = Math.min(Math.min(f[i - 1][j], f[i][j - 1]), f[i - 1][j - 1]) + 1;
                }
            }
        }

        return f[f.length - 1][f[0].length - 1];

    }

}
