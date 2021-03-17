public  class Book {
    private String title;
    private String author;
    private double hardPrice;
    private double ePrice;
    private int stock;
    private boolean eBook;

    public Book(String title, String author, double price, double ePrice, int stock, boolean eBook){
        this.title=title;
        this.author = author;
        this.hardPrice = price;
        this.ePrice = ePrice;
        this.stock= stock;
        this.eBook = eBook;
    }

    public String getTitle(){
        return this.title;
    }
    public String getAuthor(){
        return this.author;
    }
    public double getHardPrice(){ //return the price for a physical copy of the book
        return this.hardPrice;
    }
    public double getEPrice(){ // return the price for the digital copy of the book 
        return this.ePrice;
    }
    public int getStock(){
        return this.stock;
    }
    public void reduceStock(){
        this.stock= this.stock-1;
    }
    public void addStock(){
        this.stock= this.stock+1;
    }

    public boolean isDigital(){
        return this.eBook;
    }

}