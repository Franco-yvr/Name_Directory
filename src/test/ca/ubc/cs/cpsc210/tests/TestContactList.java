package ca.ubc.cs.cpsc210.tests;

import ca.ubc.cs.cpsc210.List.ContactList;
import ca.ubc.cs.cpsc210.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestContactList {

    private Name b = new Name("Bill");
    private Description t = new Description("tall");
    private WhereTag s = new WhereTag("@Squamish");
    private ConnectTag two = new ConnectTag("@2012");
    public Profile p = new Profile("Bill", "tall", "@Squamish", "@2012");
    ContactList c = new ContactList();


    @Test
    public void testContactListConstructor() {
        assertTrue(c.getContactList().isEmpty());
    }

    @Test
    public void TestAdd() {
        c.getContactList().add(p);
        assertEquals(c.getContact(0), p);
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

    @Test
    public void TestAddContactWithoutName() {
        assertFalse(c.addContact("", "tall", "@Squamish", "@2012"));
        assertTrue(c.getContactList().isEmpty());
    }

    @Test
    public void TestAddContactWithName() {
        assertTrue(c.addContact("Bill", "tall", "@Squamish", "@2012"));
        assertEquals(c.getContact(0).getName().getName(), "Bill");
        assertEquals(c.getContact(0).getDescription().getDescription(), "tall");
        assertEquals(c.getContact(0).getWhereTag().getTagItem(0), "Squamish");
        assertEquals(c.getContact(0).getConnectTag().getTagItem(0), "2012");
    }

    @Test
    public void TestSearchResultWithWordPresent() {
        c.getContactList().add(p);
        assertEquals(c.searchResult("Bill").get(0).getName().getName(), "Bill");
    }
}
