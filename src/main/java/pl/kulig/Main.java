package pl.kulig;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final int iterations = Integer.parseInt(System.getenv("NUMBER_ITERATIONS"));

        for (int i = 0; i < iterations; i++) {
            final int computation = i * i;

            Thread.sleep((long) i % 10);
        }

        System.out.println("Finished");
    }
}
