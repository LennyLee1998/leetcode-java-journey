package Array;

/**
 * @author Tori
 * @description 既可以看作动态规划，也可以看作贪心算法
 * @create 2025-08-08
 */
// 双指针适用场景：
//这些场景有个共同点：可以通过比较确定指针移动方向
//https://claude.ai/chat/0ab76919-4936-43b6-b2f8-9e511583aa22
public class MaxProfit {
  public static int maxProfit(int[] prices) {
    if (prices == null || prices.length <=1) {
      return 0;
    }
    int maxProfit = 0;
    int min = prices[0];
    // 只是需要确保两个"指针"的时间关系！
    // "探子"，负责侦察最低价格
    // "主力"，负责寻找最佳卖点
    for (int i = 1; i < prices.length; i++) {
      maxProfit = Math.max(maxProfit, prices[i]-min);
      min = Math.min(min, prices[i]);
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    // {3,3,5,0,0,3,1,4}
    // {7,1,5,3,6,4}
    int[] arr = {3,3,5,0,0,3,1,4};
    int i = maxProfit(arr);
    System.out.println(i);
  }

}
