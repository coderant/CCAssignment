package ch2;

import java.util.HashMap;

public class Solution27NC {

    public static ListNode27 findIntersection(ListNode27 l1, ListNode27 l2) {

        int length1 = 0;
        int length2 = 0;

        ListNode27 current1 = l1;
        ListNode27 current2 = l2;

        while (current1.next != null || current2.next != null) {

            if (current1.next != null) {
                length1++;
                current1 = current1.next;
            }

            if (current2.next != null) {
                length2++;
                current2 = current2.next;
            }
        }

        if (current1 != current2) {
            return null;
        }
        length1++;
        length2++;

        current1 = length1 > length2 ? l1 : l2;
        current2 = length1 > length2 ? l2 : l1;

        while (length1 != length2) {
            current1 = current1.next;
            length1--;
        }

        while (current1 != null || current2 != null) {
            if (current1 == current2) {
                return current1;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return null;
    }


    private static HashMap<Character, ListNode27> nodesMap = new HashMap<>();

    private static ListNode27 makeList(String string) {

        ListNode27 dummy = new ListNode27("Dummy");
        ListNode27 current = dummy;

        for (int i = 0; i < string.length(); i++) {

            char val = string.charAt(i);

            if (nodesMap.containsKey(val)) {
                current.next = nodesMap.get(val);
            } else {
                current.next = new ListNode27(val);
                nodesMap.put(val, current.next);
            }
            current = current.next;
        }
        return dummy.next;

    }

    public static void main(String[] args) {

        System.out.println("Intersection of " + makeList("123456abcv") + " and " + makeList("9abcv") + " are :");
        System.out.println(findIntersection(makeList("1234569abcv"), makeList("9abcv")));

    }



}

class ListNode27 {
    public ListNode27 next;
    public Object val;

    public ListNode27() {
    }

    public ListNode27(Object val) {
        this.val = val;
    }

    public static ListNode27 makeCharList(String str) {
        return makeCharList(str.toCharArray());
    }

    public static ListNode27 makeCharList(char[] chars) {

        ListNode27 head = new ListNode27();
        ListNode27 current = head;
        for (char c : chars) {
            current.next = new ListNode27(c);
            current = current.next;
        }
        return head.next;

    }

    public static ListNode27 makeIntList(String str) {
        ListNode27 head = new ListNode27();

        ListNode27 current = head;

        for (int i = 0; i < str.length(); i++) {
            current.next = new ListNode27(Integer.parseInt(str.substring(i, i + 1)));
            current = current.next;
        }

        return head.next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        ListNode27 current = this;

        while (current != null) {
            sb.append(current.val);
            sb.append("->");
            current = current.next;
        }
        sb.delete(sb.length() - 2, sb.length());

        return sb.toString();
    }
}