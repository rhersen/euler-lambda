import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class OneTest {

    private One target;

    @Before
    public void setUp() throws Exception {
        target = new One();
    }

    @Test
    public void test() throws Exception {
        assertThat(target.iterative(10), equalTo(23L));
        assertThat(target.iterative(1000), equalTo(233168L));
        assertThat(target.iterative(6000000000L), equalTo(8399999997000000000L));
    }
}
