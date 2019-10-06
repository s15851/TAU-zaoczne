package grupa1;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertNotNull;


@RunWith(JUnit4.class)

public class FlatTest {

    @Test
    public void flatIsImplementedTest() {
        assertNotNull(new Flat());

    }
}
