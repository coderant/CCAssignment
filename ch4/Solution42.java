package ch4;


import java.util.ArrayList;

public class Solution42 {

    // always choose the middle int as the root of the BST
    // recursively construct the leftBST and rightBST
    // link leftBST root and rightBST
    public static Node generateBST(int[] array) {
        return generateBST(array, 0, array.length - 1);
    }

    private static Node generateBST(int[] array, int start, int end) {
        int mid = start + (end - start) / 2;

        if (start == end) {
            return new Node(array[start]);
        } else if (start > end) {
            return null;
        }

        Node root = new Node(array[mid]);

        root.left = generateBST(array, start, mid - 1);
        root.right = generateBST(array, mid + 1, end);

        return root;
    }


    // Test Method Below


    public static void main(String[] args) {

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


        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

    }


}
