package hello.itemservice.domain.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        this.itemRepository.clear();
    }

    @Test
    void save() {
        Item given = new Item("itemA", 1000, 10);

        Item when = this.itemRepository.save(given);

        Item findItem = itemRepository.findById(given.getId());
        assertThat(when).isEqualTo(findItem);
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void update() {
    }

    @Test
    void clear() {
    }
}