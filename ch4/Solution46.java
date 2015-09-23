package ch4;

public class Solution46 {

    // if a node has right child, then return the left-most child in it's right subtree
    // if a node has no right child, then go up to it's ancestors, until an ancestor is a left child.

    public static Node getNext(Node current) {

        if (current == null) {
            return null;
        }

        if (current.right != null) {
            Node node = current.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            Node node = current.parent;
            while (node.parent != null && node.val > node.parent.val) {
                node = node.parent;
            }
            return node.parent;

        }
    }

    // Test Method Below

    static class Node {
        Node parent;
        Node left;
        Node right;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

}
