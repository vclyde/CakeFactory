package com.cakefactory.catalog;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 *
 * @author cvelasquez
 */
@DataJpaTest
public class JpaCatalogServiceTest {
    
    private JpaCatalogService jpaCatalogService;
    
    @Autowired
    ItemRepository itemRepository;
    
    @BeforeEach
    void setUp() {
        this.jpaCatalogService = new JpaCatalogService(itemRepository);
    }

    @Test
    @DisplayName("returns data from database")
    void returnDataFromDatabase() {        
        assertThat(this.jpaCatalogService.getItems()).hasSize(6);
    }
}
