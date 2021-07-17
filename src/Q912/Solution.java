package Q912;

import java.util.Random;

public class Solution {
  public Random random;

  public int[] sortArray(int[] nums) {
    random = new Random();
    pivot(nums, 0, nums.length-1);
    return nums;
  }

  public void pivot(int[] nums, int l, int r){
    if (l >= r) {
      return;
    }

    int mid = random.nextInt(r - l + 1) + l;
    swap(nums, l, r);
    int pivot = nums[l];
    int i = l + 1;
    int j = r;
    while (i < j) {
      while (nums[i] <= pivot && i < j) i++;
      while (nums[j] >= pivot && i < j) j--;
      swap(nums, i, j);
    }
    if (nums[i] <= pivot) {
      swap(nums, i, l);
    } else {
      swap(nums, i - 1, l);
      i--;
    }
    pivot(nums, i + 1, r);
    pivot(nums, l, i - 1);
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
