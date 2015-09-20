package ch3;

import java.util.Stack;

public class Solution32 {

    // use two stacks
    // one stack to store normal pushed element
    // the other stack to store the current minimum element
    // when push a new element, compare it with the top element in the minimum stack.
    // if it is smaller that the top element, then store the new element, if not store stack top element.

    public static Stack<Integer> stack = new Stack<>();
    public static Stack<Integer> stackMin = new Stack<>();

    public static void push(int number) {
        if (stackMin.isEmpty()) {
            stackMin.push(number);
        } else {
            stack.push(number);
            stackMin.push(Math.min(stackMin.peek(), number));
        }
        stack.push(number);
    }

    public static int pop() {
        stackMin.pop();
        return stack.pop();
    }

    public static int min() {
        return stackMin.peek();
    }

    // Test Method Below

    public static void main(String[] args) {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 20; i++) {
            int number = (int) (Math.random() * 1000);

            if (number < min) {
                min = number;
            }

            push(number);
            System.out.println(number + " is pushed");
            System.out.println("current min is : " + min);
            System.out.println("stack returned min is : " + min());
        }
    }
}
