package com.cakefactory.catalog;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Component;

/**
 *
 * @author cvelasquez
 */
@Component
public class JpaCatalogService implements CatalogService {

    private final ItemRepository itemRepository;

    public JpaCatalogService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Iterable<Item> getItems() {
        return StreamSupport.stream(itemRepository.findAll().spliterator(), false)
                .map(this::mapEntity)
                .collect(Collectors.toList());
    }

    Item mapEntity(ItemEntity entity) {
        return new Item(entity.sku, entity.title, entity.price);
    }
}
