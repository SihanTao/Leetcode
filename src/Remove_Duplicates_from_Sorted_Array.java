public class Remove_Duplicates_from_Sorted_Array {
  public int removeDuplicates_v1(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int previous, current;
    int result = nums.length;
    previous = current = nums[0];
    for (int i = 1; i < result; i++) {
      current = nums[i];
      if (current == previous) {
        shiftLeft(nums, i);
        i--;
        result--;
      }

      previous = current;
    }

    return result;
  }

  /**
   * @param nums: the array of integers to be left shifted
   * @param index: the index where the shift happens
   */
  private void shiftLeft(int[] nums, int index) {
    for (int i = index; i < nums.length - 1; i++) {
      nums[i] = nums[i + 1];
    }
  }

  /**
   * use two pointers to process
   * @param nums : the array of integers to be left shifted
   * @return the length of the new array
   */
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int slow, fast;
    for (slow = 0, fast = 1; fast < nums.length; fast++) {
      if (nums[fast] > nums[slow]) {
        nums[++slow] = nums[fast];
      }
    }
    return slow + 1;
  }
}
