import java.util.Arrays;

public class Candy_135 {
  public int candy_v1(int[] ratings) {
    int length = ratings.length;
    int[] result = new int[length];

    // Initialize to 1
    for (int i = 0; i < length; i++) {
      result[i] = 1;
    }

    // traverse from left to right
    for (int i = 1; i < length; i++) {
      if (ratings[i] > ratings[i - 1]) {
        result[i] = result[i - 1] + 1;
      }
    }

    // traverse from right to left
    for (int i = length - 2; i > -1; i--) {
      if (ratings[i] > ratings[i + 1]) {
        if (result[i] < result[i + 1] + 1) result[i] = result[i + 1] + 1;
      }
    }

    return Arrays.stream(result).sum();
  }
  public int candy(int[] ratings) {
    int length = ratings.length;
    if (length == 1) {
      return 1;
    }

    int[] result = new int[length];

    // traverse from left to right
    for (int i = 0; i < length; i++) {
      if (i > 0 && ratings[i] > ratings[i - 1]) {
        result[i] = result[i - 1] + 1;
      } else {
        result[i] = 1;
      }
    }

    int sum = result[length - 1];
    // traverse from right to left
    for (int i = length - 2; i > -1; i--) {
      if (ratings[i] > ratings[i + 1]) {
        if (result[i] < (result[i + 1] + 1)) {
          result[i] = result[i + 1] + 1;
        }
      }
      sum += result[i];
    }

    return sum;
  }

}
