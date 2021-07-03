public class Merge_Sorted_Array_88 {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int position = m-- + n-- - 1;
    while (m >= 0 && n >= 0) {
      nums1[position--] = (nums2[n] > nums1[m]) ? nums2[n--] : nums1[m--];
    }

    while (n >= 0) {
      nums1[position--] = nums2[n--];
    }
  }
}
