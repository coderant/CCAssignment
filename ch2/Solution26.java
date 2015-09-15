package ch2;

public class Solution26 {

    // algorithm first find the middle node in the List
    // then reverse the latter part of the list
    // then two pointer, one at the beginning and one at the end
    // they simultaneously move to the middle, as they move, check if they have the same val
    // after check we reverse the latter half of the list to restore original list structure

    public static boolean checkPermutation(ListNode head) {

        if (head == null) {
            return false;
        } else if (head.next == null) {
            return true;
        }

        ListNode turtle = head;
        ListNode rabbit = head;

        while (true) {
            turtle = turtle.next;

            if (rabbit == null || rabbit.next == null) {
                break;
            } else {
                rabbit = rabbit.next.next;
            }
        }

        ListNode tail = reverse(turtle);

        ListNode current1 = head;
        ListNode current2 = tail;

        while (current2 != null) {
            if (current1.val != current2.val) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        reverse(tail);

        return true;


    }

    public static ListNode reverse(ListNode l) {
        if (l == null || l.next == null) {
            return l;
        }

        ListNode current = l;
        ListNode next = current.next;
        ListNode prev = null;

        while (next != null) {

            current.next = prev;

            ListNode tmp = next;
            next = next.next;
            prev = current;
            current = tmp;
        }

        current.next = prev;

        return current;
    }

    // Test Method Below

    public static void main(String[] args) {
        test("1221", "12345", "123454321", "1", "*******");

    }

    private static void test(String... strings) {

        for (String string : strings) {
            ListNode head = ListNode.makeCharList(string);
            System.out.print(head + " is permutation : ");
            System.out.println(checkPermutation(head));
            System.out.println("original List is : " + head);
            System.out.println();

        }
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