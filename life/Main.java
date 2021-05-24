package life;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            new Generations();
        });

        t1.start();
        t1.join();

    }
}
