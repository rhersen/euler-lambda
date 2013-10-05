import java.util.function.LongSupplier;
import java.util.stream.LongStream;

public class Two {
    private int count;

    public static void main(String[] args) {
        Two two = new Two();
        int limit = two.countLessThan(4000000);
        System.out.println(limit);
        System.out.println(LongStream.generate(new Fibonacci()).limit(limit).filter(i -> i % 2 == 0).sum());
    }

    int countLessThan(int limit) {
        count = 0;
        LongStream.generate(new Fibonacci()).filter(i -> {
            ++count;
            return i > limit;
        }).findFirst();
        return count - 1;
    }
}

class Fibonacci implements LongSupplier {
    private long p0 = 1L;
    private long p1 = 2L;

    public long getAsLong() {
        long r = p0;
        p0 = p1;
        p1 = r + p0;
        return r;
    }
}