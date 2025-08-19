package String;

//https://leetcode.com/problems/reverse-words-in-a-string/description/
//151
public class ReverseWordsInAString {

  //  这个算法的总体思路是：
//  从字符串的末尾开始遍历
//   跳过尾部的空格
//  找到每个单词的边界
//  按照反向顺序将单词复制到新数组中
//  返回处理后的结果
// 1 <= s.length <= 104
  public static String reverseWords(String s) {
    // 1. 转成arr
    char[] chars = s.toCharArray();
    //2. 创建一个新的arr接收
    char[] reversedArr = new char[chars.length + 1];
    //3.双指针 + 一个记录reversedArr的指针, 开始reverse
    int i = chars.length - 1;
    int reversedArrPos = 0;
    while (i >= 0) {
      //去掉空格
      while (i >= 0 && chars[i] == ' ') i--;
      int right = i; //取右边界
      while (i >= 0 && chars[i] != ' ') i--; //取完整单词
      for (int j = i + 1; j <= right; j++) {
        reversedArr[reversedArrPos++] = chars[j];
        if (j == right) {//加' '
          reversedArr[reversedArrPos++] = ' ';
        }
      }
    }
    //edge case: 传入参数为" "
    if (reversedArrPos == 0) {
      return "";
    } else {
      return new String(reversedArr, 0, reversedArrPos - 1);
    }
  }

  public static void main(String[] args) {
    String s1 = " ";
    System.out.println(reverseWords(s1));
  }
}
//算法关键点
//从后向前处理：这种方式可以直接按照目标顺序构建结果
//处理多余空格：代码可以处理输入中的多个连续空格
//原地复制：通过字符数组操作，避免了频繁的字符串拼接
//边界处理：注意处理了字符串为空或全是空格的情况
//这是一个时间复杂度为O(n)、空间复杂度为O(n)的算法，其中n是字符串的长度。
