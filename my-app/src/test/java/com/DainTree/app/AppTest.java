package com.DainTree.app;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;
import org.junit.Test;

public class AppTest 
{
    Book book = new Book("testTitle","testAuthor",50.00,8.00,5, true);  //our test case book. 
    
    @Test
    public void testBook() //test that our getters for our book objects are working 
    {   
        assertEquals("testTitle", book.getTitle());
        assertEquals("testAuthor", book.getAuthor());
        assertEquals(50.00, book.getHardPrice(), 0.001);
        assertEquals(8.00, book.getEPrice(), 0.001);
        assertEquals(5, book.getStock());
        assertEquals(true, book.isDigital());
    }
    
    @Test
    public void testStockChange() { //test our getters/setters for book stock
        book.addStock();
        book.reduceStock();
        assertEquals(5, book.getStock());
        
    }
    @Test
    public void cartTest(){ //test cart object functionality. 
        Cart testCart = new Cart(book, true);
        assertEquals(book, testCart.getCartBook());
        assertEquals(true, testCart.userWantsEBook());
    }

    //I was unable to simulate console user input into the runSession() method to further test my program. 
}