package Algorithms;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'){
                    result++;
                    explore(grid, i, j);
                }
            }
        }
        return result;
    }
    private void explore(char[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        explore(grid, i - 1, j);
        explore(grid, i + 1, j);
        explore(grid, i, j - 1);
        explore(grid, i, j + 1);
    }
}
