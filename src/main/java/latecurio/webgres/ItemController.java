package latecurio.webgres;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/items")
public class ItemController {

    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @PostMapping
    public Mono<ItemResource> create(@RequestBody final NewItemResource newItemResource) {

        return itemRepository.save(from(newItemResource))
                .map(this::from);
    }

    private Item from(NewItemResource resource) {
        Item item = new Item();
        item.setDescription(resource.getDescription());
        return item;
    }

    private ItemResource from(Item item) {
        ItemResource resource = new ItemResource();
        resource.setId(item.getId());
        resource.setDescription(item.getDescription());
        return resource;
    }
}