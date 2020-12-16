package life;


import java.lang.Thread;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        }
        catch (IOException | InterruptedException e) {}
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long s = 10;
        int m = 9;

        Universe life = new Universe(n, s);
//        life.print();
        for (int k = 0; k < m; k++) {
            life.print();
            life = Generations.getNextGeneration(life);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clear();
        }


//        clear();

    }
}
