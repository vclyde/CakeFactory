package com.cakefactory;

/**
 *
 * @author cvelasquez
 */
public interface CatalogService {

    Iterable<Item> getItems();

    Item getItemBySku(String sku);
}
