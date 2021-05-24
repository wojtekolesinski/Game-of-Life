package life;

import javax.swing.*;

public class Generations {



    public static boolean willSurvive(boolean[][] grid, int y, int x) {

        int neighbours = 0;

        for (int i = -1; i <= 1; i++) {
            int y1 = y;
            if (y + i > grid.length - 1) {
                y1 = -1;
            } else if (y + i < 0) {
                y1 = grid.length;
            }
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0)
                    continue;

                int x1 = x;
                if (x + j > grid.length - 1) {
                    x1 = -1;
                } else if (x + j < 0) {
                    x1 = grid.length;
                }
                if (grid[y1+i][x1+j]) {
                    neighbours++;
                }
            }
        }


        if (grid[y][x]) {
            return neighbours == 3 || neighbours == 2;
        }
        return neighbours == 3;
    }

    public static Universe getNextGeneration(Universe life) {
        boolean[][] currentGen = life.grid;
        boolean[][] nextGen = new boolean[currentGen.length][currentGen.length];

        for (int i = 0; i < currentGen.length; i++) {
            for (int j = 0; j < currentGen[i].length; j++) {
                if (willSurvive(currentGen, i, j)) {
                    nextGen[i][j] = true;
                } else {
                    nextGen[i][j] = false;
                }
            }
        }

        return new Universe(nextGen);
    }

    public Generations() {
        GameOfLife game = new GameOfLife();
        Timer timer = new Timer(1000, e->{});

        while(game.universe.hasAlive()) {
            while (game.pause) {
                if (game.restart) {
                    game.universe = new Universe(game.uniSize);
                    game.gen.getAndSet(1);
                    game.restart = false;
                    game.repaint();
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (game.restart) {
                game.universe = new Universe(game.uniSize);
                game.gen.getAndSet(1);
                game.restart = false;
                game.repaint();
            }

            game.universe = getNextGeneration(game.universe);
            game.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Generations();
    }
}
