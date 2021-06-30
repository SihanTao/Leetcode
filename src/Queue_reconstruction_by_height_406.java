import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Queue_reconstruction_by_height_406 {

  /**
   * First sort the people: increasing ki, decreasing height
   * Then insert the element
   * @param people : to be reconstructed
   * @return reconstructed queue
   */
  public int[][] reconstructQueue(int[][] people) {
    int n = people.length;
    if (n == 1) {
      return people;
    }

    Arrays.sort(
        people,
        (o1, o2) -> (o1[1] - o2[1] == 0) ? Integer.compare(o2[0], o1[0]) : (o1[1] - o2[1]));

    List<int[]> res = new ArrayList<>();
    res.add(people[0]);
    for (int i = 1; i < n; i++) {
      int pos = 0;
      int p = 0;
      while (people[i][1] != p) {
        if (people[i][0] <= res.get(pos)[0]) {
          p++;
        }
        pos++;
      }
      res.add(pos, people[i]);
    }

    return res.toArray(new int[people.length][]);
  }

  public int[][] reconstructQueue_better(int[][] people) {
    Arrays.sort(people, (person1, person2) -> {
      if (person1[0] != person2[0]) {
        return person2[0] - person1[0];
      } else {
        return person1[1] - person2[1];
      }
    });
    List<int[]> ans = new ArrayList<>();
    for (int[] person : people) {
      ans.add(person[1], person);
    }
    return ans.toArray(new int[ans.size()][]);
  }
}
