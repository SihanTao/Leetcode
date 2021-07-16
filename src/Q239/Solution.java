package Q239;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
        (o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[0]
    );

    for (int i = 0; i < k; i++) {
      priorityQueue.offer(new int[] {nums[i], i});
    }
    int[] result = new int[n - k + 1];
    result[0] = priorityQueue.peek()[0];
    for (int i = k; i < n; i++) {
      priorityQueue.offer(new int[] {nums[i], i});
      while (priorityQueue.peek()[1] <= i - k) {
        priorityQueue.poll();
      }
      result[i - k + 1] = priorityQueue.peek()[0];
    }
    return result;
  }
}
