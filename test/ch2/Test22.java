package test.ch2;

import ch2.Solution22NC;
import helper.ListNode;

import java.util.LinkedList;

public class Test22 {

    public static void main(String[] args) {
        ListNode list1 = ListNode.makeList("987659321");
        ListNode list2 = ListNode.makeList("111111119");
        ListNode list3 = ListNode.makeList("");

        System.out.println(Solution22NC.kthToLast(list1, 4));
        System.out.println(Solution22NC.kthToLast(list2, 1));
        System.out.println(Solution22NC.kthToLast(list3, 1));
        System.out.println(Solution22NC.kthToLast(list1, 9));

    }

}
