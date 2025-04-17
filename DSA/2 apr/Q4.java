import java.util.*;

class Q4{
    public static int numIslands(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0; 

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) { 
                    count++; 
                    dfs(grid, r, c); 
                }
            }
        }
        return count;
    }

    public static void dfs(int[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] != 1) {
            return;
        }

        //  visited
        grid[r][c] = -1;

        // Move in all 4 directions 
        dfs(grid, r + 1, c); // Down
        dfs(grid, r - 1, c); // Up
        dfs(grid, r, c + 1); // Right
        dfs(grid, r, c - 1); // Left
    }

    public static void main(String[] args) {
      
        
        int[][] grid1 = {
            {1, 1, 1, 1, 0},
            {1, 1, 0, 1, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };
        System.out.println("Number of islands" + numIslands(grid1)); 

        int[][] grid2 = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 1}
        };
        System.out.println("Number of islands,d" + numIslands(grid2)); 
    }
}
