package ch2;

import java.util.HashMap;

public class Solution28 {


    // 0 -> 0 -> 0 -> 0 -> 0 -> 0 -> 0 -> 0 -> 0 -> 0
    //                     A                        |
    //                     |------------------------|
    //
    // assume circle length is L
    // slow node "turtle" walks X steps; fast node "rabbit" walks 2X steps when they meet
    // At this time, rabbit has walk L more step than turtle.
    // thus X + L = 2X
    // thus X = L
    // This means turtle walked the same distance as the length of the circle.
    // but this time the turtle must have entered the loop
    // thus X a overlap with the loop, let it be Y steps
    // thus X - Y = L - Y
    // this means the steps turtle walked before entering the loop is the same as the remaining length of the loop.
    // thus we move turtle to the beginning, and let rabbit walk one step at a time.
    // whenever they meet. It's the entry point.

    // algorithm reference: http://stackoverflow.com/questions/2663115/how-to-detect-a-loop-in-a-linked-list

    // return null if no loop found
    public static ListNode28 findLoop(ListNode28 head) {

        if (head == null || head.next == null) {
            return new ListNode28(null);
        }


        ListNode28 rabbit = head;
        ListNode28 turtle = head;

        while (true) {

            turtle = turtle.next;

            if (rabbit.next != null) {
                rabbit = rabbit.next.next;
            }

            if (rabbit == null) {
                return new ListNode28(null);
            }

            if (rabbit == turtle) {
                break;
            }
        }

        // loop found

        turtle = head;

        while (turtle != rabbit) {
            turtle = turtle.next;
            rabbit = rabbit.next;
        }

        return turtle;
    }

    // Test Method Below

    private static HashMap<Character, ListNode28> nodesMap = new HashMap<>();

    private static ListNode28 makeList(String string) {

        ListNode28 dummy = new ListNode28("Dummy");
        ListNode28 current = dummy;

        for (int i = 0; i < string.length(); i++) {

            char val = string.charAt(i);

            if (nodesMap.containsKey(val)) {
                current.next = nodesMap.get(val);
            } else {
                current.next = new ListNode28(val);
                nodesMap.put(val, current.next);
            }
            current = current.next;
        }
        return dummy.next;

    }

    public static void main(String[] args) {

        test("1234567894", "abcdefgg", "pp", "qwer", "");

    }

    private static void test(String... strings) {
        for (String string : strings) {

            ListNode28 l1 = makeList(string);
            System.out.print("entry point in list " + string + " is : ");
            System.out.println(findLoop(l1).val);

        }
    }



}

class ListNode28 {
    public ListNode28 next;
    public Object val;

    public ListNode28() {
    }

    public ListNode28(Object val) {
        this.val = val;
    }

    public static ListNode28 makeCharList(String str) {
        return makeCharList(str.toCharArray());
    }

    public static ListNode28 makeCharList(char[] chars) {

        ListNode28 head = new ListNode28();
        ListNode28 current = head;
        for (char c : chars) {
            current.next = new ListNode28(c);
            current = current.next;
        }
        return head.next;

    }

    public static ListNode28 makeIntList(String str) {
        ListNode28 head = new ListNode28();

        ListNode28 current = head;

        for (int i = 0; i < str.length(); i++) {
            current.next = new ListNode28(Integer.parseInt(str.substring(i, i + 1)));
            current = current.next;
        }

        return head.next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        ListNode28 current = this;

        while (current != null) {
            sb.append(current.val);
            sb.append("->");
            current = current.next;
        }
        sb.delete(sb.length() - 2, sb.length());

        return sb.toString();
    }
}