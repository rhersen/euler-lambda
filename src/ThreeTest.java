import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ThreeTest {

    private Three target;

    @Before
    public void setUp() throws Exception {
        target = new Three();
    }

    @Test
    public void test() throws Exception {
        assertThat(target.primeFactors(3), equalTo(new long[]{3L}));
        assertThat(target.primeFactors(4), equalTo(new long[]{2L, 2L}));
        assertThat(target.primeFactors(5), equalTo(new long[]{5L}));
        assertThat(target.primeFactors(6), equalTo(new long[]{2L, 3L}));
        assertThat(target.primeFactorStream(600851475143L).max().getAsLong(), equalTo(6857L));
    }
}
