package app.algo.easy;

import app.algo.util.AlgoUtils;
import app.algo.util.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class SameTree {

  public static boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if ((p != null && q == null) || (p == null && q != null)) return false;
    if (p.val != q.val) return false;
    boolean left = isSameTree(p.left, q.left);
    boolean right = isSameTree(p.right, q.right);
    return left && right;
  }

  public static void main(String[] args) {
    TreeNode tree = AlgoUtils.createTree();
    TreeNode tree2 = AlgoUtils.createTree();
    tree2.left.val = 8;
    System.out.println(isSameTree(tree, tree2));
  }

  public boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    q.add(root);
    while (!q.isEmpty()) {
      TreeNode t1 = q.poll();
      TreeNode t2 = q.poll();
      if (t1 == null && t2 == null) continue;
      if (t1 == null || t2 == null) return false;
      if (t1.val != t2.val) return false;
      q.add(t1.left);
      q.add(t2.right);
      q.add(t1.right);
      q.add(t2.left);
    }
    return true;
  }
}
