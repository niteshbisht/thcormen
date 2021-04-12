package app.algo.easy;

import app.algo.util.AlgoUtils;
import app.algo.util.TreeNode;

/** leetcode problem no 23/easy */
public class CreateHeightBalancedBst {

  static TreeNode createBSTFromSortedArray(int[] nums) {
    return sortedArrToBst(0, nums.length - 1, nums);
  }

  static TreeNode sortedArrToBst(int start, int end, int[] nums) {
    if (start > end) return null;
    int mid = (start + end) / 2;
    return new TreeNode(
        nums[mid], sortedArrToBst(start, mid - 1, nums), sortedArrToBst(mid + 1, end, nums));
  }

  public static void main(String[] args) {
    int[] arr = {-10, -3, 0, 5, 9};
    TreeNode node = createBSTFromSortedArray(arr);
    AlgoUtils.preOrder(node);
    // AlgoUtils.createTreeNodeFromArray(arr);
  }
}
