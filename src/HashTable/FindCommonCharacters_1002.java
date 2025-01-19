package HashTable;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters_1002 {
  public List<String> commonChars(String[] words) {
    List<String> ans = new ArrayList<>();
    if (words.length == 0) return ans;
//  1. 使用数组记录第一个string的数量
    int[] record = new int[26];
    for (int i = 0; i < words[0].length(); i++) {
      record[words[0].charAt(i) - 'a']++;
    }
//  2. 遍历words, 得到后面每个string的数量
    for (int i = 1; i < words.length; i++) {
      int[] recordOther = new int[26];
      for (int j = 0; j < words[i].length(); j++) {
        recordOther[words[i].charAt(j) - 'a']++;
      }

//  3. 比较两个record 得到里面最小的值
      for (int k = 0; k < 26; k++) {
        record[k] = Math.min(record[k], recordOther[k]);
      }
    }

//  4. 对最后得到的record进行处理,返回list
    for (int i = 0; i < 26; i++) {

      char cur = (char)('a' + i);
      while(record[i] != 0) {
        ans.add(String.valueOf(cur));
        record[i]--;
      }
    }
    return ans;
  }
}
