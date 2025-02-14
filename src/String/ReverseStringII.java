package String;

//https://leetcode.com/problems/reverse-string-ii/description/
//https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0541.%E5%8F%8D%E8%BD%AC%E5%AD%97%E7%AC%A6%E4%B8%B2II.md
public class ReverseStringII {
  public static String reverseStr(String s, int k) {
    //string转成charArray
    char[] ch = s.toCharArray();
    //循环, 对区间进行划分
    for (int i = 0; i < ch.length; i += 2 * k) {
      //对于k / <k的区间使用双指针进行swap
      int start = i;
      int end = Math.min(ch.length - 1,  start + k - 1);
      while (start < end) {
        swap(ch, start++, end--);
      }

    }

    
    return new String(ch);
  }

  public static void swap(char[] arr, int i, int j) {
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    String str = "abcdefg";
    String s = reverseStr(str, 2);
    System.out.println(s);
  }
}

//    我的解法
//    char[] charArr = s.toCharArray();
//    int n = charArr.length;
//    int l = 0, r =  2 * k - 1 ;
//    //满足1-2k
//    while( r < n) {
//      int mid = l + k - 1;
//      while (l < mid) {
//        swap(charArr, l++, mid--);
//      }
//      l = r + 1;
//      r = l + 2 * k -1;
//    }
//
//    if (n - l < k) {
//      r = n - 1;
//      while (l < r) {
//        swap(charArr, l++, r--);
//      }
//    } else {
//      r = l + k -1;
//      while (l < r) {
//        swap(charArr, l++, r--);
//      }
//    }
//    System.out.println(Arrays.toString(charArr));
//    return new String(charArr);