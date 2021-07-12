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

      // 二分搜索
      int left = i;
      int right = n - 1;
      while (left<=right) {
        int mid = left + (right - left) / 2;
        if (intervals[mid][0] > intervals[i][1]) {
          num = hashmap.get(intervals[mid]);
          right = mid - 1;
        } else if (intervals[mid][0] < intervals[i][1]) {
          left = mid + 1;
        } else {
          num = hashmap.get(intervals[mid]);
          break;
        }
      }

      result[hashmap.get(intervals[i])] = num;
    }
    return result;
  }
}

