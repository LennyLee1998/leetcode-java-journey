package HashTable;

import java.util.HashSet;
import java.util.Set;
//对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，或者陷入无限循环。如果最终能得到 1，那么这个数就是快乐数。
//当我们遇到了要快速判断一个元素是否出现集合里的时候，就要考虑哈希法了。
//所以这道题目使用哈希法，来判断这个sum是否重复出现，如果重复了就是return false， 否则一直找到sum为1为止。
//判断sum是否重复出现就可以使用unordered_set。
//https://leetcode.com/problems/happy-number/
public class HappyNumber_202 {
  public boolean isHappy(int n) {
    Set<Integer> record = new HashSet<>();  // 用来记录出现过的数字
    while(n != 1 && !record.contains(n)) { // 检查当前数字是否等于 1 && 检查当前数字是否已经在记录中出现过, 确保我们没有陷入循环
      record.add(n); // 记录当前数字
      n = getNextNumber(n); // 计算下一个数字
    }
    return n == 1; // 如果最后数字为1则是快乐数
  }

  private int getNextNumber(int n) {
    int res = 0;
    while(n > 0) {
      int temp = n % 10; // 取最后一位数
      res += temp* temp; // 计算这一位的平方并加到结果中
      n  = n /10; // 去掉最后一位数
    }
    return res;
  }
}
