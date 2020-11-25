package app.algo.basic.bintree;

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
            res.add(node.value);
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
        while (curr!=null || !stack.isEmpty()) {
            while (curr!=null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.value);
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
        while (curr!=null || !stack.isEmpty()) {
            if (curr!=null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                res.add(curr.value);
                curr = curr.right;
            }
        }
        return res;
    }

    List<Integer> inorderUsingMorrisTraversal(TreeNode node) {

        return null;
    }
}
