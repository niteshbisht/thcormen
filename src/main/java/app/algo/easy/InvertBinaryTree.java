package app.algo.easy;

import app.algo.util.AlgoUtils;
import app.algo.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
  public static void main(String[] args) {
    TreeNode treeNode = AlgoUtils.createTree();
  }

  public TreeNode invertTree(TreeNode root) {
    return null;
  }

  void swapLeftRight(TreeNode node) {
    if (node == null) {
      return;
    }
    TreeNode t = node.left;
    node.left = node.right;
    node.right = t;
    swapLeftRight(node.left);
    swapLeftRight(node.right);
  }

  TreeNode invertBinaryTree(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode curr = queue.poll();
      TreeNode left = curr.left;
      curr.left = curr.right;
      curr.right = left;
      if (curr.left != null) queue.add(curr.left);
      if (curr.right != null) queue.add(curr.right);
    }
    return root;
  }
}
