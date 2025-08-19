package Array;

/**
 * @author Tori
 * @description 当前位置的最大乘积可能来自：当前数字本身，或者前面的最大值乘以当前数字，或者前面的最小值乘以当前数字（如果当前数字是负数）
 * 我们需要同时跟踪最大值和最小值，因为负数可能让最小值变成最大值
 * @create 2025-08-13
 */
// https://leetcode.com/problems/maximum-product-subarray/description/
public class MaximumProductSubarray {
  public static int maxProduct(int[] nums) {

    int ans = nums[0];
    int maxProduct = nums[0];
    int minProduct = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int curNum = nums[i];
      int tempMax = maxProduct;
      maxProduct = Math.max(curNum, Math.max(maxProduct * curNum, minProduct * curNum));
      minProduct = Math.min(curNum, Math.min(minProduct * curNum, tempMax * curNum));
      ans  = Math.max(ans, maxProduct);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] arr = {-1,-2,-9,-6};
    int i = maxProduct(arr);
    System.out.println(i);
  }
}
