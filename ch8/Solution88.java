package ch8;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution88 {

    public static ArrayList<String> permutation(String str) {
        char[] chars = str.toCharArray();

        Arrays.sort(chars);

        ArrayList<String> results = new ArrayList<>();

        helper(results, new StringBuilder(), chars, null);

        return results;
    }

    private static void helper(ArrayList<String> results, StringBuilder sb, char[] array, boolean[] flag) {

        if (flag == null) {
            flag = new boolean[array.length];
        }

        if (sb.length() == array.length) {
            results.add(sb.toString());
            return;
        }

        for (int i = 0; i < array.length; i++) {
            if (flag[i] || (i != 0 && array[i - 1] == array[i] && !flag[i - 1])) {
                continue;
            }

            flag[i] = true;
            sb.append(array[i]);
            helper(results, sb, array, flag);
            flag[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // Test Method Below

    public static void main(String[] args) {
        for (String str : permutation("11111")) {
            System.out.println(str);
        }
    }
}
