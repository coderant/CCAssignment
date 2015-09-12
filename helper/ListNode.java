package helper;

public class ListNode {
    public ListNode next;
    public Object val;

    public ListNode() {
    }

    public ListNode(Object val) {
        this.val = val;
    }

    public static ListNode makeList(String str) {
        return makeList(str.toCharArray());
    }

    public static ListNode makeList(char[] chars) {

        ListNode head = new ListNode();
        ListNode current = head;
        for (char c : chars) {
            current.next = new ListNode(c);
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
            current = current.next;
        }

        return sb.toString();
    }
}
