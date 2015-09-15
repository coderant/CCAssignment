package ch3;

import java.util.ArrayList;
import java.util.Stack;

public class Solution33 {


    // maintain a ArrayList of normal stacks
    // whenever the last array hit threshold, add a new stack
    // whenever the last array is popped empty, delete this stack
    static class SetOfStacks {

        ArrayList<Stack<Character>> stacks = new ArrayList<>();

        private int threshold;

        private Stack<Character> currentStack;

        public SetOfStacks(int threshold) {
            this.threshold = threshold;
            currentStack = new Stack<>();
            stacks.add(currentStack);
        }

        public void push(char c) {

            currentStack.push(c);

            // check if threshold is hit
            if (currentStack.size() >= threshold) {
                currentStack = new Stack<>();
                stacks.add(currentStack);
            }
        }

        public char pop() {

            // check if the last array is empty
            if (currentStack.size() == 0) {
                stacks.remove(stacks.size() - 1);
                currentStack = stacks.get(stacks.size() - 1);
            }

            return currentStack.pop();
        }


        // Test Method Below

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            for (Stack<Character> stack : stacks) {
                if (stack.size() >= 1) {
                    for (Character character : stack.toArray(new Character[1])) {
                        sb.append(character + " -> ");
                    }
                    sb.append("\n");
                }
            }
            if (stacks.get(0).size() >= 1) {
                sb.delete(sb.length() - 4, sb.length());
            }
            return sb.toString();
        }
    }



    public static void main(String[] args) {
        SetOfStacks stacks = new SetOfStacks(3);
        stacks.push('c');
        stacks.push('c');
        stacks.push('c');
        stacks.push('c');
        stacks.push('c');
        stacks.push('c');

        stacks.pop();
        stacks.pop();
        stacks.pop();
        stacks.pop();
        System.out.println(stacks);
    }

}
