public class Book extends Product {
    private String nameBook;
    private String author;

    public Book(int id, String name, int price, String nameBook, String author) {
        super(id, name, price);
        this.nameBook = nameBook;
        this.author = author;
    }
}