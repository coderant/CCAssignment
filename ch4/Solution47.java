package ch4;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution47 {

    public static ArrayList<Node> getOrder(String str, char[][] dependencies) {

        HashMap<Character, Node> hashMap = new HashMap<>();
        ArrayList<Node> result = new ArrayList<>();

        for (char c : str.toCharArray()) {
            Node node = new Node(c);
            hashMap.put(c, node);
        }

        for (int i = 0; i < dependencies.length; i++) {
            char[] dependency = dependencies[i];

            hashMap.get(dependency[0]).from.add(hashMap.get(dependency[1]));
            hashMap.get(dependency[1]).to.add(hashMap.get(dependency[0]));
        }

        for (int i = 1; i <= str.length(); i++) {

            Node node = get(hashMap);

            result.add(node);

            deleteNode(node, hashMap);
        }

        return result;
    }

    private static Node get(HashMap<Character, Node> hashMap) {
        for (Node node : hashMap.values()) {
            if (node.from.size() == 0) {
                return node;
            }
        }
        return null;
    }

    private static void deleteNode(Node node, HashMap<Character, Node> hashMap) {
        for (Node node1 : node.to) {
            node1.from.remove(node);
        }
        for (Node node1 : node.from) {
            node1.to.remove(node);
        }

        hashMap.remove(node.c);
    }

    // Test Method Below

    public static void main(String[] args) {
        String projects = "abcdef";

        char[][] dependencies = new char[][]{
                {'d','a'},
                {'b','f'},
                {'d','b'},
                {'a','f'},
                {'c','d'},
        };

        System.out.println(getOrder(projects, dependencies));
    }

    static class Node {
        ArrayList<Node> to;
        ArrayList<Node> from;
        char c;

        public Node(char c) {
            this.c = c;
            to = new ArrayList<>();
            from = new ArrayList<>();
        }

        @Override
        public String toString() {
            return Character.toString(c);
        }
    }
}
