import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Assign_Cookies_455 {

  /**
   *
   * @param g : g[i] is the greed factor for ith children
   * @param s : s[j] is the size of jth cookie
   * @return Max content children
   */
  public int findContentChildren(int[] g, int[] s) {
    int content_children = 0;

    List<Integer> greed_factor = Arrays.stream(g).boxed().sorted().collect(Collectors.toList());
    List<Integer> size = Arrays.stream(s).boxed().sorted().collect(Collectors.toList());

    int children = greed_factor.size();
    int cookies = size.size();
    for (int i = 0, j = 0; i < children && j < cookies; i++, j++) {
      for (; j < cookies && greed_factor.get(i) > size.get(j); j++);
      if (j < cookies) {
        content_children++;
      }
    }

    return content_children;
  }

  public int findContentChildren_solution(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int numOfChildren = g.length, numOfCookies = s.length;
    int count = 0;
    for (int i = 0, j = 0; i < numOfChildren && j < numOfCookies; i++, j++) {
      while (j < numOfCookies && g[i] > s[j]) {
        j++;
      }
      if (j < numOfCookies) {
        count++;
      }
    }
    return count;
  }

  public int findContentChildren_solution2(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int numOfChildren = g.length, numOfCookies = s.length;
    int count = 0, cookie = 0;
    while(count < numOfChildren && cookie < numOfCookies) {
      if (g[count] <= s[cookie]) count++;
      cookie++;
    }
    return count;
  }
}
