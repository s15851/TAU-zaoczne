package pl.szczepanik.tau_labs.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pl.szczepanik.tau_labs.domain.Boat;

import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class BoatTest {
    @Test
    public void emptyBoatIsImplementedTest() {
        assertNotNull(new Boat());
    }

    @Test
    public void addBoatIsImplementedTest() {
        assertNotNull(new Boat(1, "Antila 27", 2009));
    }

}
