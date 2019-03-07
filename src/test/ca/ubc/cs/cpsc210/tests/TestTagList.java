package ca.ubc.cs.cpsc210.tests;

import org.junit.jupiter.api.Test;
import ca.ubc.cs.cpsc210.model.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestTagList {

    TagList testTagList = new TagList("@Whistler@2017@Sam's");
    //NOTE: given instructions to not worry about variations of spaces,
    // capitalisation and minor variations, the parser will take only
    // exact entries without spaces

    Profile p = new Profile("Bill", "tall", "@Squamish","@2012");


    @Test
    public void testTagConstructorWithString() {
        assertEquals(testTagList.getTagItem(0), "Whistler");
        assertEquals(testTagList.getTagItem(1), "2017");
        assertEquals(testTagList.getTagItem(2), "Sam's");
    }

    @Test
    public void testTagConstructorEmpty() {
        TagList testTagList2 = new TagList("");
        assertTrue(testTagList2.getTag().isEmpty());
    }

    @Test
    public void testGetTag(){
        assertEquals(testTagList.getTag().get(2), "Sam's");
    }

    @Test
    public void testAddTag() {
        testTagList.addTag("monkey");
        assertEquals(testTagList.getTagItem(3), "monkey");
    }

    @Test
    public void getTagItem() {
        assertEquals(testTagList.getTagItem(1), "2017");
    }

    @Test
    public void getTagItemEmpty() {
        TagList testTagList2 = new TagList("");
        assertTrue(testTagList2.getTag().isEmpty());
    }

    @Test
    public void testSearchTagWhenKeyWordPresentFirstField() {
        assertTrue(testTagList.searchTag("Whistler"));
    }

    @Test
    public void testSearchTagWhenKeyWordPresentSecondField() {
        assertTrue(testTagList.searchTag("2017"));
    }

    @Test
    public void testSearchTagWhenKeyWordPresentThirdField() {
        assertTrue(testTagList.searchTag("Sam's"));
    }

    @Test
    public void testSearchTagWhenKeyWordNotPresent(){
        assertFalse(testTagList.searchTag("2016"));
    }
}


//    @Test
//    public void testEqual(){
//        String a = "";
//        String b = null;
//        boolean isNull = a.equals(b);
//        System.out.println(isNull);