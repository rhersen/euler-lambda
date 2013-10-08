import org.junit.Test;

import java.util.stream.LongStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Seven {

    @Test
    public void test() throws Exception {
        assertThat(isPrime(2L), is(true));
        assertThat(isPrime(3L), is(true));
        assertThat(isPrime(4L), is(false));
        assertThat(isPrime(5L), is(true));
        assertThat(getPrime(3), is(5L));
        assertThat(getPrime(6), is(13L));

        System.out.println(getPrime(10001));
    }

    private long getPrime(int n) {
        return LongStream
                .range(2, Long.MAX_VALUE)
                .filter(this::isPrime)
                .substream(n - 1)
                .findFirst()
                .getAsLong();
    }

    private boolean isPrime(long n) {
        long sqrt = sqrt(n);
        return !LongStream
                .range(2, sqrt)
                .anyMatch(i -> n % i == 0);
    }

    private long sqrt(long n) {
        return 1L + (long) Math.sqrt(n);
    }

}
