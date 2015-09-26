package ch4;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution49 {

    // recursively get sequence
    // the root node need to come first and then left subtree sequence and right subtree sequence can take turns and be mixed
    // once all possible sequence has been added, return the new sequence

    public static ArrayList<LinkedList<Integer>> getSequence(Node root) {

        ArrayList<LinkedList<Integer>> result = new ArrayList<>();

        if (root == null) {
            result.add(new LinkedList<>());
            return result;
        }

        if (root.right == null && root.left == null) {
            LinkedList<Integer> list = new LinkedList<>();
            list.add(root.val);
            result.add(list);
            return result;
        }

        ArrayList<LinkedList<Integer>> leftResult = getSequence(root.left);
        ArrayList<LinkedList<Integer>> rightResult = getSequence(root.right);

        for (LinkedList<Integer> leftArrayList : leftResult) {
            for (LinkedList<Integer> rightArrayList : rightResult) {

                LinkedList<LinkedList<Integer>> allCombinations = new LinkedList<>();

                addCombination(null, leftArrayList, rightArrayList, allCombinations);

                for (LinkedList<Integer> oneCombination : allCombinations) {
                    oneCombination.addFirst(root.val);
                    result.add(oneCombination);
                }

            }
        }
        return result;

    }

    private static void addCombination(LinkedList<Integer> prefix,
                                       LinkedList<Integer> left,
                                       LinkedList<Integer> right,
                                       LinkedList<LinkedList<Integer>> results) {

        if (prefix == null) {
            prefix = new LinkedList<>();
        }

        if (left.size() == 0 && right.size() == 0) {
            results.add((new LinkedList<>(prefix)));
        }

        if (!left.isEmpty()) {
            prefix.add(left.removeFirst());
            addCombination(prefix, left, right, results);
            left.addFirst(prefix.removeLast());
        }

        if (!right.isEmpty()) {
            prefix.add(right.removeFirst());
            addCombination(prefix, left, right, results);
            right.addFirst(prefix.removeLast());
        }
    }

    // Test Method Below

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node4.left = node2;
        node2.left = node1;
        node2.right = node3;

        print(getSequence(node4));

    }

    private static void print(ArrayList<LinkedList<Integer>> lists) {
        for (LinkedList<Integer> list : lists) {
            System.out.println(list);
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
