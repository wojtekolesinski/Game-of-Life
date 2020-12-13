package life;

public class Generations {

    public static boolean willSurvive(boolean[][] grid, int y, int x) {
        int neighbours = 0;
        if (y != grid.length - 1 && y != 0) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j < 1; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    if (grid[y+i][x+j]) {
                        neighbours++;
                    }
                }
            }
        }


        return neighbours == 3 || neighbours == 2;
    }

    public static Universe getNextGeneration(Universe life) {
        boolean[][] currentGen = life.grid;
        boolean[][] nextGen = new boolean[currentGen.length][currentGen.length];

        for (int i = 0; i < currentGen.length; i++) {
            for (int j = 0; j < currentGen[i].length; j++) {
                if (willSurvive(currentGen, i, j)) {
                    nextGen[i][j] = true;
                }
            }
        }

        return new Universe(nextGen);
    }
}
