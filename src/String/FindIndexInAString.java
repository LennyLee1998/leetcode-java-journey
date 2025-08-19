package String;

//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
//https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0028.%E5%AE%9E%E7%8E%B0strStr.md
//MP 算法，全称是 Knuth-Morris-Pratt 算法，是一种高效的字符串匹配算法。 它的看家本领就是在一个主串（文本串）中查找是否存在一个模式串（目标串）。
//一个实现 indexOf 功能的题目
//实现了KMP字符串匹配算法的Java类:
//O(M+N)
public class FindIndexInAString {
  public static int strStr(String haystack, String needle) {
    if (needle.isEmpty()) return 0;//如果要查找的子字符串是空的，则直接返回0，表示在主字符串的开始位置就找到了匹配。
    int[] next = new int[needle.length()];//创建一个与needle长度相同的整型数组next，用于存储KMP算法中的"部分匹配表"。然后调用getNext方法计算这个表。
    getNext(next, needle);

    int j = 0;//初始化一个变量j，用于跟踪在needle字符串中的当前匹配位置。
    for (int i = 0; i < haystack.length(); i++) {//开始遍历haystack字符串的每个字符。
      //如果当前needle中的字符与haystack中的字符不匹配，且已经匹配了一些字符（j > 0），则利用部分匹配表回退j的位置，避免重新从头开始匹配。
      while ((j > 0 && needle.charAt(j) != haystack.charAt(i))) j = next[j - 1];
      //如果当前字符匹配成功，则j向前移动一位，继续比较下一个字符。
      if (needle.charAt(j) == haystack.charAt(i)) j++;
      //如果j等于needle的长度，表示完全匹配成功，返回匹配的起始位置（当前位置减去needle的长度再加1）。
      if (j == needle.length()) return i - needle.length() + 1;
    }
    //如果遍历完整个haystack都没有找到匹配，则返回-1表示未找到。
    return -1;
  }

  public static void main(String[] args) {
    String haystack = "ababdabcdabce", needle = "ababaca";
    System.out.println(strStr(haystack, needle));
  }

  //这是一个私有方法，用于计算KMP算法的部分匹配表。
  private static void getNext(int[] next, String needle) {
    //初始化变量j和部分匹配表的第一个值。next[0]始终为0，因为长度为1的前缀没有"真前缀"和"真后缀"。
    //在KMP算法中，部分匹配表（next数组）的每个值表示字符串的前缀和后缀的最长匹配长度。这里的关键概念是"真前缀"和"真后缀"：
    //真前缀：字符串的前缀，但不包括字符串本身。例如，字符串"ABC"的真前缀有："A"和"AB"。
    //真后缀：字符串的后缀，但不包括字符串本身。例如，字符串"ABC"的真后缀有："C"和"BC"。
    int j = 0;
    next[0] = 0;
    //从needle的第二个字符开始遍历。
    for (int i = 1; i < needle.length(); i++) {
      //如果当前字符与前缀的最后一个字符不匹配，则回退j到适当的位置。
      while (j > 0 && needle.charAt(j) != needle.charAt(i))
        j = next[j - 1];
      //如果字符匹配，增加j的值。
      if (needle.charAt(j) == needle.charAt(i)) j++;
      //设置next[i]的值为当前j的值，表示对于needle的前i+1个字符，其最长的相同前缀和后缀的长度。
      next[i] = j;
    }
  }
}

//这段代码实现了KMP（Knuth-Morris-Pratt）字符串匹配算法，用于高效地在文本字符串中查找模式字符串。KMP算法的核心思想是：
//
//预处理模式字符串（needle），生成部分匹配表（next数组）
//利用部分匹配表，在匹配失败时避免不必要的字符比较，从而提高效率
//
//部分匹配表记录了模式字符串中每个位置前的子串中，相同的前缀和后缀的最大长度。当匹配失败时，不需要从头开始匹配，而是利用已经获得的部分信息，跳转到合适的位置继续匹配。
//这使得KMP算法的时间复杂度为O(n+m)，其中n是主字符串的长度，m是模式字符串的长度，相比于暴力匹配的O(n*m)有显著提升。
//不过，代码中有一个错误：在strStr方法中的返回语句应该是return i - needle.length() + 1;，而不是return i = needle.length() + 1;。前者返回匹配的起始位置，后者错误地进行了赋值操作并返回一个常数。
