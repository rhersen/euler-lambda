import java.io.PrintStream;
import java.util.stream.LongStream;

public class One {
    public static void main(String[] args) {
        new One().measure();
    }

    private void measure() {
        long limit = 6000000000L;
        long start;
        long result;

        for (int i = 0; i < 3; i++) {
            start = System.nanoTime();
            result = iterative(limit);
            print(start, result);

            start = System.nanoTime();
            result = functional(limit);
            print(start, result);

            start = System.nanoTime();
            result = parallel(limit);
            print(start, result);
        }
    }

    private PrintStream print(long start, long result) {
        return System.out.format("%6.3f\t%d\n", (System.nanoTime() - start) * 1e-9, result);
    }

    public long iterative(long limit) {
        long sum = 0;
        for (long i = 1; i < limit; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public long functional(long limit) {
        return LongStream
                .range(1, limit)
                .filter(i -> i % 3 == 0 || i % 5 == 0)
                .sum();
    }

    public long parallel(long limit) {
        return LongStream
                .range(1, limit)
                .parallel()
                .filter(i -> i % 3 == 0 || i % 5 == 0)
                .sum();
    }

}
