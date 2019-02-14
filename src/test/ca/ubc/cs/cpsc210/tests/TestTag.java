package ca.ubc.cs.cpsc210.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ca.ubc.cs.cpsc210.model.*;

import java.util.ArrayList;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestTag {

    Tag testTag = new Tag("@Whistler@2017@Sam's");
    //NOTE: given instructions to not worry about variations of spaces,
    // capitalisation and minor variations, the parser will take only
    // exact entries without spaces

    @Test
    public void testTagConstructorWithString() {
        assertEquals(testTag.getTagItem(0), "Whistler");
        assertEquals(testTag.getTagItem(1), "2017");
        assertEquals(testTag.getTagItem(2), "Sam's");
    }

    @Test
    public void testTagConstructorEmpty() {
        Tag testTag2 = new Tag("");
        assertEquals(testTag2.getTagItem(0), "");
    }

    @Test
    public void testAddTag() {
        testTag.addTag("monkey");
        assertEquals(testTag.getTagItem(3), "monkey");
    }

    @Test
    public void getTagItem() {
        assertEquals(testTag.getTagItem(1), "2017");
    }

    @Test
    public void getTagItemEmpty() {
        Tag testTag2 = new Tag("");
        assertEquals(testTag2.getTagItem(0), "");
    }

    @Test
    public void testSearchTagWhenKeyWordPresent() {
        assertTrue(testTag.searchTag("2017"));
    }

    @Test
    public void testSearchTagWhenKeyWordNotPresent(){
        assertFalse(testTag.searchTag("2016"));
    }
}


//    @Test
//    public void testEqual(){
//        String a = "";
//        String b = null;
//        boolean isNull = a.equals(b);
//        System.out.println(isNull);