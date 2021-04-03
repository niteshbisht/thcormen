package app.algo.basic.bintree;

import app.algo.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinTreeInOrderTraversal {

    /**
     * Threaded Binary Tree Data Structure
     *
     * @param root
     * @return
     */
    static List<Integer> inorderUsingMorrisTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.getLeft() == null) {
                res.add(curr.getVal());
                curr = curr.getRight(); // move to next right node
            } else { // has a left subtree
                pre = curr.getLeft();
                while (pre.getRight() != null) { // find rightmost
                    pre = pre.getRight();
                }
                pre.setRight(curr); // put cur after the pre node
                TreeNode temp = curr; // store cur node
                curr = curr.getLeft(); // move cur to the top of the new tree
                temp.setLeft(null); // original cur left be null, avoid infinite loops
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode one = createT(1);
        TreeNode two = createT(2);
        TreeNode three = createT(3);
        TreeNode four = createT(4);
        TreeNode five = createT(5);
        TreeNode six = createT(6);

        one.setLeft(two);
        one.setRight(three);

        two.setLeft(four);
        two.setRight(five);

        three.setLeft(six);

        System.out.println(inorderUsingMorrisTraversal(one));
    }

    static TreeNode createT(int val) {
        return new TreeNode(val, null, null);
    }

    List<Integer> inorderTraversal(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        helper(node, res);
        return res;
    }

    void helper(TreeNode node, List<Integer> res) {
        if (node != null) {
            if (node.getLeft() != null) {
                helper(node.getLeft(), res);
            }
            res.add(node.getVal());
            if (node.getRight() != null) {
                helper(node.getRight(), res);
            }
        }
    }

    // dual loop
    List<Integer> inorderTraversalUsingStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.getLeft();
            }
            curr = stack.pop();
            res.add(curr.getVal());
            curr = curr.getRight();
        }
        return res;
    }

    // single loop implementation
    List<Integer> inorderTraversalUsingStackSinLoop(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.getLeft();
            } else {
                curr = stack.pop();
                res.add(curr.getVal());
                curr = curr.getRight();
            }
        }
        return res;
    }
}
