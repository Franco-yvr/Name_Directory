package ca.ubc.cs.cpsc210.tests;

import ca.ubc.cs.cpsc210.model.ContactList;
import ca.ubc.cs.cpsc210.model.*;
import ca.ubc.cs.cpsc210.model.exceptions.EmptyStringException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestContactList {

//    private Name b = new Name("Bill");
//    private Description t = new Description("tall");
//    private WhereTagList s = new WhereTagList("@Squamish");
//    private ConnectTagList two = new ConnectTagList("@2012");
    private Profile p = new Profile("Bill", "tall", "@Squamish", "@2012");
    ContactList c = new ContactList();


    @Test
    public void testContactListConstructor() {
        assertTrue(c.getContactList().isEmpty());
    }

    //getContactList is already tested in the previous test

    @Test
    public void TestAdd() {
        c.add(p);
        assertEquals(c.getContact(0), p);
    }

    @Test
    public void TestAddAgain() {
        c.getContactList().add(p);
        c.getContactList().add(p);
        assertEquals(c.getContact(1), p);
    }


    @Test
    public void TestGetContact() {
        c.getContactList().add(p);
        Profile test1 = c.getContact(0);
        Profile test2 = p;
        assertEquals(test1, test2);
    }

    @Test
    public void TestlenghtContactList() {
        c.getContactList().add(p);
        int x = c.lengthContactList();
        assertEquals(x, 1);
    }

//    @Test
//    public void TestAddContactWithoutName() {
//        assertFalse(c.addContact("", "tall", "@Squamish", "@2012"));
//        assertTrue(c.getContactList().isEmpty());
//    }
//
//    @Test
//    public void TestAddContactWithName() {
//        assertTrue(c.addContact("Bill", "tall", "@Squamish", "@2012"));
//        assertEquals(c.getContact(0).getName().getName(), "Bill");
//        assertEquals(c.getContact(0).getDescription().getDescription(), "tall");
//        assertEquals(c.getContact(0).getWhereTag().getTagItem(0), "Squamish");
//        assertEquals(c.getContact(0).getConnectTag().getTagItem(0), "2012");
//    }

    @Test
    public void TestSearchResultWithWordPresentNameConnectTagField() {
        c.getContactList().add(p);
        List<Profile> testlist = null;
        try {
            testlist = c.searchResult("2012");
        } catch (EmptyStringException e) {
            fail("We shouldn't get an exception for this test");
        }
        assertEquals(testlist.get(0).getConnectTag().getTagItem(0), "2012");
    }

    @Test
    public void TestSearchResultWithWordPresentWhereTagField() {
        c.getContactList().add(p);
        List<Profile> testlist = c.searchResult("Squamish");
        assertEquals(testlist.get(0).getWhereTag().getTagItem(0), "Squamish");
    }

    @Test
    public void TestSearchResultWithWordPresentDescriptionField() {
        c.getContactList().add(p);
        List<Profile> testlist = c.searchResult("tall");
        assertEquals(testlist.get(0).getDescription(), "tall");
    }

    @Test
    public void TestSearchResultWithWordPresentNameField() {
        c.getContactList().add(p);
        List<Profile> testlist = c.searchResult("Bill");
        assertEquals(testlist.get(0).getName(), "Bill");
    }

    @Test
    public void TestSearchResultWithoutPresent() {
        c.getContactList().add(p);
        assertTrue(c.searchResult("2013").isEmpty());
    }
}

