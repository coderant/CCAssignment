package test.ch2;

import ch2.Solution24NC;
import helper.ListNode;

public class Test24 {

    public static void main(String[] args) {
        ListNode list1 = ListNode.makeIntList("112311");
        ListNode list2 = ListNode.makeIntList("987123456");
        ListNode list3 = ListNode.makeIntList("1234567890");
        ListNode list4 = ListNode.makeIntList("1234567890");
        ListNode list5 = ListNode.makeIntList("1234567890");
        ListNode list6 = ListNode.makeIntList("1234567890");


        System.out.println(Solution24NC.partition(list2, 99));
    }

}
