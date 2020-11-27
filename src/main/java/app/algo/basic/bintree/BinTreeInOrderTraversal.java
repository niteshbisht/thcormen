package app.algo.basic.bintree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinTreeInOrderTraversal {

    List<Integer> inorderTraversal(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        helper(node, res);
        return res;
    }

    void helper(TreeNode node, List<Integer> res) {
        if (node != null) {
            if (node.left != null) {
                helper(node.left, res);
            }
            res.add(node.val);
            if (node.right != null) {
                helper(node.right, res);
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
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
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
                curr = curr.left;
            } else {
                curr = stack.pop();
                res.add(curr.val);
                curr = curr.right;
            }
        }
        return res;
    }

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
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right; // move to next right node
            } else { // has a left subtree
                pre = curr.left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                pre.right = curr; // put cur after the pre node
                TreeNode temp = curr; // store cur node
                curr = curr.left; // move cur to the top of the new tree
                temp.left = null; // original cur left be null, avoid infinite loops
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

        one.left = two;
        one.right = three;

        two.left = four;
        two.right = five;

        three.left = six;

        System.out.println(inorderUsingMorrisTraversal(one));
    }

    static TreeNode createT(int val) {
        return new TreeNode(val, null, null);
    }
}
