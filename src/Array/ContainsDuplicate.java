package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Tori
 * @description
 * @create 2025-08-09
 * 思路: 这个好像也是在查一个值到底有没有第二次出现
 * 其实是一个查的过程 和之前两数之和差不多
 * 所以我想到用hashmap 但是这里不需要保存索引
 * 所以我想到了hashset 然后做查询和插入的操作
 * 但是时间和空间的复杂度都是O(n)
 */
public class ContainsDuplicate {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> record = new HashSet<>();
    for (int num : nums) {
      // add()返回false表示已存在
      if (!record.add(num)) {
        return true;
      }
//      if (record.contains(num)) {
//        return true;
//      } else {
//        record.add(num);
//      }
    }
    return false;
  }
}
