package hangtum.store.item.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hangtum.store.item.kafka.KafkaService;
import hangtum.store.item.model.Item;
import hangtum.store.item.repository.ItemRepository;

@Service
public class ItemControllerService {
    private final ItemRepository itemRepository;
    private final KafkaService kafkaService;

    @Autowired
    public ItemControllerService(ItemRepository itemRepository, KafkaService kafkaService) {
        this.itemRepository = itemRepository;
        this.kafkaService = kafkaService;
    }

    public List<Item> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return items;
    }

    public Optional<Item> getItemById(Long id) {
        Optional<Item> optItem = itemRepository.findById(id);
        return optItem;
    }

    public List<Item> getItemByCategoryID(String categoryID) {
        List<Item> Items = itemRepository.findByCategoryID(categoryID);
        return Items;
    }

    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    public void deleteAllItem() {
        itemRepository.deleteAll();
    }

    // public void sendIdToLesson(Long ItemID) {
    //     kafkaService.sendItemIdToLesson(ItemID);
    // }
}
