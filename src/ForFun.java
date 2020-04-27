public class ForFun {
    public int[] productExceptSelf(int[] nums) {

        int x = 1;
        int[] output = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int c = nums[i];
            output[i] = x;
            x *= c;
        }

        x = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            int c = nums[i];
            output[i] *= x;
            x *= c;
        }
        return output;
    }

    public int numIslands(char[][] grid) {
        int x = grid.length, y = grid[0].length;
        boolean[][] visited = new boolean[x][y];

        int count = 0;
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    visited = visitIsland(visited, grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }
    private boolean[][] visitIsland(boolean visited[][], char[][] grid, int i, int j) {
        if (grid[i][j] == '0' || visited[i][j]) return visited;

        visited[i][j] = true;

        if(i-1 >= 0) visited = visitIsland(visited, grid, i-1, j);
        if(j-1 >= 0) visited = visitIsland(visited, grid, i, j-1);
        if(i+1 < grid.length) visited = visitIsland(visited, grid, i+1, j);
        if(j+1 < grid[0].length) visited = visitIsland(visited, grid, i, j+1);

        return visited;
    }

    public int minPathSum(int[][] grid) {
        if(grid.length == 0) return 0;

        int sum = 0;

        return getSum(grid, sum, 0, 0);
    }
    private int getSum(int[][] grid, int sum, int x, int y) {
        sum += grid[x][y];
        if(x == grid.length - 1 && y == grid[0].length - 1) {
            return sum;
        }

        if(x == grid.length - 1) {
            return getSum(grid, sum, x, y+1);
        }
        if(y == grid[0].length - 1) {
            return getSum(grid, sum, x+1, y);
        }

        return Math.min(getSum(grid, sum, x+1, y), getSum(grid, sum, x, y+1));
    }
}
