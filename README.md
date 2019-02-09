
Requirements:
1-	The interface #1 displays a “Name”, “Description”, “Where Tags” and “Reconnect Tags” text fields.
2-	The interface #1 displays an “Interface#2” button at the top of the screen.
3-	The interface #1 displays a “Save” button at the bottom of the screen.
4-	The interface #2 displays “Search” and “Result” text fields.
5-	The “Result” text field displays 4 columns representing the “Name”, “Description”, “Where Tags” and “Reconnect Tags” for each result.
6-	The interface #2 displays an “Interface#1” button at the top of the screen.

Functionalities:
Interface #1
1-	When the user runs the application, the application presents the interface #1 by default.
2-	When the user clicks on any text field, the application displays a cursor.
3-	When the user types on the keyboard, the application displays the typed text.
4-	When the user clicks the “Save” button,
-	the application creates a new object containing a field for each “Name”, “Description”, “Where Tags”, “Reconnect Tags”
-	the application adds the object to a list
-	the application resets the “Interface#1” to ready for a new entry
-	the application displays text “The profile has been created” at the bottom of the screen.
-	*Note: At the trigger of the “save” button, the application saves the data in such manner that when the application is shut down and re-started, the data can be completely restored. In this case a JSON file will be used.
5-	When the user clicks the “Interface#2” button, the application displays “Interface#2”.

Interface#2aaa
1-	When the user clicks on the “Search” text field, the application displays the cursor.
2-	When the user types on the keyboard, the application displays the typed text.
3-	When the user presses “Enter”,
-	the application searches the “Where Tags”, and “Reconnect Tags” fields for matching words in each object in the list
-	the application displays the results in alphabetical order of the result’s first name
-	the application displays “Displaying __ results” at the bottom of the screen
4-	When the user erases the “Search” text field, types a new entry, then presses enter, the application proceeds with the new search.
5-	When the user clicks on “Interface#1” button, the application returns the “Interface#1”.


Part1 Structure & implementation