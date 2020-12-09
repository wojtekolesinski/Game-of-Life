package life;

import java.util.Random;

public class Universe {
    boolean[][] grid;

    public Universe(int n, long s) {
        this.grid = new boolean[n][n];

        Random random = new Random(s);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = random.nextBoolean();
            }
        }
    }

    public Universe (boolean[][] newGrid) {
        this.grid = newGrid;
    }
}
