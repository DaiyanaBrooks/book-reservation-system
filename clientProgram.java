
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;



public class clientProgram {
    public static void main(String[] args){
        // I created a BookDatabase object to store books
        BookDatabase database = new BookDatabase();

        File file = new File("dataset.csv");

        try {
            Scanner scnr = new Scanner(file);
            // Skips the header line
            scnr.nextLine();

            // this loop reads each line from the file and adds books to the database
            while (scnr.hasNextLine()) {
                String line = scnr.nextLine();
                String[] values = line.split(",");

                String firstName = values[0].equals("None") ? "" : values[0];
                String lastName = values[1].equals("None") ? "" : values[1];
                Author author = new Author(firstName, lastName);
                String title = values[2];
                int yearPublished = Integer.parseInt(values[3]);
                String genre = values[5];
                String publisherName = values[4];
                double rating = Double.parseDouble(values[6]);
                double price = Double.parseDouble(values[7].substring(1));
                //ALTERED HERE
                int bookAmount = Integer.parseInt(values[8]);

                Book bookToReserve = database.getBooks().get(0); //new book is a placeholder
                database.reserve(bookToReserve);

//ALTERED HERE
                Book book = new Book(author, title, yearPublished, publisherName, genre, rating, price, bookAmount);
                database.addBook(book);

            }
            scnr.close();


            for (Book book : database.getBooks()) {
                System.out.println(book);
            }
            //Tests to see if the searches work properly
            System.out.println("Search for Author  - Test 1: Marie-Chantal Kalisa");
            Author authorTest = new Author("Marie-Chantal", " Kalisa");
            System.out.println(database.search(authorTest));

            System.out.println();
            System.out.println("Search for Genre - Test 2: Anthropology & Sociology");
            String genreSearchString = "Short Story Anthologies";
            System.out.println(database.search(genreSearchString));

            System.out.println();
            System.out.println("Search by Year - Test 3: 1999 - 2012");
            System.out.println(database.search(1999, 2012));

            System.out.println("\nSuggest related books based on genre - Test: Book 1");
            Book targetBook = database.getBooks().get(0);
            ArrayList<Book> suggestions = database.suggestRelatedBooks(targetBook, 3);
            System.out.println("Suggestions:");
            for (Book suggestion : suggestions) {
                System.out.println(suggestion);
            }



        }
        catch (FileNotFoundException e){
            // Prints stack trace just in case the file isn't found
            e.printStackTrace();
        }


    }
}
