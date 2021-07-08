package Q69;

public class Solution {
  public int mySqrt(int x) {
    if (x == 0) {
      return 0;
    }
    int left = 1;
    int right = x;
    int mid, sqrt;
    while (left <= right) {
      mid = left + (right - left) / 2;
      sqrt = x / mid;
      if (mid > sqrt) {
        right = mid - 1;
      } else if (mid < sqrt) {
        left = mid + 1;
      } else {
        return mid;
      }
    }
    return right;
  }
}

