package Palindrome;

public class Palindrome {
  // convert into string
  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }

    StringBuilder stringBuilder = new StringBuilder(Integer.toString(x));
    int length = stringBuilder.length();
    for (int i = 0; i < length / 2; i++) {
      if (stringBuilder.charAt(i) != stringBuilder.charAt(length - i - 1)) {
        return false;
      }
    }

    return true;
  }

  public boolean isPalindrome_2(int x) {
    if (x < 0 || (x % 10 == 0 && x != 0)) {
      return false;
    }

    int reverted_number = 0;
    while (x > reverted_number) {
      reverted_number = x % 10 + 10 * reverted_number;
      x /= 10;
    }

    return x == reverted_number / 10 || x == reverted_number;
  }
}
