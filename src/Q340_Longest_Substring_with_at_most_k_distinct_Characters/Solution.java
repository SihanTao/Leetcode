package Q340_Longest_Substring_with_at_most_k_distinct_Characters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int l = 0, r = 0;
    String result = "";

    if (k == 0) {
      return 0;
    }

    Map<Character, Integer> substring_char_count = new HashMap<>();
    while (r < s.length()) {
      char current = s.charAt(r++);
      substring_char_count.put(current, substring_char_count.getOrDefault(current, 0) + 1);

      if (result.length() < r - l + 1 && substring_char_count.keySet().size() <= k) {
        result = s.substring(l, r);
      } else {
        substring_char_count.put(s.charAt(l), substring_char_count.get(s.charAt(l)) - 1);
        if (substring_char_count.get(s.charAt(l)) == 0) {
          substring_char_count.remove(s.charAt(l));
        }
        l++;
      }
    }
    return result.length();
  }
}
