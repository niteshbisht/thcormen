package chapter.fourteen.days01;

public class BinSearchSolve01 {
  public static void main(String[] args) {
    BinSearchSolve01 bs = new BinSearchSolve01();
    int search = bs.search(new int[] {-1, 0, 3, 5, 9, 12}, 9);
    System.out.println(search);
  }

  public int search(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;
    int mid = (r - l) / 2;
    while (l < r) {
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
      mid = l + ((r - l) / 2);
    }
    return -1;
  }
}
