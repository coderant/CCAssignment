package ch4;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution47 {

    public ArrayList<Node> getOrder(String str, char[][] dependencies) {

        HashMap<Character, Node> hashMap = new HashMap<>();

        for (char c : str.toCharArray()) {
            Node node = new Node(c);
            hashMap.put(c, node);
        }

        for (int i = 0; i < dependencies.length; i++) {

        }

        return null;
    }

    // Test Method Below

    public static void main(String[] args) {

    }

    static class Node {
        Node dependOn;
        Node dependent;
        char c;

        public Node(char c) {
            this.c = c;
        }
    }
}
