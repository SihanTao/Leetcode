package Q1338;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
  public static int minSetSize(int[] arr) {

    // traverse arr, add element - number of occur to the map
    HashMap<Integer, Integer> element_count_map = new HashMap<>();
    for (int num : arr) {
      element_count_map.put(num, element_count_map.getOrDefault(num, 0) + 1);
    }

    // sort the number of occur from big to small
    List<Integer> list = new ArrayList<>(element_count_map.values());
    list.sort((x, y) -> y - x);

    int result = 0;
    int cnt = 0;
    for (int num : list) {
      result++;
      cnt += num;
      if (cnt * 2 >= arr.length) break;
    }
    return result;
  }
}
