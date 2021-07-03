public class Minimum_Window_substring_76 {
  public String minWindow(String s, String t) {
    boolean[] flag = new boolean[128];
    int[] remain = new int[128];

    // constructing flag and remain
    // flag : true if the character is in string t
    // remain: number of characters needed
    for (int i = 0; i < t.length(); ++i) {
      flag[t.charAt(i)] = true;
      remain[t.charAt(i)]++;
    }

    int res_l = -1, res_r = s.length();
    for (int l = 0, r = 0, cnt = 0 ;r < s.length(); ++r) {
      if (flag[s.charAt(r)]) {
        if (--remain[s.charAt(r)] >= 0)
          cnt++;

        // window substring contains all the characters in t
        while (cnt == t.length()) {
          if (r - l < res_r - res_l) {
            res_l = l;
            res_r = r;
          }

          if (flag[s.charAt(l)] && ++remain[s.charAt(l)] > 0) {
            --cnt;
          }
          ++l;
        }
      }
    }
    return (res_r-res_l+1>s.length()) ? "" : s.substring(res_l, res_r+1);
  }
}
