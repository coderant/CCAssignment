package ch10;

import java.util.ArrayList;

public class Solution104 {

    // First search for the end element. When searching, search in 2, 4, 8, 16, 32... pattern
    // After end was found, binary search normally

    public static int search(int targetX, Listy listy) {

        int i = 2;

        while (listy.elementAt(i) != -1) {
            i *= 2;
        }

        int start = i / 2;
        int end = i;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (listy.elementAt(mid) == -1) {
                end = mid;
            } else {
                start = mid;
            }
        }

        int lastIndex = -1;

        if (listy.elementAt(end) != -1) {
            lastIndex = end;
        }

        if (listy.elementAt(start) != -1) {
            lastIndex = start;
        }

        start = 0;
        end = lastIndex;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (listy.elementAt(mid) > targetX) {
                end = mid;
            } else if (listy.elementAt(mid) == targetX) {
                return mid;
            } else {
                start = mid;
            }
        }

        if (listy.elementAt(start) == targetX) {
            return start;
        }

        if (listy.elementAt(end) == targetX) {
            return end;
        }


        return -1;

    }

    static class Listy {
        private ArrayList<Integer> list = new ArrayList<>();

        public Listy() {
        }

        public int elementAt(int index) {
            return index < list.size() ? list.get(index) : -1;
        }

        public void add(int i) {
            list.add(i);
        }

    }

    // Test Method Below

    public static void main(String[] args) {
        Listy listy = new Listy();

        for (int i = 0; i < 100; i++) {
            listy.add(i);
        }

        System.out.println(search(120, listy));
    }
}
