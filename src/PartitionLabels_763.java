import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels_763 {
  public List<Integer> partitionLabels(String s) {
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
      if (map.get(current).get(0) < end) {
        end = Math.max(end, map.get(current).get(1));
      } else {
        result.add(end - start + 1);
        start = map.get(current).get(0);
        end = map.get(current).get(1);
      }
    }
    result.add(end - start + 1);

    return result;
  }
}
