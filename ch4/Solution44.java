package ch4;

public class Solution44 {

    // getHeight method returns -1 if current tree is unbalanced, returns the current max height if current is balanced
    // recursively get all getHeight
    // if root is -1 then it's unbalanced, if not, then is balanced

    public static boolean checkBalanced(Node root) {

        return getHeight(root) != -1;

    }

    private static int getHeight(Node current) {

        if (current == null) {
            return 0;
        }

        int leftHeight = getHeight(current.left);
        int rightHeight = getHeight(current.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    // Test Method Below

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
