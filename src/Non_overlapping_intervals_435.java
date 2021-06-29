import java.util.Arrays;
import java.util.Comparator;

public class Non_overlapping_intervals_435 {
  public int eraseOverlapIntervals(int[][] intervals) {
    int n = intervals.length;
    if (n == 0 || n == 1) {
      return 0;
    }

    Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

    int removed = 0;
    int prev = intervals[0][1];
    for (int i = 1; i < n; i++) {
      if (intervals[i][0] < prev) removed++;
      else prev = intervals[i][1];
    }

    return removed;
  }
}
