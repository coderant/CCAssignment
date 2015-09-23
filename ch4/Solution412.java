package ch4;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution412 {


    private static HashMap<Node, ArrayList<Integer>> sums = new HashMap<>();

    public static int getPathSum(int target, Node node) {

        if (target == 0) {
            return 0;
        }

        int count = 0;

        generateSums(node);

        for (ArrayList<Integer> arrayList : sums.values()) {
            for (int i : arrayList) {
                if (i == target) {
                    count++;
                }
            }
        }

        return count;
    }

    private static ArrayList<Integer> generateSums(Node node) {

        ArrayList<Integer> nodeSums = new ArrayList<>();

        nodeSums.add(0);

        if (node == null) {
            return nodeSums;
        }

        if (node.right == null && node.left == null) {
            sums.put(node, nodeSums);
            nodeSums.add(node.val);
            return nodeSums;
        }

        ArrayList<Integer> leftSums = generateSums(node.left);
        ArrayList<Integer> rightSums = generateSums(node.right);

        for (int i : leftSums) {
            nodeSums.add(i + node.val);
        }

        for (int i : rightSums) {
            if (i != 0) {
                nodeSums.add(i + node.val);
            }
        }

        sums.put(node, nodeSums);

        return nodeSums;

    }




//    private static int count = 0;

//    public static int getPathSum(int val, Node node) {
//        getPathSum(node, val);
//
//        return count;
//    }
//
//    public static void getPathSum(Node root, int val) {
//
//        if (root == null) {
//            return;
//        }
//
//        getPathSum(root, val, 0);
//
//        getPathSum(root.left, val);
//        getPathSum(root.right, val);
//
//    }
//
//    public static void getPathSum(Node root, int val, int sumSoFar) {
//
//        if (sumSoFar == val) {
//            count++;
//        }
//
//        if (root == null) {
//            return;
//        }
//
//        getPathSum(root.right, val, sumSoFar + root.val);
//        getPathSum(root.left, val, sumSoFar + root.val);
//
//    }


    // Test Method Below

    public static void main(String[] args) {
        Solution42 generator = new Solution42();

        int length = 2;

        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = i;
        }



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
