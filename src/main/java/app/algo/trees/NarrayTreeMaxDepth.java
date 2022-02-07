package app.algo.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NarrayTreeMaxDepth {
    public static void main(String[] args) {

    }

    public int maxDepth(Node root) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        int depth = 0;
        while (!stack.isEmpty()) {
            Pair pop = stack.pop();
            int currDepth = pop.depth;
            Node curNode = pop.node;
            if (curNode != null) {
                depth = Math.max(currDepth, depth);
                for (Node c : curNode.children) {
                    stack.add(new Pair(c, currDepth + 1));
                }
            }
        }
        return depth;
    }

    public int maxDepthRec(Node root) {
        if (root == null) {
            return 0;
        } else if (root.children == null) {
            return 1;
        } else {
            List<Integer> height = new ArrayList<>();
            for (Node c : root.children) {
                height.add(maxDepthRec(c));
            }
            return Collections.max(height) + 1;
        }
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    static class Pair {
        Node node;
        int depth;

        public Pair(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
