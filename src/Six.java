import org.junit.Test;

import java.util.function.LongBinaryOperator;
import java.util.stream.LongStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Six {

    private final LongBinaryOperator add = (i, j) -> i + j;

    private long square(long i) {
        return i * i;
    }

    @Test
    public void test() throws Exception {
        assertThat(sumOfSquares(10L), is(385L));
        assertThat(squareOfSum(10L), is(3025L));
        assertThat(squareOfSum(10L) - sumOfSquares(10L), is(2640L));

        System.out.println(squareOfSum(100L) - sumOfSquares(100L));
    }

    private long squareOfSum(long limit) {
        long sum = LongStream
                .rangeClosed(1, limit)
                .reduce(add)
                .getAsLong();
        return square(sum);
    }

    private long sumOfSquares(long limit) {
        return LongStream
                .rangeClosed(1, limit)
                .map(this::square)
                .reduce(add)
                .getAsLong();
    }

}
