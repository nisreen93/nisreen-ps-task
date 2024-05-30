/*package com.demo.FXDealsAnalyzer;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.exception.handler.DataIntegrityViolationException;
import com.demo.model.Deal;
import com.demo.service.DealService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class FxDealsAnalyzerApplicationTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private DealService dealService;

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void testApplicationContext() {
	    String[] beans = applicationContext.getBeanDefinitionNames();
	    for (String bean : beans) {
	        System.out.println("****************************************"+bean);
	    }
	}
	
	@Test
	public void success() throws Exception {
		Deal deal = new Deal();
		deal.setId(UUID.randomUUID());
		deal.setFromCurrencyCode("USD");
		deal.setToCurrencyCode("EUR");
		deal.setTimestamp(LocalDateTime.now());
		deal.setAmount(BigDecimal.valueOf(1000));

		Mockito.when(dealService.save(Mockito.any(Deal.class))).thenReturn(deal);

		mockMvc.perform(post("/fx/deal/save").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(deal))).andExpect(status().isOk());
	}

	@Test
	public void conflict() throws Exception {
		UUID dealId = UUID.randomUUID();
		Deal deal1 = new Deal();
		deal1.setId(dealId);
		deal1.setFromCurrencyCode("USD");
		deal1.setToCurrencyCode("EUR");
		deal1.setTimestamp(LocalDateTime.now());
		deal1.setAmount(BigDecimal.valueOf(1000));
		Mockito.when(dealService.save(Mockito.any(Deal.class))).thenReturn(deal1);

		mockMvc.perform(post("/fx/deal/save").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(deal1))).andExpect(status().isOk());

		Deal deal2 = new Deal();
		deal2.setId(dealId);
		deal2.setFromCurrencyCode("USD");
		deal2.setToCurrencyCode("EUR");
		deal2.setTimestamp(LocalDateTime.now());
		deal2.setAmount(BigDecimal.valueOf(1000));

		Mockito.when(dealService.save(Mockito.any(Deal.class)))
				.thenThrow(new DataIntegrityViolationException("Deal with the same ID already exists"));

		mockMvc.perform(post("/fx/deal/save").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(deal2))).andExpect(status().isConflict())
				.andExpect(content().string("Deal with the same ID already exists"));
	}
}
*/