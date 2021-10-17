package com.cakefactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cvelasquez
 */
public class InMemoryCatalog implements CatalogService {

    private final List<Item> catalog = new ArrayList<>();
    
    public InMemoryCatalog() {
        catalog.add(new Item("abcr", "All Butter Croissant", BigDecimal.valueOf(0.75)));
        catalog.add(new Item("ccr", "Chocolate Croissant", BigDecimal.valueOf(0.95)));
        catalog.add(new Item("b", "Fresh Baguette", BigDecimal.valueOf(1.60)));
        catalog.add(new Item("rv", "Red Velvet", BigDecimal.valueOf(3.95)));
        catalog.add(new Item("vs", "Victoria Sponge", BigDecimal.valueOf(5.45)));
        catalog.add(new Item("cc", "Carrot Cake", BigDecimal.valueOf(3.45)));
    }

    @Override
    public Iterable<Item> getItems() {
        return catalog;
    }

    @Override
    public Item getItemBySku(String sku) {
        return catalog.stream()
                .filter(item -> item.getSku().equals(sku)).findFirst()
                .get();
    }
}
