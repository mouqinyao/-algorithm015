class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int x = grid.length;
        if (x == 0) return 0;
        int y = grid[0].length;
        boolean[][] visited = new boolean[x][y];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    // queue.offer(new int[]{i, j});
                    // visited[i][j] = true;
                    // bfs(grid, queue, visited, x, y);
                    dfs(grid, i, j, x, y);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
    public void bfs(char[][] grid, Queue<int[]> queue, boolean[][] visited, int m, int n) {
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >=n || visited[x][y] || grid[x][y] == '0') continue;
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }
    
    public void dfs(char[][] grid, int i, int j, int x, int y) {
        if (i < 0 || j < 0 || i >= x || j >= y || grid[i][j] != '1') return;
        grid[i][j] = '0';
        dfs(grid, i+1, j, x, y);
        dfs(grid, i-1, j, x, y);
        dfs(grid, i, j+1, x, y);
        dfs(grid, i, j-1, x, y);
    }
}