package HashTable;

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
