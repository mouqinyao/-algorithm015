class Solution {
    // Monotonic Stack
    public int trap(int[] height) {
      if (height == null || height.length < 2) return 0;
      
      Stack<Integer> stack = new Stack<>();
      int water = 0, i = 0;
  
      while (i < height.length) {
        if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
            stack.push(i++);
        } else {
          int pre = stack.pop();
          if (!stack.isEmpty()) {
            // find the smaller height between the two sides
            int minHeight = Math.min(height[stack.peek()], height[i]);
            // calculate the area
            water += (minHeight - height[pre]) * (i - stack.peek() - 1);
          }
        }
    }
    return water;
    // Two Pointers
      // int maxRain = 0;
      // int low = 0, high = height.length - 1;
      // int leftMax = 0, rightMax = 0;
      
      // while (low < high) {
        // leftMax = Math.max(leftMax, height[low]);
        // rightMax = Math.max(rightMax, height[high]);
        // if (leftMax < rightMax) {
          // maxRain += leftMax - height[low];
          // low++;
        // } else {
          // maxRain += rightMax - height[high];
          // high--;
        // }
      // }
      
      // return maxRain;
    }
}