import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Four {

    private int four(int limit) {
        return IntStream.range(0, limit)
                .parallel()
                .mapToObj(i -> IntStream.range(0, limit).map(j -> i * j))
                .flatMapToInt(x -> x)
                .filter(this::isPalindromic)
                .max()
                .getAsInt();
    }

    @Test
    public void test() throws Exception {
        assertThat(isPalindromic(9009), is(true));
        assertThat(isPalindromic(9008), is(false));
        assertThat(reverse(9), is(9));
        assertThat(reverse(12), is(21));
        assertThat(reverse(101), is(101));
        assertThat(reverse(112), is(211));
        assertThat(reverse(123), is(321));

        System.out.println(four(1000));
    }

    private int reverse(int n) {
        int i = n;
        int last = i % 10;
        int result = last;

        while (i >= 10) {
            i -= last;
            i /= 10;
            last = i % 10;
            result *= 10;
            result += last;
        }

        return result;
    }

    private boolean isPalindromic(int i) {
        int digits = reverse(i);
        return digits == i;
    }
}
