package Array;

/**
 * @author Tori
 * @description https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * @create 2025-08-14
 * "旋转数组的本质特征是什么？"
 *
 * 只有一个分界点
 * 分界点左右有明确的大小关系
 * 利用这个关系做二分
 * 少考虑特殊情况，多寻找统一规律
 * 抓住问题本质：旋转数组 = 找分界点
 * 相信二分的力量：好的二分只需要一个判断条件
 */
public class FindMinimumInRotatedSortedArray {
  public static int findMin(int[] nums) {
//    if (nums.length == 1) {
//      return nums[0];
//    }
    int l = 0, r = nums.length - 1;
//    int ans = nums[l];
//
    while (l < r) {
//      int lNum = nums[l];
//      int rNum = nums[r];
//      // 已经是单调性的情况
//      if (lNum <rNum) {
//        return lNum;
//      }
//      //最左边是不是最大值
//      if (lNum > rNum && lNum > nums[l+1]) {
//        return nums[l+1];
//      }
//
      int mid = l + (r-l) / 2;
      if (nums[mid] > nums[r]) {
        l = mid +1;
      } else {
        r = mid;
      }
//      if (nums[mid] < rNum && nums[mid] > nums[mid-1]) {
//        r = mid;
//      } else {
//        l = mid;
//      }
//    }
      }
    return nums[l];

    }

  public static void main(String[] args) {
    int[] arr = {4,5,1,2,3};
    int min = findMin(arr);
    System.out.println(min);
  }

}
