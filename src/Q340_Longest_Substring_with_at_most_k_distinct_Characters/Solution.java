package Q340_Longest_Substring_with_at_most_k_distinct_Characters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int l = 0, r = 0;
    int maxLength = 0;

    if (k == 0) {
      return 0;
    }

    Map<Character, Integer> substring_char_count = new HashMap<>();
    while (r < s.length()) {
      char current = s.charAt(r++);
      substring_char_count.put(current, substring_char_count.getOrDefault(current, 0) + 1);

      if (maxLength < r - l + 1 && substring_char_count.keySet().size() <= k) {
        maxLength = r - l;
      } else {
        char left = s.charAt(l++);
        int left_num = substring_char_count.get(left);
        if (--left_num == 0) {
          substring_char_count.remove(left);
        } else {
          substring_char_count.put(left, left_num);
        }
      }
    }
    return maxLength;
  }
}
