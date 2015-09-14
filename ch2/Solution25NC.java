package ch2;

public class Solution25NC {

    public static ListNode25 sumList(ListNode25 l1, ListNode25 l2) {

        int carry = 0;
        int sum;

        ListNode25 results = new ListNode25("Dummy");

        ListNode25 current1 = l1;
        ListNode25 current2 = l2;
        ListNode25 result = results;

        int value1;
        int value2;

        while (current1 != null || current2 != null) {

            value1 = current1 == null ? 0 : ((int) current1.val);
            value2 = current2 == null ? 0 : ((int) current2.val);

            sum = value1 + value2 + carry;
            carry = sum / 10;

            result.next = new ListNode25(sum % 10);
            result = result.next;

            current1 = current1 == null ? null : current1.next;
            current2 = current2 == null ? null : current2.next;
        }

        if (carry != 0) {
            result.next = new ListNode25(carry);
        }

        return results.next;
    }

    public static ListNode25 sumListFollow(ListNode25 l1, ListNode25 l2) {

        return reverse(sumList(reverse(l1), reverse(l2)));
    }

    private static ListNode25 reverse(ListNode25 l) {
        if (l == null || l.next == null) {
            return l;
        }

        ListNode25 current = l;
        ListNode25 next = current.next;
        ListNode25 prev = null;

        while (next != null) {

            current.next = prev;

            ListNode25 tmp = next;
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

        System.out.print(ListNode25.makeIntList(string1) + " + " + ListNode25.makeIntList(string2) + " = ");
        System.out.println(Solution25NC.sumList(ListNode25.makeIntList(string1), ListNode25.makeIntList(string2)));

        System.out.println("FollowUp : ");

        System.out.print(ListNode25.makeIntList(string1) + " + " + ListNode25.makeIntList(string2) + " = ");
        System.out.println(Solution25NC.sumListFollow(ListNode25.makeIntList(string1), ListNode25.makeIntList(string2)));
    }

}

class ListNode25 {
    public ListNode25 next;
    public Object val;

    public ListNode25() {
    }

    public ListNode25(Object val) {
        this.val = val;
    }

    public static ListNode25 makeCharList(String str) {
        return makeCharList(str.toCharArray());
    }

    public static ListNode25 makeCharList(char[] chars) {

        ListNode25 head = new ListNode25();
        ListNode25 current = head;
        for (char c : chars) {
            current.next = new ListNode25(c);
            current = current.next;
        }
        return head.next;

    }

    public static ListNode25 makeIntList(String str) {
        ListNode25 head = new ListNode25();

        ListNode25 current = head;

        for (int i = 0; i < str.length(); i++) {
            current.next = new ListNode25(Integer.parseInt(str.substring(i, i + 1)));
            current = current.next;
        }

        return head.next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        ListNode25 current = this;

        while (current != null) {
            sb.append(current.val);
            sb.append("->");
            current = current.next;
        }
        sb.delete(sb.length() - 2, sb.length());

        return sb.toString();
    }
}
