package BinaryTree.BinarySearchTree;

public class Book{
    private String title;
    private String author;
    private String genre;
    private String isbn;
    private int quantity;

    public Book(String title, String author, String genre, String isbn, int quantity){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    public String getTitle()   { return title; }
    public String getAuthor()  { return author; }
    public String getGenre()   { return genre; }
    public String getIsbn()    { return isbn; }
    public int getQuantity()   { return quantity; }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Title: " + title +
               ", Author: " + author +
               ", Genre: " + genre +
               ", Quantity: " + quantity +
               ", ISBN: " + isbn;
    }

}
