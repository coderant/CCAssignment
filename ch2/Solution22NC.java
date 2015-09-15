package ch2;

public class Solution22NC {

    public static ListNode kthToLast(ListNode head, int k) {
        ListNode kth = null;
        ListNode current = head;

        while (current != null) {
            if (k >= 2) {
                current = current.next;
                k--;
            } else if (k == 1) {
                kth = head;
                current = current.next;
                k--;
            } else {
                kth = kth.next;
                current = current.next;
            }
        }

        return kth;
    }

    // Test Method Below

    public static void main(String[] args) {
        ListNode list1 = ListNode.makeCharList("987659321");
        ListNode list2 = ListNode.makeCharList("111111119");

        System.out.println(kthToLast(list1, 4));
        System.out.println(kthToLast(list2, 1));
        System.out.println(kthToLast(list1, 9));

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

