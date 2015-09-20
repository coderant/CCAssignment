package ch4;


import java.util.ArrayList;
import java.util.LinkedList;

public class Solution43 {

    public static ArrayList<ArrayList<Node>> levelOrder(Node root) {
        LinkedList<Node> queue = new LinkedList<>();

        ArrayList<ArrayList<Node>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        queue.offer(root);

        while (!queue.isEmpty()) {
            ArrayList<Node> levelList = new ArrayList<>();

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.remove();
                levelList.add(node);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(levelList);
        }

        return result;
    }



    // Test Method Below

    public static void main(String[] args) {
        int length = 20;

        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = i;
        }

        Solution42.BTreePrinter.printNode(Solution42.generateBST(array));
        System.out.println();

    }

    private static void printArray(ArrayList<ArrayList<Node>> arrayLists) {
        for (ArrayList<Node> arrayList : arrayLists) {
            for (Node node : arrayList) {
                System.out.print(node.val + ",");
            }
            System.out.println();
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
