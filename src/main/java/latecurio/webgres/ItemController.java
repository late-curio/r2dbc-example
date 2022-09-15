package latecurio.webgres;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
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

    @GetMapping("/{id}")
    public Mono<ItemResource> get(@PathVariable Long id) {

        return itemRepository.findById(id)
                .map(this::from);
    }

    @GetMapping
    public Flux<ItemResource> getAll(@RequestParam String ids) {

        return Flux.just(ids.split(","))
                        .map(Long::parseLong)
                .flatMap(itemRepository::findById)
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