
package com.DainTree.app;
import java.util.Scanner; 
import java.util.ArrayList; // import the ArrayList class

public class App 
{
    public static void main( String[] args )
    {
        BookStore bookStore = new BookStore(); //create our shop

        //our test case books
        bookStore.addBook("Absolute Java","Savitch",50.00,8.00,5, true);
        bookStore.addBook("JAVA: How To Program","Deitel and Deitel",50.00,8.00,0, true);
        bookStore.addBook("Computing Concepts with JAVA 8 Essentials","Horstman",50.00,8.00,5, false);
        bookStore.addBook("Java Software Solutions","Lewis and Loftus",50.00,8.00,5, false);
        bookStore.addBook("Java Program Design","Cohoon and Davidson",50.00,8.00,1, true);
        bookStore.runSession(); //run our shop session 

    }
}





