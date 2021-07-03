public class ValidPalindromeII_680 {
  public boolean validPalindrome(String s) {
    int l = 0, r = s.length() - 1;
    // delete identical characters from two sides
    while (s.charAt(l) == s.charAt(r) && l < r) {
      l++;
      r--;
    }

    if (r <= l + 1) {
      return true;
    }

    // delete from right
    int tmp_l = l, tmp_r = r - 1;
    while (s.charAt(tmp_l) == s.charAt(tmp_r) && tmp_l < tmp_r) {
      tmp_l++;
      tmp_r--;
    }

    if (tmp_r - tmp_l <= 1 && s.charAt(tmp_l) == s.charAt(tmp_r)) {
      return true;
    }

    // delete from left
    tmp_l = l + 1;
    tmp_r = r;
    while (s.charAt(tmp_l) == s.charAt(tmp_r) && tmp_l < tmp_r) {
      tmp_l++;
      tmp_r--;
    }

    return tmp_r - tmp_l <= 1 && s.charAt(tmp_l) == s.charAt(tmp_r);
  }
}
