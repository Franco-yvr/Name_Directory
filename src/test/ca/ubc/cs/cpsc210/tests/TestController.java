//package ca.ubc.cs.cpsc210.tests;
//
//import ca.ubc.cs.cpsc210.controller.*;
//import ca.ubc.cs.cpsc210.model.*;
//import ca.ubc.cs.cpsc210.model.exceptions.NameFieldEmptyException;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//public class TestController {
//
//    Profile testprofile;
//    Profile testprofile2;
//    private ContactList originalcontactlist;
//
//    @BeforeEach
//    void setup() {
//        try {
//            testprofile = new Profile("Bill", "tall", "@Squamish", "@2012");
//            testprofile2 = new Profile("John", "short", "@Kamloops", "@2011");
//        } catch (NameFieldEmptyException e) {
//            e.printStackTrace();
//        }
//        originalcontactlist.add(testprofile);
//    }
//
//    @Test
//    public void testController(){
////        Told by 2 TAs at 7h15pm on March 26 2019 that controller Class and anything to do with UI
////        is not necessary to test due to the difficulty of working around textfields and database,
////        especilly that it is very visible whether a functionality works or not
//    }
//
//    @Test
//    public void testSaveButton(){
////        Told by 2 TAs at 7h15pm on March 26 2019 that controller Class and anything to do with UI
////        is not necessary to test due to the difficulty of working around textfields and database,
////        especilly that it is very visible whether a functionality works or not
//    }
//
//    @Test
//    public void testSearchButton(){
////        Told by 2 TAs at 7h15pm on March 26 2019 that controller Class and anything to do with UI
////        is not necessary to test due to the difficulty of working around textfields and database,
////        especilly that it is very visible whether a functionality works or not
//    }
//
//        @Test
//    public void testDisplayTable(){
////        Told by 2 TAs at 7h15pm on March 26 2019 that controller Class and anything to do with UI
////        is not necessary to test due to the difficulty of working around textfields and database,
////        especilly that it is very visible whether a functionality works or not
//    }
//}