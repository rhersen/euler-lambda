import java.util.OptionalLong;
import java.util.stream.LongStream;

public class Three {
    public LongStream primeFactorStream(long n) {
        OptionalLong factor = LongStream.range(2, n).filter(i -> n % i == 0).findAny();
        if (factor.isPresent()) {
            long f = factor.getAsLong();
            return LongStream.concat(LongStream.of(f), primeFactorStream(n / f));
        } else {
            return LongStream.of(n);
        }
    }

    public long[] primeFactors(long n) {
        return primeFactorStream(n).toArray();
    }
}
