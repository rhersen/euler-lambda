import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.function.LongPredicate;
import java.util.stream.LongStream;

public class One {
    private int x=0;

    public static void main(String[] args) {
        new One().measure();
    }

    private void measure() {
        long limit = 30000000L;
        long start;
        long result;

        for (int i = 0; i < 1; i++) {
            start = System.nanoTime();
            result = stupid(limit);
            print("stupid", start, result);

//            start = System.nanoTime();
//            result = iterative(limit);
//            print("iterative", start, result);

//            start = System.nanoTime();
//            result = functional(limit);
//            print("functional", start, result);
        }
        System.out.println(x);
    }

    private long functional(long limit) {
        LongPredicate predicate = i -> i % 3 == 0 || i % 5 == 0;
        return LongStream.range(0, limit)
                .filter(predicate)
                .sum();
    }

    public long stupid(long limit) {
        ArrayDeque<Long> all = new ArrayDeque<>();
        ArrayDeque<Long> filtered = new ArrayDeque<>();
        long reduced = 0;

        for (long i = 0; i < limit; i++) {
            all.add(i);
        }

        for (Long i : all) {
            if (isMultiple(i)) {
                filtered.add(i);
            }
        }

        for (Long i : filtered) {
            reduced += i;
        }

        return reduced;
    }

    private boolean isMultiple(Long i) {

        x++;
        return i % 3 == 0 || i % 5 == 0;
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

    private PrintStream print(String s, long start, long result) {
        return System.out.format("%6.3f\t%d\t%s\n", (System.nanoTime() - start) * 1e-9, result, s);
    }
}
