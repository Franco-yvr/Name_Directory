package ca.ubc.cs.cpsc210.tests;

import ca.ubc.cs.cpsc210.model.exceptions.NameFieldEmptyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ca.ubc.cs.cpsc210.model.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestTagList {

    private TagList testTagList;
    private TagList testTagList2;
    private Profile p;

    @BeforeEach
    void setup() {
        testTagList = new TagList("@Whistler@2017@Sam's");
        //NOTE: given instructions to not worry about variations of spaces,
        // capitalisation and minor variations, the parser will take only
        // exact entries without spaces
        try {
            p = new Profile("Bill", "tall", "@Squamish", "@2012");
        } catch (NameFieldEmptyException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTagConstructorWithString() {
        assertEquals(testTagList.getTagItem(0), "Whistler");
        assertEquals(testTagList.getTagItem(1), "2017");
        assertEquals(testTagList.getTagItem(2), "Sam's");
    }

    @Test
    public void testTagConstructorEmpty() {
        TagList testTagList2 = new TagList("");
        assertTrue(testTagList2.getTaglist().isEmpty());
    }

    @Test
    public void testGetTag() {
        assertEquals(testTagList.getTaglist().get(2), "Sam's");
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
        assertTrue(testTagList2.getTaglist().isEmpty());
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
    public void testSearchTagWhenKeyWordNotPresent() {
        assertFalse(testTagList.searchTag("2016"));
    }

    @Test
    public void testOverrideEqualsObjectEqual() {
        testTagList2 = new TagList("@Whistler@2017@Sam's");
        assertTrue(testTagList.equals(testTagList2));
    }

    @Test
    public void testOverrideEqualsObjectNotEqual() {
        testTagList2 = new TagList("@Pemberton@2016@Sammy's");
        assertFalse(testTagList.equals(testTagList2));
    }

    @Test
    public void testOverrideEqualsObjectSame() {
        assertTrue(testTagList.equals(testTagList));
    }

    @Test
    public void testOverrideEqualsObjectNull() {
        testTagList2 = null;
        assertFalse(testTagList.equals(testTagList2));
    }

    @Test
    public void testOverrideEqualsObjectDifferentType() {
        String s = "Awesome";
        assertFalse(testTagList.equals(s));
    }
}


//    @Test
//    public void testEqual(){
//        String a = "";
//        String b = null;
//        boolean isNull = a.equals(b);
//        System.out.println(isNull);