package ch10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution102 {

    
    // For all strings, convert each string to a char array and then sort this array.
    // Iterate through all char array, store all same char array's index
    // Iterate through the char array map, add all indexes to the result

    public static ArrayList<String> sort(ArrayList<String> strings) {

        HashMap<String, ArrayList<Integer>> index = new HashMap<>();

        ArrayList<String> characters = new ArrayList<>();

        for (int i = 0; i < strings.size(); i++) {

            char[] chars = strings.get(i).toCharArray();
            Arrays.sort(chars);
            String str = new String(chars);

            characters.add(str);
        }

        for (int i = 0; i < characters.size(); i++) {

            if (!index.containsKey(characters.get(i))) {
                ArrayList<Integer> index1 = new ArrayList<>();
                index1.add(i);
                index.put(characters.get(i), index1);
            } else {
                index.get(characters.get(i)).add(i);
            }
        }

        ArrayList<String> results = new ArrayList<>();

        for (ArrayList<Integer> arrayList : index.values()) {
            for (Integer i : arrayList) {

                results.add(strings.get(i));

            }
        }

        return results;

    }


    // Test Method Below

    public static void main(String[] args) {

        ArrayList<String> unsorted = new ArrayList<>();

        unsorted.add("123");
        unsorted.add("abc");
        unsorted.add("312");
        unsorted.add("acb");

        ArrayList<String> sorted = sort(unsorted);

        for (String s : sorted) {
            System.out.println(s);
        }

    }

}
