import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    Product item1 = new Product(1, "Футболка", 500);
    Product item2 = new Product(2, "Платье", 1000);
    Product item3 = new Product(3, "Костюм", 3000);
    Product item4 = new Product(4, "Юбка", 2000);
    Product item5 = new Product(3, "Шапка", 100);

    @Test
    public void shouldThrowIfNonExistentId() {

        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(4);
        });
    }

    @Test
    public void shouldRemoveExistentId() {

        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        repo.removeById(3);
        Product[] expected = {item1, item2};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNewProduct() {

        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        repo.add(item4);
        Product[] expected = {item1,item2,item3,item4};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowWhenDuplicateId() {

        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(item5);
        });
    }
}
