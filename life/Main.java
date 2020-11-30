package life;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();

        boolean[][] grid = new boolean[n][n];
        Random random = new Random(s);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = random.nextBoolean();
                System.out.print(grid[i][j] ? "O":" ");
            }
            System.out.println();
        }
    }
}
