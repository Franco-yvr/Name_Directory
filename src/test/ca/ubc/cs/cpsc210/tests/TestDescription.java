package ca.ubc.cs.cpsc210.tests;
import ca.ubc.cs.cpsc210.model.Description;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDescription {

    @Test
    public void TestDescriptionConstructor() {
        Description d = new Description("Initial Description for test");
        assertEquals(d.getDescription(), "Initial Description for test");
    }

    @Test
    public void testSetDescription() {
        Description d = new Description("Initial Description for test");
        d.setDescription("Changed description for test");
        assertEquals(d.getDescription(), "Changed description for test");
    }

    @Test
    public void getDescription() {
        Description d = new Description("Initial Description for test");
        String testing = d.getDescription();
        assertEquals(testing, "Initial Description for test");
    }
}
