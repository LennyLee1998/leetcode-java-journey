package HashTable;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays_349 {
  public int[] intersection(int[] nums1, int[] nums2) {
    // 1. 先对nums1去重得到set1
    Set<Integer> set1 = new HashSet<>();
    for (int i : nums1) {
      set1.add(i);
    }
    // 2. 对nums2去重得到,并得到两者的交集
    Set<Integer> intersectionSet = new HashSet<>();
    for (int i : nums2) {
      if(set1.contains(i)) {
        intersectionSet.add(i);
      }
    }
    // 3. 把set转成int
    int[] ans = new int[intersectionSet.size()];
    int index = 0;
    for (Integer i : intersectionSet) {
      ans[index++] = i;
    }
    return ans;
  }
}
