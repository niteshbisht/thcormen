package app.algo.util;

import java.util.LinkedList;

public class AlgoUtils {
  public static void swap(int[] arr, int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
  }

  public static TreeNode createTreeNodeFromArray(int[] arr) {
    LinkedList<TreeNode> resultNode = new LinkedList<>();
    TreeNode root = createT(arr[0]);
    resultNode.push(root);
    for (int i = 1; i < arr.length; i++) {
      TreeNode curr = resultNode.getLast();
      TreeNode newNode = createT(arr[i]);
      if (curr.left == null) {
        curr.left = newNode;
      } else if (curr.right == null) {
        curr.right = newNode;
      }
      resultNode.addLast(newNode);
    }
    return resultNode.get(0);
  }

  public static TreeNode createTree() {
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
    return one;
  }

  static TreeNode createT(int val) {
    return new TreeNode(val, null, null);
  }

  public static ListNode createListNodeFromArray(int[] arr) {
    ListNode start = null;
    ListNode prev = null;
    for (int i : arr) {
      if (start == null) {
        start = createNode(i);
        prev = start;
        continue;
      }
      if (prev != null) {
        prev.next = createNode(i);
        prev = prev.next;
      }
    }
    return start;
  }

  static ListNode createNode(int val) {
    return new ListNode(val);
  }

  public static void main(String[] args) {
    TreeNode nodeFromArray = createTreeNodeFromArray(new int[] {2, 3, 4, 5, 6, 7, 8, 9});
    System.out.println(nodeFromArray);
  }

  /* A utility function to print preorder traversal of BST */
  public static void preOrder(TreeNode node) {
    if (node == null) {
      System.out.print(node + " ");
      return;
    }
    System.out.print(node.val + " ");
    preOrder(node.left);
    preOrder(node.right);
  }
}
