import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    Product item1 = new Product(1, "Футболка", 500);
    Product item2 = new Product(2, "Платье", 1000);
    Product item3 = new Product(3, "Костюм", 3000);

    @Test
    public void shouldThrow() {

        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(4);
        });
    }

    @Test
    public void shouldRemove() {

        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        repo.removeById(3);
        Product[] expected = {item1, item2};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }
}
