package ch2;

import java.util.HashSet;

public class Solution21NC {

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

    public static void main(String[] args) {
        test(1, "abcabccccccc", "ABC", "1111111111222", "2");
        test(2, "abcabccccccc", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "1111111111222", "2");
    }



    private static void test(int way, String... strs) {
        if (way == 1) {
            for (String str : strs) {
                System.out.print(ListNode.makeCharList(str));
                System.out.print(" is converted to ");
                System.out.println(Solution21NC.removeDupHash(ListNode.makeCharList(str)));
            }
        } else if (way == 2) {
            for (String str : strs) {
                System.out.print(ListNode.makeCharList(str));
                System.out.print(" is converted to ");
                System.out.println(Solution21NC.removeDupNoBuffer(ListNode.makeCharList(str)));
            }
        }
    }

    static class ListNode {
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
                current.next = new ListNode(Integer.parseInt(str.substring(i, i + 1)));
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
                sb.append("->");
                current = current.next;
            }
            sb.delete(sb.length() - 2, sb.length());

            return sb.toString();
        }
    }
}

