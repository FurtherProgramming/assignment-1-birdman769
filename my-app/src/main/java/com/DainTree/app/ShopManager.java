
package com.DainTree.app;
import java.util.Scanner; 
import java.util.ArrayList; // import the ArrayList class

public class ShopManager {
    ArrayList<Book> bookList = new ArrayList<Book>(); //an array of all purchasable books
    ArrayList<Cart> customerCart = new ArrayList<Cart>(); // an array of the books our customer wishes to purchase. 
    private String userInput= " ";
    private String loopControl = "0"; //we will use a boolean to control our master loop as we can use the .equals() string comparitor to check user input for an exit
    private boolean control = false;
    private Scanner myScanner = new Scanner(System.in);  // Create a Scanner object
    private int userInputAsInt; //for when we convert our user input to an integer due to our search method returning varied length lists. 
    private double totalCost;

    //private methods
    private void options(){
        System.out.println("Choose an option:\n1.Add a book to shopping cart\n2.View shopping cart\n3.Remove a book from shopping cart\n4.Checkout\n5.List all books\n0.Quit\nPlease make a  selection");    
    }
    private String displayBookDetails(Book b){
        String display = b.getTitle() + " AUTHOR: "+ b.getAuthor() +" STOCK:"+ b.getStock() + " is eBook: " + b.isDigital();
        return display;
        
    }
    private void addBookToCart(){
        ArrayList<Book> searchList = new ArrayList<Book>(); 
        boolean isEBook = false;
        int localStock =0;
        //boolean canBuy = true;
        int bookIndex =0;
        System.out.println("Enter title to search for: ");
        userInput = myScanner.nextLine().toLowerCase();
        // compare our user input against the titles inside our booklist array
        for (int c = 0; c < bookList.size(); c++) { 	
            String target= bookList.get(c).getTitle().toLowerCase(); 
            target = target.substring(0, userInput.length());
            //if our search entry matches the leading same length characters of our title it will add the book object to our search list array. 
            if(userInput.equals(target))
                searchList.add(bookList.get(c));  
        } 
        if(searchList.size()== 0)
        System.out.println("no matching results!"); 
        else{
            System.out.println("matching results:");
            for(int c= 0 ; c< searchList.size(); c++){
                Book currentBook = searchList.get(c);
                System.out.println(c+1 + " " +displayBookDetails(currentBook));
            }
        }
        System.out.println("0.Quit");
        control = false;
        //here we have a list that varies in potentially returned amount of search results so we will use integers as input from the user(.equals would be harder to implement). and then we can use this to move our correct book title into our shopping cart
        while (control == false){
            System.out.println("select which book you wish to add to cart: \n");
            
            userInputAsInt= catchIntFromInput();
            if(userInputAsInt >0 && userInputAsInt <= searchList.size()){ //add selection to the cart
            int repeats =0;
                if(customerCart.size() != 0){
                    for( int c=0; c < customerCart.size(); c++){
                        if(searchList.get(userInputAsInt-1).getTitle().equals(customerCart.get(c).getCartBook().getTitle())){
                            System.out.println("item exists in cart");
                            repeats++;
                        }
                    }   
                }
                if( repeats == 0){
                    isEBook = searchList.get(userInputAsInt-1).isDigital();
                    localStock = searchList.get(userInputAsInt-1).getStock();
                    System.out.println("do you wish to purchase this as an e book? (yes/no): ");
                        while (!(userInput.equals("yes") || userInput.equals("no"))){
                            userInput= myScanner.nextLine();
                            if(userInput.equals("yes"))
                                if(searchList.get(userInputAsInt-1).isDigital()){
                                    customerCart.add(new Cart(searchList.get(userInputAsInt-1), true));
                                    System.out.println("digital available");
                                }else{
                                    System.out.println("no digital copy available!");
                                }
                            if(userInput.equals("no"))
                                if(searchList.get(userInputAsInt-1).getStock() != 0){
                                    System.out.println("item available as hard copy");
                                    customerCart.add(new Cart(searchList.get(userInputAsInt-1), false));
                                    reduceStock(searchList.get(userInputAsInt-1));

                                }else{
                                    System.out.println("out of stock!");
                                }
                        }
                    }
                
                control = true;
                
            }
            else if(userInputAsInt == 0){ //exit this current menu
                control = true;
            }
            else{
                System.out.println("not a valid selection!");
            }
        }
        control = false; // we use control for the logic of our while loops. must be reset after exiting a while loop. 
   
    }
    private int catchIntFromInput(){ //as we reuse this code a bit It has been seperated as a method
        boolean catchControl = false;
            while(catchControl == false){
                try{
                    userInput = myScanner.nextLine();
                    userInputAsInt = Integer.parseInt(userInput);
                    catchControl =true;
                }
                catch(Exception e){
                    System.out.println("integer only!");
                }
            }
            return userInputAsInt;
    }

    private void displayShoppingCart(){
        System.out.println("SHOPPING CART:");
        if (customerCart.size() == 0)
            System.out.println("EMPTY");
         for (int c= 0 ; c < customerCart.size(); c++){
                    Book localBook = customerCart.get(c).getCartBook();
                    System.out.println(localBook.getTitle() + " ---AUTHOR: "+ localBook.getAuthor() + "---  eBook: " + customerCart.get(c).userWantsEBook()); //we could use the displaybookdetails() here but it is strange to show stock levels to customer in personal shopping list. 
                }

    }
    private void reduceStock(Book b){
        for (int c =0; c< bookList.size(); c++){
            if (bookList.get(c).getTitle().equals(b.getTitle())) 
                bookList.get(c).reduceStock();
        }

    }
    private void increaseStock(Book b){
        for (int c =0; c< bookList.size(); c++){
            if (bookList.get(c).getTitle().equals(b.getTitle())) 
                bookList.get(c).addStock();
        }

    }
    private void displayAllBooks(){
        System.out.println("ALL BOOKS: ");
        for (int c= 0 ; c < bookList.size(); c++){
                    Book localBook = bookList.get(c);
                   
                     System.out.println( displayBookDetails(localBook));
                    
                }

    }
    private void removeAbook(){

        control= false; 
        while (control == false){
            System.out.println("choose a book to remove: ");
            for( int c=0; c < customerCart.size(); c++){
                System.out.println(c+1 + "."+ customerCart.get(c).getCartBook().getTitle());
            }  
            userInputAsInt=catchIntFromInput();
            if(userInputAsInt >0 && userInputAsInt <= customerCart.size()){
                increaseStock(customerCart.get(userInputAsInt-1).getCartBook());

                customerCart.remove(userInputAsInt-1);
                control =true;
                System.out.println("removed!");
            }
        }
        control =false; // otherwise true carries over to runSession while loop and exits program
        
            
        
    }
    private void checkout(){
        System.out.println("number of items: "+ customerCart.size());
        for (int c =0; c < customerCart.size(); c++){
            Book localBook = customerCart.get(c).getCartBook();
            System.out.println(c);
            if(customerCart.get(c).userWantsEBook()==true){
                totalCost += localBook.getEPrice();
                
            }else{
                totalCost += localBook.getHardPrice();
               
            }
            
        }
        System.out.println("Checkout complete- items total value is: $"+totalCost);
        totalCost =0;


    }
    //public methods
    public void addBook(String title, String author, double price, double ePrice, int stock, boolean isEbook){
         bookList.add(new Book(title,author,price,ePrice, stock, isEbook));
         return;
    }
    public void runSession(){
        System.out.println("Welcome to the DainTree book shop");
        

        while(control == false){
            System.out.println(" "); //spacer
            this.options(); //display our options for the user. 
            userInput = myScanner.nextLine();  // Read user input
            control= userInput.equals(loopControl);
            if(userInput.equals("1"))
                addBookToCart();
            else if(userInput.equals("2"))
                displayShoppingCart();
            else if(userInput.equals("3"))
                removeAbook();
            else if(userInput.equals("4"))
                checkout();
            else if(userInput.equals("5"))
                displayAllBooks();
            else
                if (!userInput.equals(loopControl))
                    System.out.println("Invalid Option");
            


        }
    System.out.println("goodbye!");
    myScanner.close();

    

    
    }
    
}