package hello.itemservice.domain.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    void findAll() {
        Item given = new Item("itemA", 1000, 10);
        Item given1 = new Item("itemB", 2200, 20);

        this.itemRepository.save(given);
        this.itemRepository.save(given1);

        List<Item> result = this.itemRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(given, given1);
    }

    @Test
    void update() {
        Item given = new Item("itemA", 1000, 10);
        Item savedItem = this.itemRepository.save(given);
        Long itemId = savedItem.getId();

        Item updateParam = new Item("item2", 2222, 50);
        this.itemRepository.update(itemId, updateParam);

        Item findItem = this.itemRepository.findById(itemId);

        assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
    }
}