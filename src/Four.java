import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Four {

    private int four(int limit) {
        return IntStream.range(0, limit)
                .mapToObj(i -> IntStream.range(0, limit).map(j -> i * j))
                .flatMapToInt(x -> x)
                .filter(this::isPalindromic)
                .max().getAsInt();
    }

    @Test
    public void test() throws Exception {
        assertThat(isPalindromic(9009), is(true));
        assertThat(isPalindromic(9008), is(false));
        assertThat(digits(9), is(asList(9)));
        assertThat(digits(11), is(asList(1, 1)));

        System.out.println(four(100));
    }

    private List<Integer> digits(int n) {
        if (n < 10) {
            return asList(n);
        } else {
            int mod = n % 10;
            List<Integer> r = new ArrayList<>();
            r.add(mod);
            r.addAll(digits((n - mod) / 10));
            return r;
        }
    }

    private boolean isPalindromic(int i) {
        List<Integer> digits = digits(i);
        LinkedList<Integer> reversed = new LinkedList<>(digits);
        Collections.reverse(reversed);
        return digits.equals(reversed);
    }
}
