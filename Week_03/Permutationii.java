class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(result, nums, track, used);
        return result;
    }
    public void backtrack(List<List<Integer>> result, int[] nums, LinkedList<Integer> track, boolean[] used) {
        if (track.size() == nums.length) {
            result.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i-1] == nums[i] && !used[i-1]) continue;
            used[i] = true;
            track.add(nums[i]);
            backtrack(result, nums, track, used);
            track.removeLast();
            used[i] = false;
        }
    }
}