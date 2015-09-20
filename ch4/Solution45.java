package ch4;

public class Solution45 {

    public static boolean checkBalance(Node root) {
        return checkBalance(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean checkBalance(Node current,int min, int max) {

        if (current == null) {
            return true;
        }

        if (current.val <= min || current.val >= max) {
            return false;
        }

        return checkBalance(current.left, min, current.val) && checkBalance(current.right, current.val, max);

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
