# Book Reservation System

This project is a **Book Reservation System** written in Java. It allows users to manage a collection of books, perform searches by author, genre, or year, and reserve books from the inventory.

## Features
- **Book Management**: Add, remove, and update book details such as author, title, year, genre, rating, price, and availability.
- **Book Reservation**: Reserve books if available in the inventory.
- **Book Search**: Search books by author, genre, or publication year.
- **Book Suggestions**: Suggest related books based on genre similarity.

## Classes

### `Book`
Represents a book in the system. It includes the following properties:
- `author`: The author of the book (represented by the `Author` class).
- `title`: The title of the book.
- `year`: The year the book was published.
- `publisher`: The publisher of the book.
- `genre`: The genre of the book.
- `rating`: The rating of the book.
- `price`: The price of the book.
- `bookAmount`: The number of copies available in the inventory.

### `Author`
Represents an author with:
- `firstName`: The author's first name.
- `lastName`: The author's last name.

### `BookDatabase`
Manages the collection of books. Includes methods for:
- Adding and removing books.
- Reserving books.
- Searching books by author, year, and genre.
- Suggesting related books based on genre similarity.

### `clientProgram`
Main program that:
- Loads books from a CSV file.
- Demonstrates the functionality of adding books, reserving books, and performing searches and suggestions.

## How to Run

1. **Compile the Java files**:
   ```bash
   javac *.java
   ```
2. Run the program with an input file path:
   ```bash
      java clientProgram
   ```
   If no file is provided, the program will prompt you to select one using JFileChooser.

## Example CSV Format
The input CSV file (dataset.csv) should be structured as follows:

| First Name | Last Name  | Title        | Year | Publisher | Genre             | Rating | Price | Book Amount |
|------------|------------|--------------|------|-----------|-------------------|--------|-------|-------------|
| John       | Doe        | Book Title 1 | 2020 | Publisher1| Fiction, Drama    | 4.5    | $12.99| 10          |
| Jane       | Smith      | Book Title 2 | 2018 | Publisher2| Non-fiction, History| 4.2  | $15.00| 5           |

Ensure that the CSV file is formatted correctly with columns representing:
Author's first name
Author's last name
Book title
Year of publication
Publisher Name
Book genre(s)
Rating
Price (including the $ symbol)
Book amount (available copies)

## Requirements
Java 8 or later
A CSV file with book data
