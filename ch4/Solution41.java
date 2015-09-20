package ch4;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution41 {

    // do a breadth first search on this graph.
    // once bfs finds a node that's equal to node2 return true
    // if bfs ends without hits, return false

    public static boolean hasPath(Node node1, Node node2) {

        HashSet<Node> hashSet = new HashSet<>();

        ArrayList<Node> nodes = new ArrayList<>();

        int current = 0;

        if (node1 == null) {
            return false;
        }

        nodes.add(node1);

        while (current != nodes.size()) {
            for (Node node : node1.out) {
                if (!hashSet.contains(node)) {
                    nodes.add(node);
                    if (node == node2) {
                        return true;
                    }
                }
            }
            current++;
        }
        return false;
    }



    static class Node {
        Node[] in;
        Node[] out;
    }

}
