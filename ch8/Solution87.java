package ch8;

import java.util.ArrayList;

public class Solution87 {

    public static ArrayList<String> permutation(String str) {

        ArrayList<String> results = new ArrayList<>();

        addAllPermu(new ArrayList<String>(), str, results);

        return results;
    }

    private static void addAllPermu(ArrayList<String> permu, String str, ArrayList<String> results) {

        if (permu.size() == str.length()) {
            results.add(arrayToString(permu));
        }

        for (int i = 0; i < str.length(); i++) {

            if (permu.contains(str.substring(i, i + 1))) {
                continue;
            }

            permu.add(str.substring(i, i + 1));
            addAllPermu(permu, str, results);
            permu.remove(permu.size() - 1);
        }

    }

    private static String arrayToString(ArrayList<String> arrayList) {

        StringBuilder sb = new StringBuilder();

        for (String str : arrayList) {
            sb.append(str);
        }

        return sb.toString();
    }

    // Test Method Below

    public static void main(String[] args) {
        ArrayList<String> result = permutation("123abcdefg");

        for (String str : result) {
            System.out.println(str);
        }
    }
}
