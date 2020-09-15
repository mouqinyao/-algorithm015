class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(result, track, n, k, 1);
        return result;
    }
    public void backtrack(List<List<Integer>> result, LinkedList<Integer> track, int n, int k, int start) {
        if (k == 0) {
            result.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            track.add(i);
            backtrack(result, track, n, k - 1, i + 1);
            track.removeLast();
        }
    }
}