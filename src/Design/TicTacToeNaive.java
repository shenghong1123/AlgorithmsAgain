package Design;

public class TicTacToeNaive {
    int[][] grid;
    int n;
    /** Initialize your data structure here. */
    public TicTacToeNaive(int n) {
        grid = new int[n][n];
        this.n = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {

        grid[row][col] = player;

        // Check diagonal
        if (row == col) {
            for (int i = 0; i < n; i++) {
                if (grid[i][i] != player) break;
                if (i == n - 1 && grid[i][i] == player) return player;
            }
        }
        if (row + col == n - 1) {
            for (int i = 0; i < n; i++) {
                if (grid[i][n - 1 - i] != player) break;
                if (i == n - 1 && grid[i][n - 1 - i] == player) return player;
            }
        }

        // Check row
        for (int i = 0; i < n; i++) {
            if (grid[row][i] != player) break;
            if (i == n - 1 && grid[row][i] == player) return player;
        }

        // Check column
        for (int i = 0; i < n; i++) {
            if (grid[i][col] != player) break;
            if (i == n - 1 && grid[i][col] == player) return player;
        }

        return 0;
    }
}
