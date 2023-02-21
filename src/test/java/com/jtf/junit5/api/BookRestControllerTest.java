package com.jtf.junit5.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jtf.junit5.api.controller.BookRestController;
import com.jtf.junit5.api.model.Book;
import com.jtf.junit5.api.service.BookService;

@WebMvcTest(value = BookRestController.class)
public class BookRestControllerTest {

	@MockBean
	private BookService bookService;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void testAddBook() throws Exception {
		when(bookService.saveBook(ArgumentMatchers.any())).thenReturn(true);
		
		Book bk = new Book(101,"Spring Junit",500);
		ObjectMapper mapper = new ObjectMapper();
		String bookJson =mapper.writeValueAsString(bk);
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post("/addBook")
		                       .contentType(MediaType.APPLICATION_JSON);
		
		ResultActions perform =mockMvc.perform(requestBuilder);
		MvcResult andReturn= perform.andReturn();
		MockHttpServletResponse res = andReturn.getResponse();
		int status =res.getStatus();
		assertEquals(201, status);
	}
	
}
