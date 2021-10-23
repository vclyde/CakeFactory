package com.cakefactory.catalog;

import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

/**
 *
 * @author cvelasquez
 */
@DataJpaTest
public class JpaCatalogServiceTest {

    private JpaCatalogService jpaCatalogService;

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    ItemRepository itemRepository;

    @BeforeEach
    void setUp() {

        this.jpaCatalogService = new JpaCatalogService(itemRepository);
    }

    @Test
    @DisplayName("returns data from database")
    void returnDataFromDatabase() {
        Iterable<Item> items = this.jpaCatalogService.getItems();

        assertThat(items).hasSize(6);

        String title = "Victoria Sponge";
        saveTestItem("test-item-1", title, BigDecimal.valueOf(5.55));
        
        assertThat(items).anyMatch(item -> title.equals(item.getTitle()));
    }

    private void saveTestItem(String sku, String title, BigDecimal price) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.sku = sku;
        itemEntity.title = title;
        itemEntity.price = price;

        testEntityManager.persistAndFlush(itemEntity);
    }
}
