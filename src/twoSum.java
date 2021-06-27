import java.util.HashMap;
import java.util.Map;

public class twoSum {
  public static int[] two_sum(int[] nums, int target) {
    int[] result = new int[2];
    int length = nums.length;

    for (int i = 0; i < length; i++) {
      for (int j = i + 1; j < length; j++) {
        if (nums[i] + nums[j] == target) {
          //          result[0] = i;
          //          result[1] = j;
          //          return result;
          return new int[] {i, j};
        }
      }
    }
    return new int[0];
  }

  public static void main(String[] args) {
    int[] nums = new int[] {3, 3};
    int target = 6;
    int[] result = twoSum_hashtable(nums, target);
    System.out.println("[" + result[0] + "," + result[1] + "]");
  }

  public static int[] twoSum_hashtable(int[] nums, int target) {
    Map<Integer, Integer> hashtable = new HashMap<>();
    for (int i = 0; i < nums.length; ++i) {
      if (hashtable.containsKey(target - nums[i])) {
        return new int[] {hashtable.get(target - nums[i]), i};
      }
      hashtable.put(nums[i], i);
    }
    return new int[0];
  }
}
