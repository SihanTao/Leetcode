public class Reverse_Integer {
  public static int reverse(int x) {
    try {
      char[] integer_string = Integer.toString(x).toCharArray();
      StringBuilder sb = new StringBuilder();
      for (int i = integer_string.length - 1; i >= 0; i--) {
        if (integer_string[i] != '-') {
          sb.append(integer_string[i]);
        }
      }
      if (integer_string[0] == '-') {
        sb.insert(0, "-");
      }
      return Integer.parseInt(sb.toString());
    } catch (NumberFormatException e) {
      return 0;
    }
  }

  public static void main(String[] args) {
    int res = reverse_math(990);
    System.out.println(res);
    //    String str = new String("-7463847412");
    //    int i = Integer.parseInt(str);
    //    System.out.println(i);
  }

  //  作者：wang_ni_ma
  //
  // 链接：https://leetcode-cn.com/problems/reverse-integer/solution/tu-jie-7-zheng-shu-fan-zhuan-by-wang_ni_ma/
  //  来源：力扣（LeetCode）
  //  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

  public static int reverse_math(int x) {
    int res = 0;
    while (x != 0) {
      // 每次取末尾数字
      int tmp = x % 10;
      // 判断是否 大于 最大32位整数
      if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && tmp > 7)) {
        return 0;
      }
      // 判断是否 小于 最小32位整数
      if (res < -214748364 || (res == -214748364 && tmp < -8)) {
        return 0;
      }
      res = res * 10 + tmp;
      x /= 10;
    }
    return res;
  }
}
