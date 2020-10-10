package pl.kulig;

import java.util.Random;

public class Main {

    public static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        final int iterations = Integer.parseInt(System.getenv("NUMBER_ITERATIONS"));
        int lambda = 10;

        if (System.getenv().containsKey("LAMBDA")) {
            lambda = Integer.parseInt(System.getenv("LAMBDA"));
        }

        for (int i = 0; i < iterations; i++) {
            final int computation = i * i;

            Thread.sleep((long) getBreakLength(lambda));
        }

        System.out.println("Finished");
    }

    private static Integer getBreakLength(double lambda) {
        return (int) Math.round(Math.log(1 - random.nextDouble())/(- lambda));
    }
}
