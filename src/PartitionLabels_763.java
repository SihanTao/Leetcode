import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels_763 {
  public List<Integer> partitionLabels_s1(String s) {
    Map<Character, List<Integer>> map = new HashMap<>();
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char current = s.charAt(i);
      if (!map.containsKey(current)){
        List<Integer> first_last_appear = new ArrayList<>();
        first_last_appear.add(i);
        first_last_appear.add(s.lastIndexOf(current));
        map.put(s.charAt(i), first_last_appear);
      }
    }

    List<Integer> result = new ArrayList<>();
    char current = s.charAt(0);
    int start, end;
    start = map.get(current).get(0);
    end = map.get(current).get(1);
    for (int i = 1; i < n; i++) {
      current = s.charAt(i);
      int new_start = map.get(current).get(0);
      int new_end = map.get(current).get(1);
      if (new_start < end) {
        end = Math.max(end, new_end);
      } else {
        result.add(end - start + 1);
        start = new_start;
        end = new_end;
      }
    }
    result.add(end - start + 1);

    return result;
  }

  public List<Integer> partitionLabels(String s) {
    int[] last = new int[26];
    int length = s.length();
    for (int i = 0; i < length; i++) {
      last[s.charAt(i) - 'a'] = i;
    }
    List<Integer> partition = new ArrayList<>();
    int start = 0, end = 0;
    for (int i = 0; i < length; i++) {
      end = Math.max(end, last[s.charAt(i) - 'a']);
      if (i == end) {
        partition.add(end - start + 1);
        start = end + 1;
      }
    }
    return partition;
  }
}
