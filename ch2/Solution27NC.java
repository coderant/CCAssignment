package ch2;

public class Solution27NC {


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