package HashTable;

public class RansomNote_383 {
  public boolean canConstruct(String ransomNote, String magazine) {
//    1. 创建数组记录字符的数据
    int[] record = new int[26];
//    2.记录ransomNode的字符个数++
//    for (int i = 0; i < ransomNote.length(); i++) {
//      record[ransomNote.charAt(i) - 'a']++;
//    }
//    遍历字符串的第二种写法
    for (char c : ransomNote.toCharArray()) {
      record[c - 'a']++;
    }

//    3.记录magazine的字符个数--
    for (int i = 0; i < magazine.length(); i++) {
      record[magazine.charAt(i) - 'a']--;
    }
// 4.遍历record, 看最后的元素的个数是否都小于等于0, 则为true
//    for (int i = 0; i < 26; i++) {
//      if(record[i] > 0) return false;
//    }

    for (int i : record) {
      if (i >  0) return false;
    }


    return true;
  }
}
