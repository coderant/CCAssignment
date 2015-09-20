package ch4;

public class Solution412 {



    private static int count = 0;

    public static void getPathSum(Node root, int val, int sumSoFar) {

        if (sumSoFar == val) {
            count++;
        }

        if (root == null) {
            return;
        }

        getPathSum(root.right, val, sumSoFar + root.val);
        getPathSum(root.left, val, sumSoFar + root.val);

    }



    static class Node {
        Node left;
        Node right;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }
}
