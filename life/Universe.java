package life;

import java.util.Random;

public class Universe {
    boolean[][] grid;
    static int generations = 0;

    public Universe(int n) {
        this.grid = new boolean[n][n];

        Random random = new Random();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = random.nextBoolean();
            }
        }
        generations++;
    }

    public Universe (boolean[][] newGrid) {
        this.grid = newGrid;
        generations++;
    }

    protected int getAlive() {
        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public void print() {
        System.out.println("Generation #" + generations);
        System.out.println("Alive: " + getAlive());
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] ? "O":" ");
            }
            System.out.println();
        }
    }
}
