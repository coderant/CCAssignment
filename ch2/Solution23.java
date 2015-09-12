package ch2;

import helper.ListNode;

public class Solution23 {

    public static void deleteMiddle(ListNode node) {

        // kill the scapegoat
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
