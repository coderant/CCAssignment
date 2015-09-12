package helper;

public class ListNode {
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
            current.next = new ListNode(Integer.parseInt(str.substring(i,i+1)));
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
