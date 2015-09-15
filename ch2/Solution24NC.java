package ch2;

public class Solution24NC {
    public static ListNode partition(ListNode head, int value) {
        ListNode leftDummy = new ListNode("Dummy");
        ListNode rightDummy = new ListNode("Dummy");
        ListNode left = leftDummy;
        ListNode right = rightDummy;

        while (head != null) {
            if (((int) head.val) < value) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }

        left.next = rightDummy.next;
        right.next = null;
        return leftDummy.next;
    }

    // Test Method Below

    public static void main(String[] args) {
        ListNode list1 = ListNode.makeIntList("112311");
        ListNode list2 = ListNode.makeIntList("987123456");
        ListNode list3 = ListNode.makeIntList("1234567890");
        ListNode list4 = ListNode.makeIntList("1234567890");
        ListNode list5 = ListNode.makeIntList("1234567890");
        ListNode list6 = ListNode.makeIntList("1234567890");


        System.out.println(Solution24NC.partition(list2, 99));
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

