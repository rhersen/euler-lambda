import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TwoTest {

    private Two target;

    @Before
    public void setUp() throws Exception {
        target = new Two();
    }

    @Test
    public void test() throws Exception {
        assertThat(target.countLessThan(4), equalTo(3));
        assertThat(target.countLessThan(100), equalTo(10));
    }
}
