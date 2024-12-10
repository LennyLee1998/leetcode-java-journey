package Array;

public class RemoveElement_27 {
  //返回数组中不等于val的数字个数, 并改变数组, 将val值移动到最后的位置
  //时间复杂度 O(n) 空间复杂度 O(1)
  //简单版的922
  //  https://leetcode.com/problems/sort-array-by-parity-ii/submissions/1434920840/
  public static int removeElement(int[] nums, int val) {
    int l = 0, r = nums.length;
    int k = 0;
    while(l < r) {
      if(nums[l] == val) {
        swap(nums, l, --r);
      } else {
        k++;
        l++;
      }
    }
    return k;
  }
  public static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
