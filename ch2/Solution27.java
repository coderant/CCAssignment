package ch2;

import java.util.HashMap;

public class Solution27 {

    // method returns null if no intersection is found
    // fist step: use two pointer to find the lengths of two List
    // second step: compare two last node of two list, if they are the same, then there's a intersection. If different, then no intersection
    // final step: once we know the two length,
    //             we can move the pointer of the longer list first,
    //             until the shorter list pointer and longer list node are at the same point.
    //             From this point, every time we move forward two pointers, we check if they are the same node.
    //             return the current node once such node is found.
    public static ListNode findIntersection(ListNode l1, ListNode l2) {

        int length1 = 0;
        int length2 = 0;

        ListNode current1 = l1;
        ListNode current2 = l2;

        // move current1 and current2 forward until they hit the last node
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

        // check to see they are the same node
        // if not, then there's no intersection, return null
        if (current1 != current2) {
            return null;
        }

        // make current1 the longer list first node
        // make current2 the shorter list first node
        current1 = length1 > length2 ? l1 : l2;
        current2 = length1 > length2 ? l2 : l1;

        // move longer pointer forward as long as the length are different
        while (length1 != length2) {
            current1 = current1.next;
            length1--;
        }

        // shorter list pointer and longer list pointer are at the same point
        // they can move forward together
        while (current1 != null || current2 != null) {

            // if encountered the same node, return this node
            if (current1 == current2) {
                return current1;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        return null;
    }

    // Test Method Below

    private static HashMap<Character, ListNode> nodesMap = new HashMap<>();

    private static ListNode makeList(String string) {

        ListNode dummy = new ListNode("Dummy");
        ListNode current = dummy;

        for (int i = 0; i < string.length(); i++) {

            char val = string.charAt(i);

            if (nodesMap.containsKey(val)) {
                current.next = nodesMap.get(val);
            } else {
                current.next = new ListNode(val);
                nodesMap.put(val, current.next);
            }
            current = current.next;
        }
        return dummy.next;

    }

    public static void main(String[] args) {

        System.out.println("Intersection of " + makeList("1234569abcv") + " and " + makeList("iuoy9abcv") + " are :");
        System.out.println(findIntersection(makeList("1234569abcv"), makeList("9abcv")));

    }


    static class ListNode {
        public ListNode next;
        public Object val;

        public ListNode() {
        }

        public ListNode(Object val) {
            this.val = val;
        }

        public static ListNode makeCharList(String str) {
            return makeCharList(str.toCharArray());
        }

        public static ListNode makeCharList(char[] chars) {

            ListNode head = new ListNode();
            ListNode current = head;
            for (char c : chars) {
                current.next = new ListNode(c);
                current = current.next;
            }
            return head.next;

        }

        public static ListNode makeIntList(String str) {
            ListNode head = new ListNode();

            ListNode current = head;

            for (int i = 0; i < str.length(); i++) {
                current.next = new ListNode(Integer.parseInt(str.substring(i, i + 1)));
                current = current.next;
            }

            return head.next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            ListNode current = this;

            while (current != null) {
                sb.append(current.val);
                sb.append("->");
                current = current.next;
            }
            sb.delete(sb.length() - 2, sb.length());

            return sb.toString();
        }
    }
}

