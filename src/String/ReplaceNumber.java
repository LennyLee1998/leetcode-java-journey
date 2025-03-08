package String;

import java.util.Scanner;

//https://kamacoder.com/problempage.php?pid=1064
//https://github.com/youngyangyang04/leetcode-master/blob/master/problems/kamacoder/0054.%E6%9B%BF%E6%8D%A2%E6%95%B0%E5%AD%97.md
public class ReplaceNumber {
  public static void main(String[] args) {
    // 创建Scanner对象读取输入
    Scanner scanner = new Scanner(System.in);
    // 读取一个字符串输入
    String s = scanner.next();
    // 计算替换后的新字符串长度
    int len = s.length();
    for (int i = 0; i < s.length(); i++) {
      // 如果当前字符是数字（0-9）
      // 注意这里的条件判断有错误，应该是 '0' <= s.charAt(i) && s.charAt(i) <= '9'
      if (s.charAt(i) >= 0 && s.charAt(i) <= '9') {
        // 每个数字要被替换成6个字符的"number"，所以长度增加5
        len += 5;
      }
    }

    // 创建一个能容纳新字符串的字符数组
    char[] ret = new char[len];
    // 先把原字符串复制到新数组
    for (int i = 0; i < s.length(); i++) {
      ret[i] = s.charAt(i);
    }

    // 从后向前遍历进行替换
// i指向原字符的位置，j指向新字符串的位置
    for (int i = s.length() - 1, j = len - 1; i >= 0; i--) {
      // 如果当前字符是数字
      if ('0' <= ret[i] && ret[i] <= '9') {
        // 从后往前依次填入"number"的每个字符
        ret[j--] = 'r';
        ret[j--] = 'e';
        ret[j--] = 'b';
        ret[j--] = 'm';
        ret[j--] = 'u';
        ret[j--] = 'n';
      } else {
        // 如果不是数字，直接复制
        ret[j--] = ret[i];
      }
    }

    // 打印结果
    System.out.println(ret);
  }

}
