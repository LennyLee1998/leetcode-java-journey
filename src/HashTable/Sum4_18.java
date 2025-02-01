package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// O(n^3)
// 第一层循环固定第一个数
// 第二层循环固定第二个数
// 然后用双指针(left和right)找剩下的两个数
// sum3和sum4区别就是会多加一层循环
//https://leetcode.com/problems/4sum/description/
//https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0018.%E5%9B%9B%E6%95%B0%E4%B9%8B%E5%92%8C.md
public class Sum4_18 {
  public static List<List<Integer>> fourSum(int[] nums, int target) {
    //使用双指针, 先排序
    Arrays.sort(nums);

    List<List<Integer>> res = new ArrayList<>();

    // 固定第一个数
    for (int i = 0; i < nums.length; i++) {
      // 当前值>target && >0跳出循环 [-4,-3,-2,-1] target=-8, 使得在负数list下剪枝没问题
      if (nums[i] > target && nums[i] > 0) {
        break;
      }

      //去重
      if (i > 0 && nums[i] == nums[i - 1]) continue;

      // 固定第二个数
      for (int j = i + 1; j < nums.length; j++) {
        //剪枝
        if (nums[i] + nums[j] > target && nums[i] + nums[j] > 0) {
          break;
        }

        //去重
        if (j > i + 1 && nums[j] == nums[j - 1]) continue;

        //双指针找剩下的两个数
        int l = j + 1, r = nums.length - 1;
        while (r > l) {
          int sum = nums[i] + nums[j] + nums[l] + nums[r];

          if (sum > target) {
            r--;
          } else if (sum < target) {
            l++;
          } else {
            res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
            while (r > l && nums[l] == nums[l + 1]) l++;
            while (r > l && nums[r] == nums[r - 1]) r--;
            l++;
            r--;
          }
        }
      }


    }
    return res;
  }

}
