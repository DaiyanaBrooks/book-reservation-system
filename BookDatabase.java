
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class BookDatabase {
    private ArrayList<Book> books;
    public BookDatabase(){
        this.books = new ArrayList<>();
    }
    public BookDatabase (ArrayList<Book> books) {
        this.books = books;
    }

    //this function adds and removes books
    public void addBook(Book book){
        books.add(book);
    }
    public void removeBook(Book book){
        books.remove(book);
    }

    public void reserve(Book book){
        if (books.contains(book)){
            if (book.getBookAmount() > 0) {
                int currAmount = book.getBookAmount();
                book.setBookAmount(currAmount - 1);
                System.out.println("Your book has been reserved successfully!");
            }
            else {
                System.out.println("Sorry, this book is currently unavailable to reserve.");
            }
        } else {
            System.out.println("Sorry, we do not currently have possession of your desired spellbook.");
        }
    }


    //Searches for books by using specific criterias
    public ArrayList<Book> search(Author author){
        ArrayList<Book> authorSearchBooks = new ArrayList<Book>();
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getAuthor().getFirstName().equals(author.getFirstName()) && books.get(i).getAuthor().getLastName().equals(author.getLastName()) ){
                authorSearchBooks.add(books.get(i));
            }
        }
        return authorSearchBooks;
    }

    public ArrayList<Book> suggestRelatedBooks(Book targetBook, int numSuggestions) {
        ArrayList<Book> suggestedBooks = new ArrayList<>();

        Map<Book, Double> similarityScores = new HashMap<>();
        for (Book book : books) {
            if (!book.equals(targetBook)) {
                double similarity = calculateGenreSimilarity(targetBook, book);
                similarityScores.put(book, similarity);
            }
        }

        List<Map.Entry<Book, Double>> sortedBooks = new ArrayList<>(similarityScores.entrySet());
        sortedBooks.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (int i = 0; i < numSuggestions && i < sortedBooks.size(); i++) {
            suggestedBooks.add(sortedBooks.get(i).getKey());
        }

        return suggestedBooks;
    }

    private double calculateGenreSimilarity(Book book1, Book book2) {
        Set<String> genre1 = new HashSet<>(Arrays.asList(book1.getGenre().split(",")));
        Set<String> genre2 = new HashSet<>(Arrays.asList(book2.getGenre().split(",")));
        Set<String> intersection = new HashSet<>(genre1);
        intersection.retainAll(genre2);
        Set<String> union = new HashSet<>(genre1);
        union.addAll(genre2);

        return (double) intersection.size() / union.size();
    }
}


    public ArrayList<Book> search(int startYear, int endYear){
        ArrayList<Book> years = new ArrayList<Book>();
        for (Book book : this.books){
            if (book.getYear() >= startYear && book.getYear() <= endYear ){
                years.add(book);
            }
        }
        return years;
    }

    public ArrayList<Book> search(String genre) {
        ArrayList<Book> result = new ArrayList<Book>();
        for(int i = 0; i < books.size(); i++){

            if (this.books.get(i).getGenre().equalsIgnoreCase(genre)){

                result.add(this.books.get(i));
            }
        }
        return result;
    }


    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public String toString(){
        String bookSummaries = "";

        for (int i = 0; i < books.size(); i++){
            bookSummaries += (books.get(i).getAuthor() + " \n");
            bookSummaries += ("Book Name: " + books.get(i).getTitle() + " \n");
            bookSummaries += ("Year Published: " + books.get(i).getYear() + " \n");
            bookSummaries += ("Published By: " + books.get(i).getPublisher()+ " \n");
            bookSummaries += ("Genre: " + books.get(i).getGenre() + " \n");
            bookSummaries += ("Rating: " + books.get(i).getRating() + " \n");
            bookSummaries += ("Price: " + books.get(i).getPrice() + " \n\n");
        }

        return bookSummaries;



    }


}
