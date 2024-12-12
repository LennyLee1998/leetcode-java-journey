package Array;
//https://leetcode.com/problems/squares-of-a-sorted-array/description/
public class SquaresOfASortedArray_977 {
  public static int[] sortedSquares(int[] nums) {
//   由于单调性,能确定最大值的位置, 要么在最左边要么在最右边
    int l = 0, r = nums.length - 1;
    int[] res = new int[nums.length];
    int j = nums.length - 1;
    while (l <= r) {
      if (nums[l] * nums[l] > nums[r] * nums[r]) {
        res[j--] = nums[l] * nums[l++];
      }else {
        res[j--] = nums[r] * nums[r--];
      }
    }
    return res;
  }

}

