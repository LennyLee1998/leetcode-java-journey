package Array;

/**
 * @author Tori
 * @description
 * @create 2025-08-15
 */
public class SearchInRotatedSortedArray {
  public static int search(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    while (l <= r) {
      int mid = l + (r - l) / 2;

      if (nums[mid] == target) {
        return mid;
      }
      // 右边是单调性的
      if (nums[mid] < nums[r]) {
        if (target > nums[mid] && target <= nums[r]) {
          l = mid + 1;
        } else {
          r = mid;
        }
      } else {
        if (target >= nums[l] && target < nums[mid]) {
          r = mid - 1;
        } else {
          l = mid + 1;
        }

      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = {5, 1, 3};
    int search = search(arr, 5);
    System.out.println(search);
  }
}
