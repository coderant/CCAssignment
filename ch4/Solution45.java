package ch4;

public class Solution45 {

    // recursively validate a root's left child and right child,
    // and at the mean time updating the maxValue or minValue of it's children's lower and upper bound

    public static boolean validate(Node root) {
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validate(Node current, int min, int max) {

        if (current == null) {
            return true;
        }

        if (current.val <= min || current.val >= max) {
            return false;
        }

        return validate(current.left, min, current.val) && validate(current.right, current.val, max);

    }

    // Test Method Below

    public static void main(String[] args) {

    }

    static class Node {
        Node left;
        Node right;
        int val;


        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

    }
}
