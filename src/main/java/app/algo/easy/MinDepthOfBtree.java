package app.algo.easy;

import app.algo.util.TreeNode;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;

public class MinDepthOfBtree {
  /**
   * This method uses the DFS approach using stack to search for leaf node in tree
   *
   * @param root
   * @return
   */
  public int minDepthDfs(TreeNode root) {
    LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
    stack.push(new Pair<>(root, 1));
    int minDepth = Integer.MAX_VALUE;

    while (!stack.isEmpty()) {
      Pair<TreeNode, Integer> p = stack.pollLast();
      TreeNode t = p.getKey();
      int currentDepth = p.getValue();
      if (t.left == null && t.right == null) {
        Math.min(currentDepth, minDepth);
      }
      if (t.left != null) {
        stack.add(new Pair<>(t.left, currentDepth + 1));
      }
      if (t.right != null) {
        stack.add(new Pair<>(t.right, currentDepth + 1));
      }
    }
    return minDepth;
  }

  public int minDepthBfs(TreeNode root) {
    LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
    if (root == null) {
      return 0;
    } else {
      queue.add(new Pair<>(root, 1));
    }

    int current_depth = 0;
    while (!queue.isEmpty()) {
      Pair<TreeNode, Integer> current = queue.poll();
      root = current.getKey();
      current_depth = current.getValue();
      if ((root.left == null) && (root.right == null)) {
        break;
      }
      if (root.left != null) {
        queue.add(new Pair<>(root.left, current_depth + 1));
      }
      if (root.right != null) {
        queue.add(new Pair<>(root.right, current_depth + 1));
      }
    }
    return current_depth;
  }

  public int minDepthRecur(TreeNode root) {
    if (root == null) return 0;

    if (root.left == null && root.right == null) return 1;

    int minDepth = Integer.MAX_VALUE;
    if (root.left != null) {
      minDepth = Math.min(minDepthRecur(root.left), minDepth);
    }
    if (root.right != null) {
      minDepth = Math.min(minDepthRecur(root.right), minDepth);
    }
    return minDepth + 1;
  }

  @Data
  @AllArgsConstructor
  static class Pair<K, V> {
    K key;
    V value;
  }
}
