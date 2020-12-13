package life;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long s = scanner.nextLong();
        int m = scanner.nextInt();

        Universe life = new Universe(n, s);
        for (int k = 0; k < m; k++) {
            life = Generations.getNextGeneration(life);
        }

        for (int i = 0; i < life.grid.length; i++) {
            for (int j = 0; j < life.grid[0].length; j++) {
                System.out.print(life.grid[i][j] ? "O":" ");
            }
            System.out.println();
        }

    }
}
