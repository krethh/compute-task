package pl.kulig;

import java.util.Random;

public class Main {

    public static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        final int iterations = Integer.parseInt(System.getenv("NUMBER_ITERATIONS"));
        int numThreads = 3;
        int lambda = 10;

        if (System.getenv().containsKey("LAMBDA")) {
            lambda = Integer.parseInt(System.getenv("LAMBDA"));
        }
        if (System.getenv().containsKey("NUMBER_THREADS")) {
            numThreads = Integer.parseInt(System.getenv("NUMBER_THREADS"));
        }

        for (int j = 0; j < numThreads; j++) {
            int finalLambda = lambda;
            new Thread(() -> {
                for (int i = 0; i < iterations; i++) {
                    final int computation = i * i;

                    final Integer breakLength = getBreakLength(i, finalLambda);
                    System.out.println(breakLength);
                    try {
                        Thread.sleep(breakLength);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        System.out.println("Finished");
    }

    private static Integer getBreakLength(int i, int lambda) {
        if (i % lambda == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
