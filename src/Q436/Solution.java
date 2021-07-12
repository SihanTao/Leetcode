package Q436;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int[] findRightInterval(int[][] intervals) {
    Map<int[], Integer> hashmap = new HashMap<>();
    int n = intervals.length;
    int[] result = new int[n];
    for (int i = 0; i<n; i++) {
      hashmap.put(intervals[i], i);
    }

    Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
    for (int i = 0; i < n; i++) {
      int num = -1;
      for (int j = i; j < n; j++) {
        if (intervals[j][0] >= intervals[i][1]) {
          num = hashmap.get(intervals[j]);
          break;
        }
      }
      result[hashmap.get(intervals[i])] = num;
    }
    return result;
  }
}

