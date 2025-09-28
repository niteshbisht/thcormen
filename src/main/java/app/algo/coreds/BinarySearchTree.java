package app.algo.coreds;

import lombok.AllArgsConstructor;
import lombok.Data;

public class BinarySearchTree {

  BtreeNode root;

  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();
    bst.insertRecordInBtree(2);
    bst.insertRecordInBtree(3);
    bst.insertRecordInBtree(6);
    bst.insertRecordInBtree(1);
    preOrder(bst.root);
  }

  public static void preOrder(BtreeNode node) {
    if (node == null) {
      System.out.print(node + " ");
      return;
    }
    System.out.print(node.val + " ");
    preOrder(node.left);
    preOrder(node.right);
  }

  public void insertRecordInBtree(int val) {
    root = insertHelper(root, val);
  }

  private BtreeNode insertHelper(BtreeNode node, int val) {
    if (node == null) {
      node = new BtreeNode(val, null, null);
      return node;
    }
    if (node.val > val) {
      node.left = insertHelper(node.left, val);
    } else {
      node.right = insertHelper(node.right, val);
    }
    return node;
  }

  @Data
  @AllArgsConstructor
  static class BtreeNode {
    int val;
    BtreeNode left;
    BtreeNode right;
  }
}
