
public class Book {
    private Author author;
    private String title;
    private int year;
    private String publisher;
    private String genre;
    private double rating;
    private double price;
    //ALTERED HERE
    private int bookAmount;

    //Default constructors to initialize default values
    public Book() {
        this.author = new Author();
        this.title = "";
        this.year = 0;
        this.publisher = "";
        this.genre = "";
        this.rating = 0.00;
        this.price = 0.00;
        //ALTERED HERE
        this.bookAmount = 0;
    }
    //Constructor to set values
    //ALTERED HERE
    public Book(Author author, String title, int year, String genre, String publisher, double rating, double price, int bookAmount) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.publisher = publisher;
        this.genre = genre;
        this.rating = rating;
        this.price = price;
        //ALTERED HERE
        this.bookAmount = bookAmount;
    }

    //Getters & Setters lines 38-92

//ALTERED HERE
    public int getBookAmount() {
        return bookAmount;
    }
//ALTERED HERE
    public void setBookAmount(int bookAmount) {
        this.bookAmount = bookAmount;
    }
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//ALTERED HERE
    public String toString(){
        String availabilityStatus;
        if (bookAmount == 0) {
            availabilityStatus = "Out of Stock";
        } else if (bookAmount < 20) {
            availabilityStatus = "Limited stock available";
        } else {
            availabilityStatus = "Available";
        }

        return "Title: " + title + " , Author: " + author + " , Year published: "  + year + ", Publisher: "
                + publisher + ", Genre: " + genre + ", Rating: " + rating + ", Price: " + price + ", Availability: " + availabilityStatus;
    }


}