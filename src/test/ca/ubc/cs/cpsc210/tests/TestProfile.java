package ca.ubc.cs.cpsc210.tests;

import org.junit.jupiter.api.Test;
import ca.ubc.cs.cpsc210.model.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestProfile {

    Profile p = new Profile("Bill", "tall", "@Squamish","@2012");

    @Test
    public void testProfileConstructor(){
        assertEquals(p.getName().getName(),"Bill");
        assertEquals(p.getDescription().getDescription(),"tall");
        assertEquals(p.getWhereTag().getTagItem(0), "Squamish");
        assertEquals(p.getConnectTag().getTagItem(0),"2012");
    }

    //Getters are already all covered in the constructor test above
}
