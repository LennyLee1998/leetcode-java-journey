package Array;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-size-subarray-sum/description/
//https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0209.%E9%95%BF%E5%BA%A6%E6%9C%80%E5%B0%8F%E7%9A%84%E5%AD%90%E6%95%B0%E7%BB%84.md
//A subarray is a contiguous non-empty sequence of elements within an array.
public class MinimumSizeSubarraySum_209 {
  public static void main(String[] args) {
    int[] nums = {1, 4, 4};
    int ans = minSubArrayLen2(4, nums);
//    System.out.println(ans);
  }

  //解题思路: 滑动窗口
  //时间复杂度：O(n)
  //每个元素最多只会被处理两次:第一次是被加入窗口(right指针移动时) 第二次是被移出窗口(left指针移动时)
//空间复杂度：O(1)
  public static int minSubArrayLen2(int target, int[] nums){
    int l = 0;
    int sum = 0;
    int res = Integer.MAX_VALUE;
    //遍历
    for (int r = 0; r < nums.length; r++) {
      sum += nums[r];
      //开始双指针滑动窗口
      while(sum >= target) {
        res = Math.min(res, r - l + 1);
        sum -= nums[l++];
        System.out.println(l);
      }
    }
    return res == Integer.MAX_VALUE ? 0 : res;
  }
//  忽略了会把数丢掉的情况
  public static int minSubArrayLen1(int target, int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      nums[i] = sum;
    }
    System.out.println(Arrays.toString(nums));
    int l = 0, r = nums.length - 1;
    int ans = 0;
    int n = nums.length - 1;
    while (l <= n) {
      int a = r - 1 >= 0 ? nums[--r] : nums[n];
      int numR = nums[n] - a;
      System.out.println(numR);
      if (nums[l++] >= target || numR >= target) {
        ans = l;
        break;
      }
    }
    return ans;
  }


}
