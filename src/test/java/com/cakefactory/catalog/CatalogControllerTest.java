package com.cakefactory.catalog;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;
import org.assertj.core.api.Assertions;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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
	@DisplayName("index page return a list of items from the database")
	void returnsListOfItemsFromDb() throws IOException {
		
		final String expectedTitle = "Red Velvet";
		mockItems(expectedTitle, BigDecimal.valueOf(3));
		
		HtmlPage page = webClient.getPage("http://localhost:8080");
		
		Assertions.assertThat(page.querySelectorAll(".card-title"))
				.anyMatch(domElement -> expectedTitle.equals(domElement.asNormalizedText()));
	}
	
	private void mockItems(String title, BigDecimal price) {
		Mockito.when(catalogService.getItems()).thenReturn(Collections.singletonList(new Item(title, price)));
	}
}
