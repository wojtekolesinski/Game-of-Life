package life;

import java.util.Random;

public class Universe {
    boolean[][] grid;
    static int generations = 0;

    public Universe(int n, long s) {
        this.grid = new boolean[n][n];

        Random random = new Random(s);

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
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                if (this.grid[i][j]) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public void print() {
        System.out.println("Generation #" + generations);
        System.out.println("Alive: " + this.getAlive());
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[0].length; j++) {
                System.out.print(this.grid[i][j] ? "O":" ");
            }
            System.out.println();
        }
    }
}
