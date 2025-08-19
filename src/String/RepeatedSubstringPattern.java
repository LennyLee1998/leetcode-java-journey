package String;

//https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0459.%E9%87%8D%E5%A4%8D%E7%9A%84%E5%AD%90%E5%AD%97%E7%AC%A6%E4%B8%B2.md
//https://leetcode.com/problems/repeated-substring-pattern/
public class RepeatedSubstringPattern {

  //这段代码使用了KMP算法的next数组概念来高效判断字符串是否由重复子串组成。其核心思想是：如果字符串S由重复子串P构成，那么字符串的最长相同前后缀长度与字符串本身长度之间存在特定关系。具体来说，如果字符串长度len能被(len - next[len])整除，且next[len]大于0，则表明该字符串可以由长度为(len - next[len])的子串重复构成。这种方法避免了暴力枚举所有可能子串的低效做法，时间复杂度为O(n)，空间复杂度为O(n)，其中n是字符串的长度。
  // 定义一个公共静态方法，接收一个字符串参数，返回布尔值，用于判断字符串是否由重复子串组成。
  public static boolean repeatedSubstringPattern(String s) {
    // 检查输入字符串是否为空，如果是空字符串则返回false（空字符串不能由重复子串构成）。
    if (s.isEmpty()) {
      return false;
    }

    // 获取字符串的长度并存储在变量len中。
    int len = s.length();
    s = " " + s;
    // 在字符串前添加一个空格字符，这样使字符串的实际索引从1开始，便于实现KMP算法。
    char[] charArray = s.toCharArray();
    // 将修改后的字符串转换为字符数组，便于按索引访问。
    int[] next = new int[len + 1];

    // 创建一个长度为len+1的整型数组next，用于存储KMP算法中的"部分匹配表"值。
    for (int i = 2, j = 0; i <= len; i++) {
      //从索引2开始遍历字符数组（因为已经在字符串前添加了空格，实际遍历原字符串的索引从1开始），j用于记录当前的最长相同前后缀长度。
//      当前字符不匹配时，回溯j的值，这是KMP算法的核心部分，用于跳过不必要的比较。
      while (j > 0 && charArray[i] != charArray[j + 1]) {
        j = next[j];
      }

//      如果当前字符匹配，则最长相同前后缀长度加1。
      if (charArray[i] == charArray[j + 1]) {
        j++;
      }
//      将计算得到的最长相同前后缀长度存入next数组的对应位置。
      next[i] = j;
    }

//    检查条件：
//    next[len] > 0：字符串的最长相同前后缀长度必须大于0
//    len % (len - next[len]) == 0：字符串长度必须能被(len - next[len])整除
//    如果满足这两个条件，则返回true，表示该字符串可以由重复子串构成。
    if (next[len] > 0 && len % (len - next[len]) == 0) {
      return true;
    }

    //如果条件不满足，返回false。
    return false;
  }

  public static void main(String[] args) {
    String s = "abcabcabcabc";
    boolean isLock = repeatedSubstringPattern(s);
    System.out.println(isLock);
  }
}
