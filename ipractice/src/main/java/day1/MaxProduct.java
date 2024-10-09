package day1;

public class MaxProduct {
    int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = nums[i];
            } else if (nums[i] > secondMax) {
                thirdMax = secondMax;
                secondMax = nums[i];
            } else if (nums[i] > thirdMax) {
                thirdMax = nums[i];
            }
        }
        return max * secondMax * thirdMax;
    }

    public static void main(String[] args) {
        var maxProduct = new MaxProduct();
        var maxVal = maxProduct.maxProduct(new int[]{2,8,4,7,11});
        System.out.println(maxVal);
    }
}
