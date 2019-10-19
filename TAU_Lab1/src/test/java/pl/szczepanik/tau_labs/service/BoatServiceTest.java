package pl.szczepanik.tau_labs.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pl.szczepanik.tau_labs.domain.Boat;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class BoatServiceTest {
    BoatService boats = new BoatService(new ArrayList<Boat>());

    @Test
    public void emptyBoatIsImplementedTest() {
        assertNotNull(new BoatServiceTest());
    }

    @Test
    public void BoatIsImplementedTest() {
        assertNotNull(boats);
    }

    @Test
    public void createMethodInCarRepositoryIsImplementedTest(){
        assertNotNull(boats.create());
    }

    @Test
    public void readMethodInCarRepositoryIsImplementedTest(){
        assertNotNull(boats.read());
    }
    @Test
    public void updateMethodInCarRepositoryIsImplementedTest(){
        assertNotNull(boats.update());
    }
    @Test
    public void deleteMethodInCarRepositoryIsImplementedTest(){
        assertNotNull(boats.delete());
    }

}
