package com.DainTree.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testBook() //test that our getters for our book objects are working 
    {   Book book = new Book("testTitle","testAuthor",50.00,8.00, 5, true);
        assertEquals("testTitle", book.getTitle());
        assertEquals("testAuthor", book.getAuthor());
        assertEquals(50.00, book.getHardPrice(), 0.001);
        assertEquals(8.00, book.getEPrice(), 0.001);
        assertEquals(5, book.getStock());
        assertEquals(true, book.isDigital());
    }
    @Test
     public void dummy()
    {   
        
        assertEquals(5, 5);
    }
}
