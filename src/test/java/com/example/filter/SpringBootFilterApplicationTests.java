package com.example.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class SpringBootFilterApplicationTests {

	Logger logger = LogManager.getLogger(SpringBootFilterApplicationTests.class);

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testXssFilterGet() throws Exception {
		String param = "<alert>alert!</alert>";
		logger.info("testXssFilterGet Start!");

		mockMvc.perform(MockMvcRequestBuilders.get("/xss").accept(MediaType.TEXT_HTML)
				.param("msg", param))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	void testXssFilterPost() throws Exception {
		String param = "<alert>alert!</alert>";
		logger.info("testXssFilterGet Start!");

		mockMvc.perform(MockMvcRequestBuilders.post("/xss").accept(MediaType.TEXT_HTML)
				.param("msg", param))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}

}