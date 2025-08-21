package Array;

/**
 * @author Tori
 * @description 有序 => 双指针
 * @create 2025-08-16
 */
// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
// https://www.bilibili.com/video/BV1bP411c7oJ?spm_id_from=333.788.videopod.sections&vd_source=aa07d55e93797a77dff8c3b3d94fb13c
public class TwoSum2 {
  public int[] twoSum(int[] numbers, int target) {
//    int l = 0, r = numbers.length - 1;
//    int[] ans = new int[2];
//     while (l < r) {
//       int sum = numbers[l] + numbers[r];
//       if (sum == target) {
//         ans[0] = l+1;
//         ans[1] = r+1;
//         break;
//       }
//       if (sum > target) {
//         r--;
//       }else  {
//         l++;
//       }
//     }
//     return ans;
    int left = 0;
    int right = numbers.length - 1;
    // while(left < right) → 编译器认为条件可能为false，循环会结束，结束后需要return
    // while(true) → 编译器认为是无限循环，永远不会跳出，所以后面不需要return
    // 编译器只看语法结构，不做复杂的逻辑推理。 所以你遇到的不是逻辑错误，而是Java编译器的静态分析机制导致的语法要求。两种写法在运行时都是正确的！
    while (true) {
      int s = numbers[left] + numbers[right];
      if (s == target) {
        return new int[]{left + 1, right + 1};
      }
      if (s > target) {
        right--;
      } else {
        left++;
      }
    }

  }
}
