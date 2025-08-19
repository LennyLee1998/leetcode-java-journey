package Array;

import java.util.Arrays;

/**
 * @author Tori
 * @description
 * @create 2025-08-10
 */
//https://leetcode.com/problems/product-of-array-except-self/description/
  // https://claude.ai/chat/e18cf99d-f8e9-428a-ae1b-ce4a7a6fc292
public class ProductOfArrayExceptSelf {
  public static int[] productExceptSelf(int[] nums) {
    int len = nums.length;
    int[] ans = new int[len];
    // 构建左边的乘积
    ans[0] = 1;
    for(int i = 1; i < len; i++) {
      ans[i] = nums[i-1] * ans[i-1];
    }

    // 构建右边的乘积
    int rProduct = 1;
    for (int i = len - 1; i >= 0; i--) {
      ans[i] = ans[i] * rProduct;
      rProduct*= nums[i];
    }
//    int[] leftProduct = new int[len + 1];
//    int[] rightProduct = new int[len + 1];
//    leftProduct[0] = 1;
//    rightProduct[len] = 1;
//    for (int i = 0, j = len; i < len; i++, j--) {
//      leftProduct[i + 1] = nums[i] * leftProduct[i];
//      rightProduct[j- 1] = nums[j-1] * rightProduct[j];
//    }
//    for (int i = 0; i < len; i++) {
//      ans[i] = leftProduct[i] * rightProduct[i+1];
//    }
    return ans;
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4};
    int[] ints = productExceptSelf(arr);
    System.out.println(Arrays.toString(ints));
  }
}
