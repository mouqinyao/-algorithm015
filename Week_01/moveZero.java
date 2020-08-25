class Solution {
    public void moveZeroes(int[] nums) {
      int count = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
          nums[count++] = nums[i];
        }
      }
      for (int j = count; j < nums.length; j++) {
        nums[count++] = 0;
      }
    }
}