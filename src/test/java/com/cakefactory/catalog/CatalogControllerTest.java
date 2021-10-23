package com.cakefactory.catalog;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;
import static org.assertj.core.api.Assertions.assertThat;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 *
 * @author cvelasquez
 */
@SpringBootTest
@AutoConfigureMockMvc
public class CatalogControllerTest {

    private WebClient webClient;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CatalogService catalogService;

    @BeforeEach
    void setUp() {
        this.webClient = MockMvcWebClientBuilder.mockMvcSetup(mockMvc).build();
    }

    @Test
    @DisplayName("index page returns the landing page")
    void returnsLandingPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Cake Factory")));
    }

    @Test
    @DisplayName("index page returns a list of items from the database")
    void displayNumberOfItems() throws IOException {

        final String expectedTitle = "All Butter Croissant";
        mockItems(expectedTitle, BigDecimal.valueOf(0.75));

        HtmlPage page = webClient.getPage("http://localhost:8080/");

        assertThat(page.querySelectorAll(".card-title"))
                .anyMatch(domElement -> expectedTitle.equals(domElement.asNormalizedText()));
    }

    private void mockItems(String title, BigDecimal price) {
        when(catalogService.getItems())
                .thenReturn(Collections.singletonList(new Item("test", title, price)));
    }
}
