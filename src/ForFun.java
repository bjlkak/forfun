import java.util.HashSet;
import java.util.Set;

public class ForFun {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

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

    //rotating array?
    public int search(int[] arr, int target) {
        int start = 0, end = arr.length - 1, mid;

        while(start <= end){

            mid = start + (end - start) / 2;

            if(target == arr[mid]){
                return mid;
            }
            else if(arr[mid] >= arr[start]){
                if(target < arr[mid] && target >= arr[start]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else if(arr[mid] < arr[start]){
                if(target > arr[mid] && target < arr[start]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode t = new TreeNode(preorder[0]);
        for(int i = 1; i < preorder.length; i++) {
            insert(t, preorder[i]);
        }
        return t;

    }
    private void insert(TreeNode r, int i) {
        TreeNode in = new TreeNode(i);
        while(true) {
            if(r.val < i) {
                if(r.right == null) {
                    r.right = in;
                    break;
                }
                else {
                    r = r.right;
                }
            }
            else {
                if(r.left == null) {
                    r.left = in;
                    break;
                }
                else {
                    r = r.left;
                }
            }
        }
    }

    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int jump = nums[0];
        for(int i = 1; i < nums.length; i++) {
            jump--;
            if(jump+i >= nums.length-1)
                return true;
            if(jump < 0)
                break;

            if(nums[i] > jump) {
                jump = nums[i];
            }
        }

        return false;
    }

    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode t) {
        max = Integer.MIN_VALUE;

        int sum = getSum(t);

        return Math.max(sum, max);
    }
    private int getSum(TreeNode t) {
        if(t == null) return 0;

        max = t.val > max ? t.val : max;

        int sum = getSum(t.left) + getSum(t.right) + t.val;

        max = sum > max ? sum : max;

        return sum;
    }
}
