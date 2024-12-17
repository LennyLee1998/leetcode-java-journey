package Array;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class ZoneBuy {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] zones = new int[n][m];
    int sum = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        zones[i][j] = sc.nextInt();
        sum += zones[i][j];

      }
    }

    int count = 0;
    int result = Integer.MAX_VALUE;
//    横向
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        count += zones[i][j];

        if (j == m - 1) {
          result = Math.min(result, Math.abs(sum - 2 * count));
        }
      }

    }
    count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        count += zones[j][i];

        if (j == n - 1) {
          result = Math.min(result, Math.abs(sum - 2 * count));
        }
      }
    }

    System.out.println(result);
    sc.close();
  }

}
