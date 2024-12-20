package Array;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/spiral-matrix/
//https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0054.%E8%9E%BA%E6%97%8B%E7%9F%A9%E9%98%B5.md
public class SpiralOrder_54 {
  public static void main(String[] args) {
    int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//    int[][] arr = {{7},{9},{6}};
    List<Integer> list = spiralOrder(arr);
    System.out.println(list);
  }

  public static List<Integer> spiralOrder(int[][] matrix) {
    int i, j; //i 横向 j竖向
    int h = matrix.length; //高度
    int w = matrix[0].length; //宽度
    int start = 0;
    int loop = 1;
    List<Integer> list = new ArrayList<>();
    while (h / 2 >= loop && w / 2 >= loop) {
      System.out.println("aa");
      for (i = start; i < w - loop; i++) {
        list.add(matrix[start][i]);
      }
      for (j = start; j < h - loop; j++) {
        list.add(matrix[j][i]);
      }
      for (; i > start; i--) {
        list.add(matrix[j][i]);
      }
      for (; j > start; j--) {
        list.add(matrix[j][i]);
      }
      loop++;
      start++;
    }
//    二者不能兼有
    //h只有1
    if (h % 2 == 1 && h / 2 == start) {
      for (i = start; i <= w - loop; i++) {
        System.out.println(matrix[start][i]);
        list.add(matrix[start][i]);
      }
//    w只有1
    } else if (w % 2 == 1 && w / 2 == start) {
      for (j = start; j <= h - loop; j++) {
        list.add(matrix[j][start]);
      }
    }
    return list;
  }
}
