import BinaryTree.BinarySearchTree.BSearchTreeType;
import BinaryTree.BinarySearchTree.Book;
import java.util.Scanner;

public class BookStore {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        BSearchTreeType Library = new BSearchTreeType();

        loadSampleBooks(Library);

        int choice = 0;

        while (choice != 10) {

            System.out.println("\n===== BOOKSTORE MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book by ISBN");
            System.out.println("3. Display All Books");
            System.out.println("4. Analyze Sales");
            System.out.println("5. Delete Book by ISBN");
            System.out.println("6. Analyze Stock (Low Quantity)");
            System.out.println("7. Restock All Books (Qty = 3)");
            System.out.println("8. Update Book Quantity (Manual Adjust)");
            System.out.println("9. Buy Book");
            System.out.println("10. Exit");
            System.out.print("Enter your choice (Example: 1): ");

            choice = input.nextInt();
            input.nextLine(); 

            if (choice == 1) {

                System.out.println("\n=== ADDING A BOOK ===");

                System.out.print("Enter Title (Example: Harry Potter): ");
                String title = input.nextLine();

                System.out.print("Enter Author (Example: J.K. Rowling): ");
                String author = input.nextLine();

                System.out.print("Enter Genre (Example: Fantasy): ");
                String genre = input.nextLine();

                System.out.print("Enter ISBN (Example: 978-3-16-148410-0): ");
                String isbn = input.nextLine();

                System.out.print("Enter Quantity (Example: 5): ");
                int qty = input.nextInt();
                input.nextLine();

                Book newBook = new Book(title, author, genre, isbn, qty);
                Library.insert(newBook);

                System.out.println("\nBook added successfully!");

            } else if (choice == 2) {

                System.out.println("\n=== SEARCH BY ISBN ===");
                System.out.print("Enter ISBN (Example: 978-3-16-148410-0): ");
                String searchIsbn = input.nextLine();

                System.out.println(Library.search(searchIsbn));

            } else if (choice == 3) {

                System.out.println("\n=== ALL BOOKS IN LIBRARY ===");
                Library.printAllBooks();

            } else if (choice == 4) {

                System.out.println("\n=== ALL BOOK SALES ===");
                Library.printAllSales();

            } else if (choice == 5) {

                System.out.println("\n=== DELETE BOOK BY ISBN ===");
                System.out.print("Enter ISBN of the book to delete: ");
                String deleteIsbn = input.nextLine();

                Library.deleteNode(deleteIsbn);
                System.out.println("Delete operation requested. If the ISBN was found, the book was removed.");

            } else if (choice == 6) {

                System.out.println("\n=== LOW STOCK (QTY < 3) ===");
                Library.analyzeStock();

            } else if (choice == 7) {

                System.out.println("\n=== RESTOCKING ALL BOOKS ===");
                Library.restock();
                System.out.println("All books have been restocked to quantity = 3.");

            } else if (choice == 8) {

                System.out.println("\n=== UPDATE BOOK QUANTITY ===");
                System.out.print("Enter ISBN: ");
                String isbn = input.nextLine();

                System.out.print("Enter quantity change (negative = reduce stock, positive = add stock): ");
                int changeAmount = input.nextInt();
                input.nextLine();

                Library.updateQuantity(isbn, changeAmount);

            } else if (choice == 9) {

                System.out.println("\n=== BUY BOOK ===");
                System.out.print("Enter ISBN: ");
                String isbn = input.nextLine();

                System.out.print("Enter quantity to buy: ");
                int amount = input.nextInt();
                input.nextLine();

                Library.buyBook(isbn, amount);

            } else if (choice == 10) {

                System.out.println("\nExiting program...");

            } else {

                System.out.println("\nInvalid choice. Please enter a number between 1 and 10.");
            }
        }

        input.close();
    }
    
    public static void loadSampleBooks(BSearchTreeType Library) {

        Book[] sampleBooks = {

            new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", "978-0-06-112008-4", 5),
            new Book("1984", "George Orwell", "Dystopian", "978-0-452-28423-4", 8),
            new Book("The Great Gatsby", "F. Scott Fitzgerald", "Classic", "978-0-7432-7356-5", 4),
            new Book("The Catcher in the Rye", "J.D. Salinger", "Classic", "978-0-316-76948-0", 6),
            new Book("Pride and Prejudice", "Jane Austen", "Romance", "978-0-19-953556-9", 7),
            new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", "978-0-618-00221-3", 10),
            new Book("The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", "978-0-618-00222-0", 12),
            new Book("Fahrenheit 451", "Ray Bradbury", "Dystopian", "978-1-4516-7331-9", 3),
            new Book("Moby Dick", "Herman Melville", "Adventure", "978-0-14-243724-7", 2),
            new Book("Brave New World", "Aldous Huxley", "Dystopian", "978-0-06-085052-4", 9),

            new Book("The Hunger Games", "Suzanne Collins", "Dystopian", "978-0-439-02348-1", 15),
            new Book("Catching Fire", "Suzanne Collins", "Dystopian", "978-0-439-02349-8", 13),
            new Book("Mockingjay", "Suzanne Collins", "Dystopian", "978-0-439-02350-4", 11),

            new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy", "978-0-590-35340-3", 20),
            new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", "Fantasy", "978-0-439-06486-6", 18),
            new Book("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", "Fantasy", "978-0-439-13635-8", 16),
            new Book("Harry Potter and the Goblet of Fire", "J.K. Rowling", "Fantasy", "978-0-439-13959-5", 14),

            new Book("The Da Vinci Code", "Dan Brown", "Thriller", "978-0-385-50420-8", 9),
            new Book("Angels & Demons", "Dan Brown", "Thriller", "978-0-7432-7506-4", 7),

            new Book("The Alchemist", "Paulo Coelho", "Fiction", "978-0-06-112241-5", 12),
            new Book("The Fault in Our Stars", "John Green", "Romance", "978-0-525-47881-2", 8),
            new Book("The Maze Runner", "James Dashner", "Dystopian", "978-0-385-73794-1", 10),

            new Book("Dune", "Frank Herbert", "Science Fiction", "978-0-441-17271-9", 6),
            new Book("Ender's Game", "Orson Scott Card", "Science Fiction", "978-0-8125-5070-2", 5),
            new Book("The Martian", "Andy Weir", "Science Fiction", "978-0-8041-3902-1", 9),

            new Book("The Shining", "Stephen King", "Horror", "978-0-385-12167-3", 7),
            new Book("It", "Stephen King", "Horror", "978-1-5011-7681-9", 6),
            new Book("Carrie", "Stephen King", "Horror", "978-0-307-74374-2", 4),

            new Book("The Road", "Cormac McCarthy", "Post-Apocalyptic", "978-0-307-38789-3", 5),
            new Book("Life of Pi", "Yann Martel", "Adventure", "978-0-15-602732-8", 6),
            new Book("The Giver", "Lois Lowry", "Dystopian", "978-0-547-99566-3", 10),

            new Book("The Outsiders", "S.E. Hinton", "Fiction", "978-0-14-038572-4", 8),
            new Book("The Book Thief", "Markus Zusak", "Historical", "978-0-375-84220-7", 9),

            new Book("Twilight", "Stephenie Meyer", "Romance", "978-0-316-01584-6", 14),
            new Book("New Moon", "Stephenie Meyer", "Romance", "978-0-316-16039-3", 13),
            new Book("Eclipse", "Stephenie Meyer", "Romance", "978-0-316-16041-6", 12),

            new Book("The Girl with the Dragon Tattoo", "Stieg Larsson", "Thriller", "978-0-307-45454-4", 6),
            new Book("Gone Girl", "Gillian Flynn", "Thriller", "978-0-307-58836-2", 8),

            new Book("The Sun Also Rises", "Ernest Hemingway", "Classic", "978-0-7432-9733-2", 4),
            new Book("Don Quixote", "Miguel de Cervantes", "Classic", "978-0-06-093434-7", 5),
            new Book("War and Peace", "Leo Tolstoy", "Classic", "978-0-14-303999-0", 3),

            new Book("The Little Prince", "Antoine de Saint-Exupéry", "Children", "978-0-15-601219-5", 10),
            new Book("Charlotte's Web", "E.B. White", "Children", "978-0-06-440055-8", 9),
            new Book("Matilda", "Roald Dahl", "Children", "978-0-14-241037-0", 7),

            new Book("The Kite Runner", "Khaled Hosseini", "Drama", "978-1-59448-000-3", 11),
            new Book("A Thousand Splendid Suns", "Khaled Hosseini", "Drama", "978-1-59448-385-1", 8)
        };

        for (Book b : sampleBooks) {
            Library.insert(b);
        }
    }
}
