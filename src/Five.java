import org.junit.Test;

import java.util.OptionalLong;
import java.util.stream.LongStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Five {

    @Test
    public void test() throws Exception {
        assertThat(findSmallest(), is(2520L));
    }

    private long findSmallest() {
        long primes = 2L * 3 * 5 * 7 * 11 * 13 * 17 * 19;
        OptionalLong first = LongStream.range(1, Long.MAX_VALUE)
                .map(i -> i * primes)
                .filter(this::dividesAll)
                .findFirst();
        return first.getAsLong();
    }

    private boolean dividesAll(long n) {
        return LongStream.rangeClosed(1, 20).allMatch(divisor -> n % divisor == 0);
    }

}
