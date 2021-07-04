import java.util.Comparator;
import java.util.List;

public class LongestWord_524 {
  public String findLongestWord(String s, List<String> dictionary) {
    int result = -1;

    for (int i = 0, maxLength = 0; i < dictionary.size(); ++i) {
      String current = dictionary.get(i);
      int current_length = current.length();
      if (subsequence(s, current)) {
        if (maxLength <= current_length) {
          if (maxLength < current_length || current.compareTo(dictionary.get(result))<0){
            result = i;
            maxLength = current_length;
          }
        }
      }
    }

    return result == -1 ? "" : dictionary.get(result);
  }
  /**
   * @param s: src string
   * @param t: possible subsequence
   * @return: true if t is a subsequence of s, false otherwise
   */
  private boolean subsequence(String s, String t) {
    int j = 0;
    for (int i = 0; i < s.length() && j < t.length(); i++) if (s.charAt(i) == t.charAt(j)) j++;
    return j == t.length();
  }
}
