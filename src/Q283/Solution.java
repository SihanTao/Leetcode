package Q283;

public class Solution {
  public void moveZeroes(int[] nums) {
    int slow = 0, fast = 0;
    while(fast<nums.length) {
      while(fast<nums.length&&nums[fast] == 0) fast++;
      if(fast==nums.length) break;
      nums[slow++] = nums[fast++];
    }

    while(slow<nums.length) {
      nums[slow++] = 0;
    }
  }
}
