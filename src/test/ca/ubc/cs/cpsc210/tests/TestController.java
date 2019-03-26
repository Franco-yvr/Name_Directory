package ca.ubc.cs.cpsc210.tests;

import ca.ubc.cs.cpsc210.controller.*;
import ca.ubc.cs.cpsc210.model.*;
import ca.ubc.cs.cpsc210.model.exceptions.NameFieldEmptyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestController {

    Profile testprofile;
    Profile testprofile2;
    private ContactList originalcontactlist;

    @BeforeEach
    void setup() {
        try {
            testprofile = new Profile("Bill", "tall", "@Squamish", "@2012");
            testprofile2 = new Profile("John", "short", "@Kamloops", "@2011");
        } catch (NameFieldEmptyException e) {
            e.printStackTrace();
        }
        originalcontactlist.add(testprofile);
        originalcontactlist.add(testprofile2);
    }

    @Test
    public void testController(){
//        Controller

    }

    @Test
    public void testSaveButton(){

    }

    @Test
    public void testSearchButton(){

    }

        @Test
    public void testDisplayTable(){

    }
}
