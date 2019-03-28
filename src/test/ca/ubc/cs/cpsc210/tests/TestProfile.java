package ca.ubc.cs.cpsc210.tests;

import ca.ubc.cs.cpsc210.model.exceptions.NameFieldEmptyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ca.ubc.cs.cpsc210.model.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestProfile {
    private Profile p;
    private Profile p2;

    @BeforeEach
    void setup() {
        try {
            p = new Profile("Bill", "tall", "@Squamish", "@2012");
        } catch (NameFieldEmptyException e) {
            fail("We shouldn't get an exception for the purpose of this test");
        }
    }

    @Test
    public void testProfileConstructor() {
        assertEquals(p.getName(), "Bill");
        assertEquals(p.getDescription(), "tall");
        assertEquals(p.getWhereTag().getTagItem(0), "Squamish");
        assertEquals(p.getConnectTag().getTagItem(0), "2012");
    }

    @Test
    public void testOverrideEqualsObjectEqual() {
        try {
            p2 = new Profile("Bill", "tall", "@Squamish", "@2012");
        } catch (NameFieldEmptyException e) {
            e.printStackTrace();
        }
        assertTrue(p.equals(p2));
    }

    @Test
    public void testOverrideEqualsObjectNotEqual() {
        try {
            p2 = new Profile("Paul", "short", "@Kelowna", "@2010");
        } catch (NameFieldEmptyException e) {
            e.printStackTrace();
        }
        assertFalse(p.equals(p2));
    }

    @Test
    public void testOverrideEqualsSameObject() {
        assertTrue(p.equals(p));
    }

    @Test
    public void testOverrideEqualsNullObject() {
        Profile p3 = null;
        assertFalse(p.equals(p3));
    }

    @Test
    public void testOverrideEqualsObjectDifferentType() {
        String s = "whoohooo";
        assertFalse(p.equals(s));
    }
}

//Getters are already all covered in the constructor test above


//@Test
//    void test(){
//            ArrayList<Boolean> test1 = new ArrayList<>();
//        test1.add(true);
//        test1.add(false);
//        test1.add(true);
//
//        ArrayList<Boolean> test2 = new ArrayList<>();
//        test2.add(true);
//        test2.add(false);
//        test2.add(true);
//
//        System.out.println(test1.equals(test2));