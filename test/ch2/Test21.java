package test.ch2;

import ch2.Solution21NC;
import helper.ListNode;

public class Test21 {

    public static void main(String[] args) {
        test(1, "abcabccccccc", "ABC", "1111111111222", "2");
        test(2, "abcabccccccc", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "1111111111222", "2");
    }



    private static void test(int way, String... strs) {
        if (way == 1) {
            for (String str : strs) {
                System.out.print(ListNode.makeList(str));
                System.out.print(" --> ");
                System.out.println(Solution21NC.removeDupHash(ListNode.makeList(str)));
            }
        } else if (way == 2) {
            for (String str : strs) {
                System.out.print(ListNode.makeList(str));
                System.out.print(" --> ");
                System.out.println(Solution21NC.removeDupNoBuffer(ListNode.makeList(str)));
            }
        }
    }

}
