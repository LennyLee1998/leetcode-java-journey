package HashTable;

import java.util.HashMap;
import java.util.Map;
//是组合
//元组的每个索引可以来自不同数组
//同一个数组的同一个索引可以重复使用
//例如：(0,0,0,0) 和 (1,1,1,1) 都是有效的元组
public class SumII4_454 {
  //  将四数之和问题转化为两数之和问题，通过哈希表降低时间复杂度。
  public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    // 1.  使用map来放num1, num2的和的结果
    Map<Integer, Integer> map = new HashMap<>();
    int res = 0;
    for (int i : nums1) {
      for (int j : nums2) {
        int sum = i + j;
        int value = map.getOrDefault(sum, 0);
        //map.put 方法可以用来 添加新的键值对，也可以 修改已存在的键值对。
        map.put(sum, value + 1);
      }
    }
    System.out.println(map); //4
    // 2. 计算nums3和nums4的和, 用0-sum, 找map中是否有这个值, 如果有res++
    for (int i : nums3) {
      for (int j : nums4) {
        int sub = -i - j;
        res += map.getOrDefault(sub, 0);
//        if (map.containsKey(sub)) {
//          res+= map.get(sub);
//        };
      }
    }
    // 3. 返回res
    return res;
  }

  public static void main(String[] args) {
    int [] nums1 = {1,2}, nums2 = {-2,-1}, nums3 = {-1,2}, nums4 = {0,-2};
    int res = fourSumCount(nums1, nums2, nums3, nums4);
    System.out.println(res);
  }
}
