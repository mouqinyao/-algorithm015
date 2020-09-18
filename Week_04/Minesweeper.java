class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(click);
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0], 
                col = current[1],
                count = 0 ;
            for(int[] d : dirs){
                int r = row + d[0], c = col + d[1];
                if(r >= m || c >= n || r < 0 || c < 0) continue;
                if(board[r][c] == 'M') count++;
            }
            if (count > 0)
                board[row][col] = (char)(count + '0');
            else {
                board[row][col] = 'B';
                for(int[] d : dirs){
                    int r = row + d[0] , c = col + d[1];
                    if (r >= m || c >= n || r < 0 || c < 0) continue;
                    if (board[r][c] == 'E'){
                        queue.add(new int[] { r, c });
                        board[r][c] = 'B';
                    }
                }
            }
        }
        
        return board;
    }
}