package ch10;

public class Solution1010 {


    static class Node {

        int leftSize;

        Node left;
        Node right;

        int val;

        public Node(int val) {
            this.val = val;
            leftSize = 0;
        }

        public void insert(int x) {
            if (x <= val) {
                if (left == null) {
                    leftSize++;
                    left = new Node(x);
                } else {
                    leftSize++;
                    left.insert(x);
                }
            } else {
                if (right == null) {
                    right = new Node(x);
                } else {
                    right.insert(x);
                }
            }
        }

        public int getRank(int x) {
            if (x == val) {
                return leftSize;
            }

            if (left == null && right == null) {
                return -1;
            }

            if (x < val && left != null) {
                return left.getRank(x);
            }

            if (x > val && right != null) {
                return leftSize + 1 + right.getRank(x);
            }
            return -1;
        }
    }

    public static Node root;

    public static void track(int x) {
        if (root == null) {

            root = new Node(x);
            return;
        }

        root.insert(x);
    }

    public static int getRankOfNumber(int x) {
        return root.getRank(x);
    }

    // Test Method Below

    public static void main(String[] args) {
        int[] array = new int[]{5,1,4,4,5,9,7,13,3};

        for (int i : array) {
            track(i);
        }
        System.out.println(getRankOfNumber(1));
        System.out.println(getRankOfNumber(3));
        System.out.println(getRankOfNumber(4));
    }


}
