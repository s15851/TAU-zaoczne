package pl.szczepanik.tau_labs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class BoatTest {
    @Test
    public void boatIsImplementedTest() {
        assertNotNull(new Boat());
    }
}
