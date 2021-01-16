package pl.kulig;

import java.util.Random;

public class Main {

    public static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        final int iterations = Integer.parseInt(System.getenv("NUMBER_ITERATIONS"));
        int numThreads = 3;

        if (System.getenv().containsKey("NUMBER_THREADS")) {
            numThreads = Integer.parseInt(System.getenv("NUMBER_THREADS"));
        }

        for (int j = 0; j < numThreads; j++) {
            new Thread(() -> {
                for (int i = 0; i < iterations; i++) {
                    int computation = i * i;
                    computation++;
                }
            }).start();
        }

        System.out.println("Finished");
    }
}
