package Q215;

import java.util.Random;

public class Solution {
  private Random random;

  public int findKthLargest(int[] nums, int k) {
    random = new Random();
    int[] result = {-1};
    pivot(nums, 0, nums.length - 1, nums.length - k, result);
    return result[0];
  }

  private void pivot(int[] nums, int l, int r, int k, int[] result) {
    if (l >= r || result != null) {
      return;
    }

    int mid = random.nextInt(r - l + 1) + l;
    swap(nums, l, mid);
    int i = l + 1;
    int j = r;
    while (i < j) {
      while (i < j && nums[i] < nums[l]) {
        i++;
      }
      while (i < j && nums[j] > nums[l]) {
        j--;
      }
      swap(nums, i, j);
    }

    if (nums[i] <= nums[l]) {
      swap(nums, i, l);
    } else {
      swap(nums, i - 1, l);
      i--;
    }

    if (i == k) {
      result[0] = nums[i];
    }

    pivot(nums, i + 1, r, k, result);
    pivot(nums, l,i - 1, k, result);
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
