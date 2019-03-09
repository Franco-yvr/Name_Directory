package ca.ubc.cs.cpsc210.tests;

import ca.ubc.cs.cpsc210.model.ContactList;
import ca.ubc.cs.cpsc210.model.*;
import ca.ubc.cs.cpsc210.model.exceptions.EmptyStringException;
import ca.ubc.cs.cpsc210.model.exceptions.NameFieldEmptyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestContactList {

    private Profile p;
    private ContactList c;

    @BeforeEach
    void setup() {
        try {
            p = new Profile("Bill", "tall", "@Squamish", "@2012");
        } catch (NameFieldEmptyException e) {
            fail("We shouldn't get an exception for the purpose of this test");
        }
        c = new ContactList();
    }

    @Test
    public void testContactListConstructor() {
        assertTrue(c.getContactList().isEmpty());
    }

    //getContactList is already tested in the previous test

    @Test
    public void testAdd() {
        c.add(p);
        assertEquals(c.getContact(0), p);
    }

    @Test
    public void testAddAgain() {
        c.getContactList().add(p);
        c.getContactList().add(p);
        assertEquals(c.getContact(1), p);
    }


    @Test
    public void testGetContact() {
        c.getContactList().add(p);
        Profile test1 = c.getContact(0);
        Profile test2 = p;
        assertEquals(test1, test2);
    }

    @Test
    public void testLengthContactList() {
        c.getContactList().add(p);
        int x = c.lengthContactList();
        assertEquals(x, 1);
    }

    @Test
    public void testSearchResultWithWordPresentNameConnectTagField() {
        c.getContactList().add(p);
        List<Profile> testlist = null;
        try {
            testlist = c.searchResult("2012");
        } catch (EmptyStringException e) {
            fail("We shouldn't get an exception for the purpose of this test");
        }
        assertEquals(testlist.get(0).getConnectTag().getTagItem(0), "2012");
    }

    @Test
    public void testSearchResultWithWordPresentWhereTagField() {
        c.getContactList().add(p);
        List<Profile> testlist = null;
        try {
            testlist = c.searchResult("Squamish");
        } catch (EmptyStringException e) {
            fail("We shouldn't get an exception for the purpose of this test");
        }
        assertEquals(testlist.get(0).getWhereTag().getTagItem(0), "Squamish");
    }

    @Test
    public void testSearchResultWithWordPresentDescriptionField() {
        c.getContactList().add(p);
        List<Profile> testlist = null;
        try {
            testlist = c.searchResult("tall");
        } catch (EmptyStringException e) {
            fail("We shouldn't get an exception for the purpose of this test");
        }
        assertEquals(testlist.get(0).getDescription(), "tall");
    }

    @Test
    public void testSearchResultWithWordPresentNameField() {
        c.getContactList().add(p);
        List<Profile> testlist = null;
        try {
            testlist = c.searchResult("Bill");
        } catch (EmptyStringException e) {
            fail("We shouldn't get an exception for the purpose of this test");
        }
        assertEquals(testlist.get(0).getName(), "Bill");
    }

    @Test
    public void testSearchResultWithoutPresent() {
        c.getContactList().add(p);
        try {
            assertTrue(c.searchResult("2013").isEmpty());
        } catch (EmptyStringException e) {
            fail("We shouldn't get an exception for the purpose of this test");
        }
    }

    @Test
    public void testOverrideEqualsObjectsEqual(){
        ContactList l1 = new ContactList();
        ContactList l2 = new ContactList();
        l1.add(p);
        l2.add(p);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testOverrideEqualsObjectsNotEqual() {
        ContactList l1 = new ContactList();
        ContactList l2 = new ContactList();
        l1.add(p);
        l2.add(p);
        l2.add(p);
        assertFalse(l1.equals(l2));
    }

    @Test
    public void testOverrideEqualsSameObject(){
        ContactList l1 = new ContactList();
        l1.add(p);
        assertTrue(l1.equals(l1));
    }

    @Test
    public void testOverrideEqualsDifferentType(){
        ContactList l1 = new ContactList();
        assertFalse(l1.equals(p));
    }

    @Test
    public void testOverrideEqualsNullObject(){
        ContactList l1 = new ContactList();
        ContactList l2 = null;
        assertFalse(l1.equals(l2));
    }
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

//    private Name b = new Name("Bill");
//    private Description t = new Description("tall");
//    private WhereTagList s = new WhereTagList("@Squamish");
//    private ConnectTagList two = new ConnectTagList("@2012");