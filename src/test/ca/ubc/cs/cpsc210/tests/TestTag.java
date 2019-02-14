package ca.ubc.cs.cpsc210.tests;

import org.junit.jupiter.api.Test;
import ca.ubc.cs.cpsc210.model.*;

import java.util.ArrayList;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestTag {

    Tag testTag;

    @Test
    public void testTagToMakeList() {
        testTag = new Tag("@Whistler @2017 @Sam's");
        assertEquals(testTag.getTagItem(0), "@Whistler");
        assertEquals(testTag.getTagItem(1), "@2017");
        assertEquals(testTag.getTagItem(2), "@Sam's");
    }

    @Test
    public void testTagEmpty() {
        testTag = new Tag("");
        assertEquals(testTag.getTagItem(0), "");
    }

    @Test
    public void testAddTag() {
        testTag = new Tag("@Whistler @2017 @Sam's");
        testTag.addTag("monkey");
        assertEquals(testTag.getTagItem(3), "monkey");
    }

    @Test
    public void testGetTag() {
        testTag = new Tag("@Whistler");
        Tag testTag2 = new Tag("");
        testTag2.addTag("@Whistler");
        assertEquals(testTag.getTagItem(0), testTag2.getTagItem(0));
    }

    @Test
    public void testSearchTag() {

    }
}


