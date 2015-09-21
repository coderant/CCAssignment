package ch10;

public class Solution104Unfinished {

    public int search(int target, Listy listy) {

        int i = 2;

        while (listy.elementAt(i) != -1) {

        }


        return 0;

    }




    static class Listy {
        private int[] list;

        public Listy(int[] list) {
            this.list = list;
        }

        public int elementAt(int index) {
            return index < list.length ? list[index] : -1;
        }
    }
}
