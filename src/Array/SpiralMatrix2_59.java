package Array;

import java.util.Arrays;

public class SpiralMatrix2_59 {
  public static void main(String[] args) {
    int[][] a = generateMatrix(5);
    for (int[] ints : a) {
      System.out.println(Arrays.toString(ints));
    }
  }
  public static int[][] generateMatrix(int n) {
      int[][] nums = new int[n][n];
      int startX = 0, startY = 0; //每一圈的起始点
      int offset = 1; //需要控制每一条边遍历的长度，每次循环右边界收缩一位
      int count = 1; // 用来给矩阵中每一个空格赋值
      int loop = 1;  //每个圈循环几次，例如n为奇数3，那么loop = 1 只是循环一圈，矩阵中间的值需要单独处理
      int i, j;
//当 n = 4 (偶数) 时：
//    第一圈：      第二圈：
//    1  2  3  4    ----
//    12 X  X  5    13 14
//    11 X  X  6    16 15
//    10 9  8  7    ----
//当 n = 3 (奇数) 时
//    n/2 = 2 圈，刚好完成填充
//    第一圈：      中心点：
//    1  2  3       ----
//    8  X  4       9
//    7  6  5       ----
//
//    n/2 = 1 圈，还需额外处理中心点
//    当 n = 5 (奇数) 时：
//    第一圈：      第二圈：      中心点：
//1  2  3  4  5    ----         ----
//16 X  X  X  6    17 18 19     25
//15 X  X  X  7    24 X  20     ----
//14 X  X  X  8    23 22 21
//13 12 11 10 9    ----
//n/2 = 2 圈，还需额外处理中心点
//    原因分析：
//每一圈占用矩阵的"边缘" 2 个单位宽度（上下各1，左右各1）
//对于 n*n 的矩阵：
//每做完一圈，矩阵的可用范围就减少2
//所以需要的圈数就是 n/2（向下取整）
//特殊情况：
//当 n 为奇数时，处理完 n/2 圈后，中心会剩下一个点
//这就是为什么代码最后要判断 n % 2 == 1
      while (loop <= n /2) {
        // 顶部
        // 左闭右开，所以判断循环结束时， j 不能等于 n - offset
        for (j = startY; j < n - offset; j++) {
          nums[startX][j] = count++;
        }

        // 右列
        // 左闭右开，所以判断循环结束时， i 不能等于 n - offset
        for (i = startX; i < n - offset; i++) {
          nums[i][j] = count++;
        }

        // 底部
        // 左闭右开，所以判断循环结束时， j != startY
        for (; j > startY; j--) {
          nums[i][j] = count++;
        }

        // 左列
        // 左闭右开，所以判断循环结束时， i != startX
        for (; i > startX; i--) {
          nums[i][j] = count++;
        }
        startX++;
        startY++;
        offset++;
        loop++;
      }
    if (n % 2 == 1) { // n 为奇数时，单独处理矩阵中心的值
      nums[startX][startY] = count;
    }
    return nums;
  }
}
