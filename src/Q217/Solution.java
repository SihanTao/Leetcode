package Q217;

import java.util.ArrayList;
import java.util.List;

/**
 * The solution ran out out time.
 * contains method is O(n)
 * Overall Complexity is O(n^2)
 */
public class Solution {
  public boolean containsDuplicate(int[] nums) {
    List<Integer> seen = new ArrayList<>();
    for (int num : nums) {
      if (!seen.contains(num)) {
        seen.add(num);
      } else {
        return true;
      }
    }
    return false;
  }
}
