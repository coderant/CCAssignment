package ch8;

import java.util.ArrayList;

public class Solution89 {

    public static ArrayList<String> getAllCombination(int n) {

        ArrayList<String> results = new ArrayList<>();

        helper(results, new StringBuilder(), n, 0, 0);

        return results;
    }

    private static void helper(ArrayList<String> results, StringBuilder sb, int n, int leftUsed, int rightUsed) {

        if (leftUsed == n && rightUsed == n) {
            results.add(sb.toString());
            return;
        }

        if (leftUsed <= n) {
            sb.append("(");
            helper(results, sb, n, leftUsed + 1, rightUsed);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (rightUsed <= n && leftUsed > rightUsed) {
            sb.append(")");
            helper(results, sb, n, leftUsed, rightUsed + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // Test Method Below

    public static void main(String[] args) {
        for (String str : getAllCombination(8)) {
            System.out.println(str);
        }
    }
}
