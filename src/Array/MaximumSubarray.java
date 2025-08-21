package Array;

/**
 * @author Tori
 * @description 对于每个位置，我们需要决定是继续之前的子数组还是从当前位置重新开始
 * 你思路的正确部分
 * ✅ 累积和的概念 - 用sum跟踪当前子数组和
 * ✅ 全局最大值 - 用ans保存最大子数组和
 * ✅ 重置机制 - 意识到需要在某些情况下重置
 * 问题在于重置条件的判断逻辑和变量更新的顺序。修正后就是标准的Kadane算法了！
 * 动态规划
 * @create 2025-08-12
 */
public class MaximumSubarray {
  public static int maxSubArray(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    // 全局最大和
    int maxSum = nums[0];
    // 当前子数组和
    int currentSum = nums[0];

    for (int i = 1; i < nums.length; i++) {
      // 关键决策：是否要前面的子数组, 继续之前的子数组还是从当前位置重新开始
      currentSum = Math.max(nums[i], currentSum + nums[i]);
      // 更新全局最大值
      maxSum = Math.max(maxSum, currentSum);

    }
    return maxSum;
  }

  public static void main(String[] args) {
    int[] arr = {8,-19,5,-4,20};
    int i = maxSubArray(arr);
    System.out.println(i);
  }

}
