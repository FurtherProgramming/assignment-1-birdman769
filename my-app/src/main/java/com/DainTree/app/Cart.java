package com.DainTree.app;
public class Cart{
    private Book book;
    private boolean asEBook;

    public Cart(Book book, boolean asEBook){
        this.book= book;
        this.asEBook=asEBook;

    }
    public Book getCartBook(){
        return this.book;
    }
    public boolean userWantsEBook(){
        return this.asEBook;
    }
}