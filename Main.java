import java.util.ArrayList; 
public class Main {

    public static void main(String[] args) {

        ShopManager bookShop = new ShopManager(); //create our shop

        //our test case books
        bookShop.addBook("Absolute Java","Savitch",50.00,8.00,5, true);
        bookShop.addBook("JAVA: How To Program","Deitel and Deitel",50.00,8.00,0, true);
        bookShop.addBook("Computing Concepts with JAVA 8 Essentials","Horstman",50.00,8.00,5, false);
        bookShop.addBook("Java Software Solutions","Lewis and Loftus",50.00,8.00,5, false);
        bookShop.addBook("Java Program Design","Cohoon and Davidson",50.00,8.00,1, true);
        bookShop.runSession(); //run our shop session 

      


        
    }

}
