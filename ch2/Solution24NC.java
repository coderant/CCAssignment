package ch2;

import helper.ListNode;

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
}
