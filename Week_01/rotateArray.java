class Solution {
    public void rotate(int[] nums, int k) {
      int n = nums.length;
      int step = k % n;
      reverse(nums, 0, n - 1);
      reverse(nums, 0, step - 1);
      reverse(nums, step, n - 1);
      
    }
    private void reverse(int[] nums, int start, int end) {
      while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
      }
    }
}