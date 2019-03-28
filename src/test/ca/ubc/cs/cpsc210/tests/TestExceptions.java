package ca.ubc.cs.cpsc210.tests;

import ca.ubc.cs.cpsc210.model.ContactList;
import ca.ubc.cs.cpsc210.model.Profile;
import ca.ubc.cs.cpsc210.model.exceptions.EmptyStringException;
import ca.ubc.cs.cpsc210.model.exceptions.NameFieldEmptyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestExceptions {

    private boolean testboolean = false;
    private ContactList testcontactlist = new ContactList();
    private Profile testprofile;

    @BeforeEach
    void setup() {
        try {
            testprofile = new Profile("Bill", "General manager", "@Vancouver", "@notrequired");
        } catch (NameFieldEmptyException e) {
            fail("We shouldn't get an exception for the purpose of this test");
        }
        testcontactlist.add(testprofile);
    }

    @Test
    public void TestEmptyStringExceptionWithEmptyString() {
        try {
            testcontactlist.searchResult("");
            fail("EmptyStringException should have been thrown");
        } catch (EmptyStringException e) {
            testboolean = true;
        }
        assertTrue(testboolean);
    }

    @Test
    public void TestEmptyStringExceptionWithStringProvided() {
        try {
            testcontactlist.searchResult("Bill");
            testboolean = true;
        } catch (EmptyStringException e) {
            fail("EmptyStringException should NOT have been thrown");
        }
        assertTrue(testboolean);
    }

    @Test
    public void NameFieldEmptyExceptionWithEmptyName() {
        try {
            Profile p2 = new Profile("", "Associate manager", "@Colorado", "@Jan2020");
            fail("NameFieldEmptyException should have been thrown");
        } catch (NameFieldEmptyException e) {
            testboolean = true;
        }
        assertTrue(testboolean);
    }

    @Test
    public void NameFieldEmptyExceptionWithNameProvided() {
        try {
            Profile p2 = new Profile("Bill", "Associate manager", "@Colorado", "@Jan2020");
            testboolean = true;
        } catch (NameFieldEmptyException e) {
            fail("NameFieldEmptyException should NOT have been thrown");
        }
        assertTrue(testboolean);
    }
}
