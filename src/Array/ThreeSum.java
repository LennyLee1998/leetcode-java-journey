package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tori
 * @description i<j < k 时间复杂度 O ( n ² ) 空间复杂度 ： O ( 1 )
    * @ create 2 0 2 5 - 0 8 - 1 6
 */
public class ThreeSum {
  public static List<List<Integer>> threeSum(int[] nums) {
    // 1. 排序
    Arrays.sort(nums);
    System.out.println(Arrays.toString(nums));
    List<List<Integer>> ans = new ArrayList<>();
    int len = nums.length;
    //i < j < k
    // 2. 遍历 + 双指针
    for (int i = 0; i < len - 2; i++) {
      int curNum = nums[i];
      //去重
      if (i > 0 && curNum == nums[i - 1]) {
        continue;
      }

      int j = i + 1;
      int k = len - 1;
      // 4. 剪枝 (三数之和
      //当前三数之和的最小值
      if (curNum + nums[i+1] + nums[i+2] >0) {
        break;
      }
      //三数之和的最大值
      if (curNum + nums[len - 1] +nums[len -2] < 0) {
        continue;
      }
//      if (curNum > 0 || nums[k] < 0) {
//        break;
//      }


      while (j < k) {
        int sum = curNum + nums[j] + nums[k];
        if (sum == 0) {
          ans.add(Arrays.asList(curNum, nums[j], nums[k]));
          // 3. 去重
          while (j < k && nums[j+1] == nums[j]) {
            j++;
          }
          //去重
          while (j < k && nums[k - 1] == nums[k]) {
            k--;
          }
          j++;
          k--;
        } else if (sum > 0) {
          k--;
        } else {
          j++;
        }
      }

    }
    return ans;
  }

  public static void main(String[] args) {
    int[] arr = {-1,0,1,2,-1,-4};
    List<List<Integer>> lists = threeSum(arr);
    System.out.println(lists);
  }
}
