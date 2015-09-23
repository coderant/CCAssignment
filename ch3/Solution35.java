package ch3;

import java.util.Stack;

public class Solution35 {

    // use a new stack to store the result
    // keep track the smallest element so far.
    // if current element is smaller than the min element, push min to the new stack
    // if current element is not smaller than the min element, push the current element to the new stack, keep the min element
    public static Stack<Integer> sortStack(Stack<Integer> stack) {

        Stack<Integer> sorted = new Stack<>();

        if (stack == null || stack.size() == 0 || stack.size() == 1) {
            return stack;
        }

        int min = stack.pop();

        while (!stack.isEmpty()) {
            int val = stack.pop();

            if (val <= min) {
                sorted.add(min);
                min = val;
            } else {
                sorted.add(val);
            }
        }
        sorted.add(min);

        return sorted;
    }

    // Test Method Below

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i < 10; i++) {
            stack.push(((int) (Math.random() * 100)));
        }

        System.out.println(stack);

        System.out.println(" |");
        System.out.println(" V");

        stack = sortStack(stack);

        System.out.println(stack);

    }

}
