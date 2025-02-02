package String;

import java.util.Arrays;

//https://leetcode.com/problems/reverse-string/description/
//https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0344.%E5%8F%8D%E8%BD%AC%E5%AD%97%E7%AC%A6%E4%B8%B2.md
public class ReverseString {
  public static void reverseString(char[] s) {

    int l = 0, r = s.length - 1;
    while (l < r) {
      swap(s, l++, r--);
    }
  }

  public static void swap(char[] charArr, int i, int j) {
    char temp = charArr[i];
    charArr[i] = charArr[j];
    charArr[j] = temp;
  }

  public static void main(String[] args) {
    char[] test = {'h','e','l','l','o'};
    reverseString(test);
    System.out.println(test);
  }
}
