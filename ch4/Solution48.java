package ch4;

public class Solution48 {

    // recursive find ancestor
    // method returns node A once it found node A in it's subtree
    //        returns node B once it found node B in it's subtree
    // if a node's left child returns a non-null result and right child returns a non-null result
    // then this node is the lowest common ancestor

    public static Node findAncestor(Node current, Node n1, Node n2) {
        if (current == null || current == n1 || current == n2) {
            return current;
        }

        Node leftResult = findAncestor(current.left, n1, n2);
        Node rightResult = findAncestor(current.right, n1, n2);

        if (leftResult != null && rightResult != null) {
            return current;
        }

        if (leftResult != null) {
            return leftResult;
        }

        if (rightResult != null) {
            return rightResult;
        }

        return null;
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
