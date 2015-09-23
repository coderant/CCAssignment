package ch4;

import java.util.ArrayList;

public class Solution411 {

    // when insert and delete node from the BT
    // keep track of a list of all nodes currently in the BT
    // when getRandom is called. The algorithm will generate a random index and return the node at this index.

    static class RandomBT {

        class Node {
            int val;
            Node left;
            Node right;
            Node parent;

            public Node(int val, Node parent) {
                this.val = val;
                this.parent = parent;
            }
        }

        ArrayList<Node> nodes;
        Node root;

        public RandomBT() {
            nodes = new ArrayList<>();
        }

        public Node getRandomNode() {
            return nodes.get(((int) (Math.random() * nodes.size())) - 1);
        }

        public void insert(int foo) {
            if (root == null) {
                root = new Node(foo, null);
                nodes.add(root);
                return;
            } else {
                insert(root, foo);
            }
        }

        private void insert(Node node, int foo) {
            if (foo < node.val) {
                if (node.left == null) {
                    node.left = new Node(foo, node);
                    nodes.add(node.left);
                } else {
                    insert(node.left, foo);
                }
            } else {
                if (node.right == null) {
                    node.right = new Node(foo, node);
                    nodes.add(node.right);
                } else {
                    insert(node.right,foo);
                }
            }
        }

        public Node find(int foo) {
            return find(root, foo);
        }

        private Node find(Node node, int foo) {
            if (node == null) {
                return null;
            }

            if (node.val == foo) {
                return node;
            } else if (node.val < foo) {
                return find(node.right, foo);
            } else {
                return find(node.left, foo);
            }
        }

        public Node delete(int foo) {

            return null;
        }
    }
}
