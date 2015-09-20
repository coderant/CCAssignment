package ch4;


import java.util.ArrayList;

public class Solution42 {

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

        int length = 30;

        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = i;
        }

        BTreePrinter.printNode(generateBST(array));
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


    // code edited from http://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
    static class BTreePrinter {

        public static void printNode(Node root) {
            int maxLevel = BTreePrinter.maxLevel(root);

            ArrayList<Node> arrayList = new ArrayList<Node>();
            arrayList.add(root);

            printNodeInternal(arrayList, 1, maxLevel);
        }

        private static void printNodeInternal(ArrayList<Node> nodes, int level, int maxLevel) {
            if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
                return;

            int floor = maxLevel - level;
            int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
            int firstSpaces = (int) Math.pow(2, (floor)) - 1;
            int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

            BTreePrinter.printWhitespaces(firstSpaces);

            ArrayList<Node> newNodes = new ArrayList<Node>();
            for (Node node : nodes) {
                if (node != null) {
                    System.out.print(node.val);
                    newNodes.add(node.left);
                    newNodes.add(node.right);
                } else {
                    newNodes.add(null);
                    newNodes.add(null);
                    System.out.print(" ");
                }

                BTreePrinter.printWhitespaces(betweenSpaces);
            }
            System.out.println("");

            for (int i = 1; i <= endgeLines; i++) {
                for (int j = 0; j < nodes.size(); j++) {
                    BTreePrinter.printWhitespaces(firstSpaces - i);
                    if (nodes.get(j) == null) {
                        BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                        continue;
                    }

                    if (nodes.get(j).left != null)
                        System.out.print("/");
                    else
                        BTreePrinter.printWhitespaces(1);

                    BTreePrinter.printWhitespaces(i + i - 1);

                    if (nodes.get(j).right != null)
                        System.out.print("\\");
                    else
                        BTreePrinter.printWhitespaces(1);

                    BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
                }

                System.out.println("");
            }

            printNodeInternal(newNodes, level + 1, maxLevel);
        }

        private static void printWhitespaces(int count) {
            for (int i = 0; i < count; i++)
                System.out.print(" ");
        }

        private static int maxLevel(Node node) {
            if (node == null)
                return 0;

            return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
        }

        private static  boolean isAllElementsNull(ArrayList<Node> list) {
            for (Object object : list) {
                if (object != null)
                    return false;
            }

            return true;
        }

    }
}
