package ch2;

public class Solution22NC {

    public static ListNode23 kthToLast(ListNode23 head, int k) {
        ListNode23 kth = null;
        ListNode23 current = head;

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

    public static void main(String[] args) {
        ListNode23 list1 = ListNode23.makeCharList("987659321");
        ListNode23 list2 = ListNode23.makeCharList("111111119");

        System.out.println(kthToLast(list1, 4));
        System.out.println(kthToLast(list2, 1));
        System.out.println(kthToLast(list1, 9));

    }
}

class ListNode22 {
    public ListNode22 next;
    public Object val;

    public ListNode22() {
    }

    public ListNode22(Object val) {
        this.val = val;
    }

    public static ListNode22 makeCharList(String str) {
        return makeCharList(str.toCharArray());
    }

    public static ListNode22 makeCharList(char[] chars) {

        ListNode22 head = new ListNode22();
        ListNode22 current = head;
        for (char c : chars) {
            current.next = new ListNode22(c);
            current = current.next;
        }
        return head.next;

    }

    public static ListNode22 makeIntList(String str) {
        ListNode22 head = new ListNode22();

        ListNode22 current = head;

        for (int i = 0; i < str.length(); i++) {
            current.next = new ListNode22(Integer.parseInt(str.substring(i, i + 1)));
            current = current.next;
        }

        return head.next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        ListNode22 current = this;

        while (current != null) {
            sb.append(current.val);
            sb.append("->");
            current = current.next;
        }
        sb.delete(sb.length() - 2, sb.length());

        return sb.toString();
    }
}
