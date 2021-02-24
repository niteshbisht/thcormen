package app.algo.basic.backtracking;

import app.algo.util.AlgoUtils;
import app.algo.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BinTreeToDoubleLinkedList {
  TreeNode first;
  TreeNode last;

  public static void main(String[] args) {
    BinTreeToDoubleLinkedList btl = new BinTreeToDoubleLinkedList();
    TreeNode root = AlgoUtils.createTree();
    TreeNode binTreeToDll = btl.binTreeToDll(root);
    log.info("Bin tree to linked list {}", binTreeToDll.val);
  }

  void helper(TreeNode node) {
    if (node != null) {
      helper(node.left);
      if (last != null) {
        last.right = node;
        node.left = last;
      } else {
        first = node;
      }
      last = node;
      helper(node.right);
    }
  }

  TreeNode binTreeToDll(TreeNode root) {
    if (root == null) return null;
    helper(root);
    last.right = first;
    first.left = last;
    return first;
  }
}
