### Phase 1 Feedback

#### General Comments
- Looks like an interesting project.  You're off to a good start.
However, there are some things to watch for and to correct, as noted below.

#### Checkstyle
- passes :-) 

#### Code coverage
- 97.8% - very good!

#### Tests
- all tests pass :-)


#### Documentation
- you need to be more careful with your documentation.  You have a number
of getter methods that are incorrectly documented as "MODIFIES: this"
(e.g. ContactList.getContact()). Please be sure to fix these before submitting your code for the next
phase of the project.

DONE

- in some places you've added REQUIRES clauses that are not needed, 
e.g. Tag.searchTag - this method works exactly as specified, even if
you remove the REQUIRES clause.   

DONE

#### Implementation
Note that a number of your classes have (non-constant) fields that are public.
Be sure to keep implementation details private so that code external to the
class cannot access them directly.  This will allow you to change your
implementation at some point in the future without impacting code outside
of the class (assuming that the signatures of your public methods do not
change).

DONE

Be more careful to choose method names that describe what the method
 does.  For example, `ContactList.getContactList()` is a bit confusing.  Think about
the context in which this method will be used:

DONE

```java
ContactList myContactList = new ContactList();
// so myContactList refers to a ContactList

myContactList.getContactList();  
// not clear what we're getting here, given that myContactList already
// refers to a ContactList object
```
DONE

In this case, it's probably more appropriate to name the method
`ContactList.getContacts()`  Similarly, your `Tag` class has a method 
named `getTag()` (which in fact returns a list of strings, so the 
method name does not seem appropriate.)
       
Note that your `Name` and `Description` classes are not really needed. 
The name and description could simply be represented as fields of type
String in the `Profile` class.

DONE


                         