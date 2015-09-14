package ch2;

import java.util.HashSet;

public class Solution21NC {

    public static ListNode21 removeDupHash(ListNode21 head) {

        HashSet<Object> hash = new HashSet<>();

        ListNode21 node = head;
        ListNode21 prev = null;

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

    public static ListNode21 removeDupNoBuffer(ListNode21 head) {
        ListNode21 currentNode = head;


        while (currentNode != null) {
            ListNode21 prev = currentNode;
            ListNode21 followingNode = currentNode.next;
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
                System.out.print(ListNode21.makeCharList(str));
                System.out.print(" is converted to ");
                System.out.println(Solution21NC.removeDupHash(ListNode21.makeCharList(str)));
            }
        } else if (way == 2) {
            for (String str : strs) {
                System.out.print(ListNode21.makeCharList(str));
                System.out.print(" is converted to ");
                System.out.println(Solution21NC.removeDupNoBuffer(ListNode21.makeCharList(str)));
            }
        }
    }

}

class ListNode21 {
    public ListNode21 next;
    public Object val;

    public ListNode21() {
    }

    public ListNode21(Object val) {
        this.val = val;
    }

    public static ListNode21 makeCharList(String str) {
        return makeCharList(str.toCharArray());
    }

    public static ListNode21 makeCharList(char[] chars) {

        ListNode21 head = new ListNode21();
        ListNode21 current = head;
        for (char c : chars) {
            current.next = new ListNode21(c);
            current = current.next;
        }
        return head.next;

    }

    public static ListNode21 makeIntList(String str) {
        ListNode21 head = new ListNode21();

        ListNode21 current = head;

        for (int i = 0; i < str.length(); i++) {
            current.next = new ListNode21(Integer.parseInt(str.substring(i, i + 1)));
            current = current.next;
        }

        return head.next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        ListNode21 current = this;

        while (current != null) {
            sb.append(current.val);
            sb.append("->");
            current = current.next;
        }
        sb.delete(sb.length() - 2, sb.length());

        return sb.toString();
    }
}
