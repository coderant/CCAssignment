package ch2;

import helper.ListNode;

public class Solution25NC {

    public static ListNode sumList(ListNode l1, ListNode l2) {

        int carry = 0;
        int sum = 0;

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


    public static void main(String[] args) {
        System.out.println(reverse(ListNode.makeIntList("90")));
    }


}
