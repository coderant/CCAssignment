package test.ch2;

import ch2.Solution22NC;
import helper.ListNode;

public class Test22 {

    public static void main(String[] args) {
        ListNode list1 = ListNode.makeCharList("987659321");
        ListNode list2 = ListNode.makeCharList("111111119");
        ListNode list3 = ListNode.makeCharList("");

        System.out.println(Solution22NC.kthToLast(list1, 4));
        System.out.println(Solution22NC.kthToLast(list2, 1));
        System.out.println(Solution22NC.kthToLast(list3, 1));
        System.out.println(Solution22NC.kthToLast(list1, 9));

    }

}
