package test.ch2;

import ch2.Solution25NC;
import helper.ListNode;

public class Test25 {

    public static void main(String[] args) {

        test("123","123");
        test("999","999");
        test("1","999999");

    }

    public static void test(String string1, String string2) {

        System.out.println("Original : ");

        System.out.print(ListNode.makeIntList(string1) + " + " + ListNode.makeIntList(string2) + " = ");
        System.out.println(Solution25NC.sumList(ListNode.makeIntList(string1), ListNode.makeIntList(string2)));

        System.out.println("FollowUp : ");

        System.out.print(ListNode.makeIntList(string1) + " + " + ListNode.makeIntList(string2) + " = ");
        System.out.println(Solution25NC.sumListFollow(ListNode.makeIntList(string1), ListNode.makeIntList(string2)));
    }

}
