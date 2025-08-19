package Array;

/**
 * @author Tori
 * @description 这里双指针的规律是什么
 * 移动矮的指针才有可能获得更大面积
 * 移动高的指针：距离减少，高度不会增加（因为还是受矮的限制）
 * 移动矮的指针：距离减少，但高度可能增加
 * 这个决策规律保证了我们不会错过最优解，虽然数组本身确实没规律。
 * @create 2025-08-19
 */
//https://leetcode.com/problems/container-with-most-water/submissions/1740638221/
public class MaxArea {
  public int maxArea(int[] height) {
    int l = 0, r = height.length - 1;
    int maxArea = 0;
    while (l < r) {
      int area = Math.min(height[l], height[r]) * (r - l);
      maxArea = Math.max(area, maxArea);
      if (height[l] < height[r]) {
        l++;
      } else {
        r--;
      }
    }
    return maxArea;
  }
}
