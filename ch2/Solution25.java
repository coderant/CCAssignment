package ch2;

public class Solution25 {


    // Part I:
    //
    public static ListNode sumList(ListNode l1, ListNode l2) {

        int carry = 0;
        int sum;

        ListNode results = new ListNode("Dummy");

        ListNode current1 = l1;
        ListNode current2 = l2;
        ListNode result = results;

        int value1;
        int value2;

        while (current1 != null || current2 != null) {

            value1 = current1 == null ? 0 : ((int) current1.val);
            value2 = current2 == null ? 0 : ((int) current2.val);

            sum = value1 + value2 + carry;
            carry = sum / 10;

            result.next = new ListNode(sum % 10);
            result = result.next;

            current1 = current1 == null ? null : current1.next;
            current2 = current2 == null ? null : current2.next;
        }

        if (carry != 0) {
            result.next = new ListNode(carry);
        }

        return results.next;
    }

    // Follow Up:
    // we reverser l1 and l2 so that they are of the same order as original question
    // then we add them by the same method and then reverse the result
    public static ListNode sumListFollow(ListNode l1, ListNode l2) {

        return reverse(sumList(reverse(l1), reverse(l2)));
    }

    private static ListNode reverse(ListNode l) {
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

        test("123","123");
        test("999","999");
        test("1","999999");

    }

    public static void test(String string1, String string2) {

        System.out.println("Original : ");

        System.out.print(ListNode.makeIntList(string1) + " + " + ListNode.makeIntList(string2) + " = ");
        System.out.println(Solution25.sumList(ListNode.makeIntList(string1), ListNode.makeIntList(string2)));

        System.out.println("FollowUp : ");

        System.out.print(ListNode.makeIntList(string1) + " + " + ListNode.makeIntList(string2) + " = ");
        System.out.println(Solution25.sumListFollow(ListNode.makeIntList(string1), ListNode.makeIntList(string2)));
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

