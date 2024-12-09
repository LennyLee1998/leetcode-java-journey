package Array;
//https://leetcode.com/problems/binary-search/
//二分查找
//runtime complexity O(log n)
public class Binary_Search_704 {
  public static int search(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    while (l <= r) {
      int mid = l + (r-l)/2;
      if(nums[mid]  == target) {
        return mid;
      } else if (nums[mid] > target) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return -1;
  }

}
