package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {
    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach(){
        itemRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Item item = new Item("itemA", 10000, 10);
        //when
        Item save = itemRepository.save(item);
        //then
        Item byId = itemRepository.findById(save.getId());

        assertThat(save).isEqualTo(byId);
    }

    @Test
    void findAll(){
        Item item1 = new Item("itemA", 10000, 10);
        Item item2 = new Item("itemB", 20000, 20);

        itemRepository.save(item1);
        itemRepository.save(item2);

        List<Item> all = itemRepository.findAll();

        assertThat(all.size()).isEqualTo(2);
        assertThat(all).contains(item1, item2);
    }

    @Test
    void updateItem(){
        Item item1 = new Item("itemA", 10000, 10);

        Item save = itemRepository.save(item1);
        long id = save.getId();

        Item updateParam = new Item("item2", 20000, 20);

        itemRepository.update(id, updateParam);

        Item byId = itemRepository.findById(id);

        assertThat(byId.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(byId.getPrice()).isEqualTo(updateParam.getPrice());
        assertThat(byId.getQuantity()).isEqualTo(updateParam.getQuantity());
    }
}