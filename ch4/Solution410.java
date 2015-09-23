package ch4;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution410 {

    // first get size of tree B
    // secondly recursively get all sizes of subtrees in tree A
    // iterate through all nodes in tree A
    //    if size of the subtree is the same as the size of B
    //    call isSame method on this node and tree B to check if they are the same node

    public static boolean checkSubtree(Node root1, Node root2) {

        if (root1 == null) {
            return root2 == null;
        }

        if (root2 == null) {
            return false;
        }

        HashMap<Node, Integer> sizeMap2 = new HashMap<>();

        int size2 = getSize(root2, null, sizeMap2);

        HashMap<Node, Integer> sizeMap1 = new HashMap<>();

        ArrayList<Node> nodes1 = new ArrayList<>();

        getSize(root1, nodes1, sizeMap1);

        for (Node node : nodes1) {
            if (sizeMap1.get(node) == size2) {
                if (isSame(node, root2)) {
                    return true;
                }
            }
        }
        return false;

    }

    public static int getSize(Node root, ArrayList<Node> list, HashMap<Node, Integer> sizeMap) {

        if (root.left == null && root.right == null) {
            sizeMap.put(root, 1);
            return 1;
        }
        if (list != null) {
            list.add(root);
        }

        int leftSize = getSize(root.left, list, sizeMap);
        int rightSize = getSize(root.right, list, sizeMap);

        sizeMap.put(root, leftSize + rightSize + 1);
        return sizeMap.get(root);


    }

    public static boolean isSame(Node root1, Node root2) {

        if (root1 == null) {
            return root2 == null;
        }

        if (root2 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return isSame(root1.left, root2.left) && isSame(root2.right, root2.right);

    }


    // Test Method Below

    static class Node {
        Node left;
        Node right;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

}
