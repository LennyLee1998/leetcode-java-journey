package Array;

import java.sql.Array;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum/
 * 在if语句这里已经可以判断是否有对应的num了 如果没有就直接put 相同的会覆盖 只需要一个即可
 * @author Tori
 * @description
 * @create 2025-08-07
 * hashMap 的优势：
 * 查找 O(1)：record.containsKey(sub)
 * 插入 O(1)：record.put(cur, i)
 * 获取 O(1)：record.get(sub)
 */
public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    // HashMap的覆盖特性在这里反而是个优势，因为题目保证有唯一解，我们只要能找到就行，不需要维护重复值的所有位置。
    // [6, 6, 4, 5]
    // {0:6, 1: 4, 2:4, 3:5} 11 => {6:1, 4:2, 5:2}
    //  HashMap存的是 值:索引 的映射
    //  相同值会被覆盖，只保留最后一次出现的索引
    int[] ans = new int[2];
    HashMap<Integer, Integer> record = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int cur = nums[i];
      int sub = target - cur;

      if (record.containsKey(sub)) {
        ans[0] = i;
        ans[1] = record.get(sub);
      } else {
        record.put(cur, i);
      }
    }
    return ans;


//    HashMap<Integer, Integer> twoSumMap = new HashMap<>();
//    for (int i = 0; i < nums.length; i++) {
//      int subNum = target - nums[i];
//      if (twoSumMap.containsKey(subNum)) {
//        return new int[]{i, twoSumMap.get(subNum)};
//      } else {
//        twoSumMap.put(nums[i], i);
//      }
//    }
//    return nums;
  }
}
