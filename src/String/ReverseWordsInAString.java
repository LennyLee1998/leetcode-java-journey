package String;

import java.util.Arrays;

public class ReverseWordsInAString {

  public static String reverseWords(String s) {
    //1. 将字符串转成数组
    String[] strArr = s.split(" ");
    System.out.println(Arrays.toString(strArr));
    //2.reverse数组
    int l = 0, r = strArr.length -1;
    while (l < r) {
      swap(strArr, l++, r--);
    }
    StringBuilder stringBuilder = new StringBuilder();
    for (String string : strArr) {
      if (!"".equals(string)) {
        stringBuilder.append(string).append(" ");
      }
    }
    return stringBuilder.toString().trim();
  }

  public static void main(String[] args) {
    String s = "a good   example";
    System.out.println(
        reverseWords(s));  }

  private static void swap(String[] s1, int i, int j) {
    String temp = s1[i];
    s1[i] = s1[j];
    s1[j] = temp;
  }
}
