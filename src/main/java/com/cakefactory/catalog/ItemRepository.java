package com.cakefactory.catalog;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author cvelasquez
 */
public interface ItemRepository extends CrudRepository<ItemEntity, String> {
}
