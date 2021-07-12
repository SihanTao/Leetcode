package Q436;

import java.util.TreeMap;

public class Solution2 {
  public int[] findRightInterval(int[][] intervals) {
    TreeMap<Integer, Integer> treemap = new TreeMap<>((x, y) -> x - y);
    int n = intervals.length;
    for (int i = 0; i < n; i++) {
      treemap.put(intervals[i][0], i);
    }

    int[] result = new int[n];
    for (int[] interval : intervals) {
      Integer res = treemap.ceilingKey(interval[1]);
      result[treemap.get(interval[0])] = res == null ? -1 : treemap.get(res);
    }
    return result;
  }
}
