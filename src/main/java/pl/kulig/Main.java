package pl.kulig;

import java.math.BigInteger;
import java.util.Random;

public class Main {

    public static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        final BigInteger iterations = new BigInteger(System.getenv("NUMBER_ITERATIONS"));
        int numThreads = 3;

        if (System.getenv().containsKey("NUMBER_THREADS")) {
            numThreads = Integer.parseInt(System.getenv("NUMBER_THREADS"));
        }

        for (int j = 0; j < numThreads; j++) {
            new Thread(() -> {
                for (BigInteger i = BigInteger.ZERO; i.compareTo(iterations) < 0; i = i.add(BigInteger.ONE) ) {
                    BigInteger computation = i.multiply(i);
                }
            }).start();
        }

        System.out.println("Finished");
    }
}
