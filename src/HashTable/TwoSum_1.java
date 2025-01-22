package HashTable;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
  public int[] twoSum(int[] nums, int target) {
//    1. 创建一个hashmap来对出现过的数进行record {num: index}
    Map<Integer, Integer> record = new HashMap<>();
//    2. 遍历nums, 得到target-nums的数后,到hashmap里面查看是否有这个数
    int[] ans = new int[2];
    for (int i = 0; i < nums.length; i++) {
      int curNum = nums[i];
      int sub = target - curNum;
      if (record.containsKey(sub)){
        //    3. 有的话从record里面取出这个数的index
        ans[0] = i;
        ans[1] = record.get(sub);
        break; //找到的话跳出循环
      } else {
        record.put(curNum, i);
      }
    }
//    4. 组成数组返回
    return ans;

  }
}
