package ch2;

public class Solution24NC {
    public static ListNode24 partition(ListNode24 head, int value) {
        ListNode24 leftDummy = new ListNode24("Dummy");
        ListNode24 rightDummy = new ListNode24("Dummy");
        ListNode24 left = leftDummy;
        ListNode24 right = rightDummy;

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

    public static void main(String[] args) {
        ListNode24 list1 = ListNode24.makeIntList("112311");
        ListNode24 list2 = ListNode24.makeIntList("987123456");
        ListNode24 list3 = ListNode24.makeIntList("1234567890");
        ListNode24 list4 = ListNode24.makeIntList("1234567890");
        ListNode24 list5 = ListNode24.makeIntList("1234567890");
        ListNode24 list6 = ListNode24.makeIntList("1234567890");


        System.out.println(Solution24NC.partition(list2, 99));
    }
}

class ListNode24 {
    public ListNode24 next;
    public Object val;

    public ListNode24() {
    }

    public ListNode24(Object val) {
        this.val = val;
    }

    public static ListNode24 makeCharList(String str) {
        return makeCharList(str.toCharArray());
    }

    public static ListNode24 makeCharList(char[] chars) {

        ListNode24 head = new ListNode24();
        ListNode24 current = head;
        for (char c : chars) {
            current.next = new ListNode24(c);
            current = current.next;
        }
        return head.next;

    }

    public static ListNode24 makeIntList(String str) {
        ListNode24 head = new ListNode24();

        ListNode24 current = head;

        for (int i = 0; i < str.length(); i++) {
            current.next = new ListNode24(Integer.parseInt(str.substring(i, i + 1)));
            current = current.next;
        }

        return head.next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        ListNode24 current = this;

        while (current != null) {
            sb.append(current.val);
            sb.append("->");
            current = current.next;
        }
        sb.delete(sb.length() - 2, sb.length());

        return sb.toString();
    }
}
