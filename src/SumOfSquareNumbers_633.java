import static java.lang.Math.sqrt;

public class SumOfSquareNumbers_633 {
  public boolean judgeSquareSum(int c) {
    for (int i = 0, j = (int) sqrt(c); i < j;) {
      if (i*i + j*j == c) {
        return true;
      } else if (i*i + j*j > c) {
        j--;
      } else {
        i++;
      }
    }
    return false;
  }
}
