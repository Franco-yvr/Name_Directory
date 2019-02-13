package ca.ubc.cs.cpsc210.tests;

import org.junit.jupiter.api.Test;
import ca.ubc.cs.cpsc210.model.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestName {

    @Test
    public void testName() {
        Name n = new Name("bamboo");
        assertEquals(n.getName(), "bamboo");
    }

    @Test
    public void testSetName(){
        Name n = new Name("bamboo");
        n.setName("jute");
        assertEquals(n.getName(), "jute");
    }

    @Test
    public void getName(){
        Name n = new Name("flax");
        String testing = n.getName()
        assertEquals(testing, "flax");
    }
}
