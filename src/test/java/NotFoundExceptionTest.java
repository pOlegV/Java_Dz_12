import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NotFoundExceptionTest {
    private Repository repository = new Repository();
    private ProductManager manager = new ProductManager(repository);

    Product product1 = new Product(1, "Name1", 100);
    Product product2 = new Product(2, "Name2", 200);
    Product product3 = new Product(3, "Name3", 300);
    Product book1 = new Book(4, "Name4", 400, "Book1", "Author1");
    Product book2 = new Book(5, "Name4", 500, "Book2", "Author2");
    Product book3 = new Book(6, "Name4", 600, "Book3", "Author3");
    Product smart1 = new Smartphone(7, "Name5", 700, "Smartphone1", "manufacturer1");
    Product smart2 = new Smartphone(8, "Name5", 800, "Smartphone2", "manufacturer2");
    Product smart3 = new Smartphone(1, "Name5", 900, "Smartphone3", "manufacturer3");

    @Test
    void shouldRemoveByIdOne() {
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smart1);
        repository.save(smart2);

        repository.removeById(2);

        Product[] expected = {product1, product3, book1, book2, book3, smart1, smart2};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    void shouldRemoveByIdFoundException() {
        repository.save(product1);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(100);
        });
    }
    @Test
    void shouldAddExistingID() {
        repository.save(product1);
        repository.save(product2);
        repository.save(book3);
        repository.save(smart1);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.save(smart3);
        });
    }
}
