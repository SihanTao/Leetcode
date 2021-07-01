public class NondecreasingArray_665 {
  public boolean checkPossibility(int[] nums) {
    boolean changed = false;
    int n = nums.length;
    if (n == 1) {
      return true;
    }

    if (nums[0] > nums[1]) {
      nums[0] = nums[1];
      changed = true;
    }

    for (int i = 1; i < n - 1; i++) {
      if (nums[i] > nums[i + 1]) {
        if (changed) return false;

        if (nums[i + 1] < nums[i - 1]) {
          nums[i + 1] = nums[i];
        } else {
          nums[i] = nums[i - 1];
        }
        changed = true;
      }
    }
    return true;
  }
}
