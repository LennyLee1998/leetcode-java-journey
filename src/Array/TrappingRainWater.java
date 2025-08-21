package Array;

import java.util.Arrays;

/**
 * @author Tori
 * @description 动态规划
 * 想象一个高度序列 height[i]，每个柱子能装的水量取决于它两边的“墙”高度。若两边墙都很高，中间就能接到水；若一边低一边高，就水会往较高的一边流走。
 * 关键点在于：在某个位置 i，水量取决于左边能看到的最高墙和右边能看到的最高墙中的较低者，即 min(左最大、右最大) 与 height[i] 的差。
 * @create 2025-08-19
 */
public class TrappingRainWater {
  public static int trap(int[] height) {
    // 优化 空间复杂度为O(n)
    // "接雨水"问题的核心是：对于每个位置，能接到的雨水量 = min(左边最大值, 右边最大值) - 当前高度
    // 关键洞察：我们不需要知道确切的 leftMax 和 rightMax，只需要知道哪个更小！
    //这种"需要从两个方向获取信息"的模式是双指针的典型应用场景
//    本质：区间最值查询 + 贪心决策
    int l = 0, r = height.length - 1;
    int ans = 0;
    int preMax = 0, sufMax = 0;
    while (l < r) {
      preMax = Math.max(preMax, height[l]);
      sufMax = Math.max(sufMax, height[r]);
      if (preMax > sufMax) {
        ans += sufMax - height[r--];
      }else {
        ans += preMax - height[l++];
      }
    }
    return ans;
  }

  // 前缀DP 类似ProductOfArrayExceptSelf 的思路
//  public static int trap1(int[] height) {
//    int len = height.length;
//    int[] preMax = new int[len];
//    int[] sufMax = new int[len];
//    int ans = 0;
//
//    // 前缀最大值数组
//    preMax[0] = height[0];
//    for (int i = 1; i < height.length; i++) {
//      preMax[i] = Math.max(height[i], preMax[i - 1]);
//    }
//
//    // 后缀最大值数组
//    sufMax[len - 1] = height[len - 1];
//    for (int i = len - 2; i >= 0; i--) {
//      sufMax[i] = Math.max(height[i], sufMax[i + 1]);
//    }
//
//    //累计和
//    for (int i = 0; i < len; i++) {
//      ans += Math.min(preMax[i], sufMax[i]) - height[i];
//    }
//    return ans;
//  }

  public static void main(String[] args) {
    int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int trap = trap(arr);
    System.out.println(trap);
  }
}
