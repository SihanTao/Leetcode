package Q81;

public class Solution {
  public boolean search(int[] nums, int target) {
    // use binary search
    int left = 0;
    int right = nums.length-1;
    int mid;

    while (left <= right) {
      mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return true;
      }

      if (nums[mid] < nums[left]) {
        // latter part is sorted
        if (nums[mid] <= target && target < nums[right]) {
          // target might be in latter part
          left = mid + 1;
        } else {
          // target might be in the first part
          right = mid - 1;
        }
      } else if (nums[mid] > nums[left]) {
        // the first part is sorted
        if (nums[left] <= target && target < nums[mid]) {
          // target might in first part
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        left++;
      }
    }

    return false;
  }
}
