package Array;

//解题思路: https://github.com/youngyangyang04/leetcode-master/blob/master/problems/kamacoder/005E5%8C%BA%E9%97%B4%E5%92%8C.md
//代码提交链接: https://kamacoder.com/problempage.php?pid=1070
import java.util.Scanner;
//思路: 前缀和
public class IntervalSum {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

//    第一行输入为整数数组 Array 的长度 n
    int n = scanner.nextInt();
    int[] vec = new int[n];
    int[] p = new int[n];
    int persum = 0;

//    接下来 n 行，每行一个整数，表示数组的元素。
//    初始化
    for (int i = 0; i < n; i++) {
      vec[i] = scanner.nextInt();
      persum += vec[i];
      p[i] = persum;
    }

//    随后的输入为需要计算总和的区间，直至文件结束。
//    输出每个指定区间内元素的总和。
//    确保在读取整数值之前先检查输入是否有效, 程序会持续读取整数直到用户输入一个非整数值为止。
    while (scanner.hasNextInt()) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();

      int sum;
      if (a == 0) {
        sum = p[b];
      } else {
        sum = p[b] - p[a-1];
      }
    System.out.println(sum);
    }

  }

}
