package ch2;

import helper.ListNode;

import java.util.HashSet;


public class Solution21NC {

    //    structure of ListNode class
    //    public class ListNode {
    //        public ListNode next;
    //        public Object val;
    //        public ListNode(Object val) {
    //            this.val = val;
    //        }
    //    }

    public static ListNode removeDupHash(ListNode head) {

        HashSet<Object> hash = new HashSet<>();

        ListNode node = head;
        ListNode prev = null;

        while(node != null) {

            if (!hash.contains(node.val)) {

                hash.add(node.val);
                prev = node;
                node = node.next;

            } else {

                prev.next = node.next;
                node = node.next;

            }
        }

        return head;
    }

    public static ListNode removeDupNoBuffer(ListNode head) {
        ListNode currentNode = head;


        while (currentNode != null) {
            ListNode prev = currentNode;
            ListNode followingNode = currentNode.next;
            while (followingNode != null) {
                if (followingNode.val.equals(currentNode.val)) {
                    prev.next = followingNode.next;
                }
                followingNode = followingNode.next;
            }
            currentNode = currentNode.next;
        }
        return head;
    }

}
