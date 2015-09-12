package ch2;

import helper.ListNode;

public class Solution22NC {

    //    structure of ListNode class
    //    public class ListNode {
    //        public ListNode next;
    //        public Object val;
    //        public ListNode(Object val) {
    //            this.val = val;
    //        }
    //    }


    public static ListNode kthToLast(ListNode head, int k) {
        ListNode kth = null;
        ListNode current = head;

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
}
