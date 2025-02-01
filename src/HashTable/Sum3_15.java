package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// O(n^2)
// 三数之和 (3Sum) 的基本结构是：
// 一个外循环固定第一个数
// 然后用双指针(left和right)找剩下的两个数

//https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0015.%E4%B8%89%E6%95%B0%E4%B9%8B%E5%92%8C.md
//https://leetcode.com/problems/3sum/description/
//如果nums[i] + nums[left] + nums[right] > 0 就说明 此时三数之和大了，因为数组是排序后了，所以right下标就应该向左移动，这样才能让三数之和小一些。
//如果 nums[i] + nums[left] + nums[right] < 0 说明 此时 三数之和小了，left 就向右移动，才能让三数之和大一些，直到left与right相遇为止。
//i是外层的一个固定点, 是不动的, 只能由外层的循环进行变化, 一直在动的是left right
public class Sum3_15 {
  //  找出组合,三个数index不一样且相加为0的组合
  // i left right:i从下标0的地方开始，同时定一个下标left 定义在i+1的位置上，定义下标right
  public static List<List<Integer>> threeSum(int[] nums) {
    //1. 创建返回值
    List<List<Integer>> ans = new ArrayList<>();
    //2. 对数组进行排序
    Arrays.sort(nums);
    //3. 遍历nums 取i为当前
    for (int i = 0; i < nums.length; i++) {
      //排序后大于0, 后面的数肯定不能得到=0的组合
      if (nums[i] > 0) return ans;

      //去重
      if (i > 0 && nums[i] == nums[i - 1]) continue;

      //双指针取和
      int left = i + 1, right = nums.length - 1;
      while(left < right) {
        int sum = nums[i] + nums[left] + nums[right];

        if (sum > 0) {
          right--;
        }else if(sum < 0) {
          left++;
        }else {
          ans.add(Arrays.asList(nums[i], nums[left], nums[right]));

          //重复组合去掉
          while(left < right && nums[left] == nums[left+1]) left++;
          while(left < right && nums[right] == nums[right-1]) right--;
          left++;
          right--;
        }
      }
    }
    return ans;
  }
}
