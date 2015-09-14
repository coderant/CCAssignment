package ch2;


public class Solution23 {

    // kill the scapegoat
    public static void deleteMiddle(ListNode23 node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

class ListNode23 {
    public ListNode23 next;
    public Object val;

    public ListNode23() {
    }

    public ListNode23(Object val) {
        this.val = val;
    }

    public static ListNode23 makeCharList(String str) {
        return makeCharList(str.toCharArray());
    }

    public static ListNode23 makeCharList(char[] chars) {

        ListNode23 head = new ListNode23();
        ListNode23 current = head;
        for (char c : chars) {
            current.next = new ListNode23(c);
            current = current.next;
        }
        return head.next;

    }

    public static ListNode23 makeIntList(String str) {
        ListNode23 head = new ListNode23();

        ListNode23 current = head;

        for (int i = 0; i < str.length(); i++) {
            current.next = new ListNode23(Integer.parseInt(str.substring(i, i + 1)));
            current = current.next;
        }

        return head.next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        ListNode23 current = this;

        while (current != null) {
            sb.append(current.val);
            sb.append("->");
            current = current.next;
        }
        sb.delete(sb.length() - 2, sb.length());

        return sb.toString();
    }
}