package HashTable;
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//示例 1: 输入: s = "anagram", t = "nagaram" 输出: true
//示例 2: 输入: s = "rat", t = "car" 输出: false
//说明: 你可以假设字符串只包含小写字母。
//https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0242.%E6%9C%89%E6%95%88%E7%9A%84%E5%AD%97%E6%AF%8D%E5%BC%82%E4%BD%8D%E8%AF%8D.md
public class ValidAnagram_242 {
  public boolean isAnagram(String s, String t) {

//    1.创建一个26长度的数组来记录两个字符串
    int[] record = new int[26];

//    记录第一个字符串中各个字符的数量, 并++
    for (int i = 0; i < s.length(); i++) {
      record[s.charAt(i) - 'a']++;
    }
//记录第二个字符串中各个字符的数量, 并--
    for (int i = 0; i < t.length(); i++) {
      record[t.charAt(i) -'a']--;
    }

//    判断最后record里面是否都是0
    for (int i = 0; i < record.length; i++) {
      if (record[i] != 0) return false;
    }
    return true;
  }
}
