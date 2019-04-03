package com.reactivemanuel.ppmtool.test.web;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.reactivemanuel.ppmtool.domain.Project;
import com.reactivemanuel.ppmtool.services.TestService;
import com.reactivemanuel.ppmtool.web.TestController;

@RunWith(SpringRunner.class)
@WebMvcTest(TestController.class)
public class TestControllerTest {

	private String 					requestMap = "/api/test";	
	private ObjectMapper 			mapper = new ObjectMapper();
	@Autowired
	private MockMvc 				mockMvc;	
	@MockBean
	private TestService				testService;
	
	// Simplest Get Request
	@Test
	public void getTest_test() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders
								.get(requestMap)
								.accept(MediaType.TEXT_PLAIN);
		
		MvcResult result = mockMvc.perform(request).andReturn();

		assertEquals("Test", result.getResponse().getContentAsString());
	}
	
	// Return a Json Item. 
	// No Service yet
	@Test
	public void getTestProject_test() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders
								.get(requestMap+"/project")
								.accept(MediaType.APPLICATION_JSON);

		String jsonResponse = "{\"id\":1,\"projectName\":\"ProjName\",\"projectIdentifier\":\"PID01\",\"description\":\"Description\","
								+"\"start_date\":null,\"end_date\":null,\"created_At\":null,\"updated_At\":null}";
		
		MvcResult result = mockMvc.perform(request)
							.andExpect(status().isOk())
							.andExpect(content().json(jsonResponse))
							.andReturn();

		JSONAssert.assertEquals(jsonResponse, result.getResponse().getContentAsString(), false);
	}
	
	// Return a Json Item. 
	// Using Business Service
	@Test
	public void getTestProjectFromService_test() throws Exception{
		Project project = new Project(1L, "ProjName","PID01","Description");		
		when(testService.retrieveHardcodedItem()).thenReturn(project);
		
		RequestBuilder request = MockMvcRequestBuilders
								.get(requestMap+"/project-from-business-service")
								.accept(MediaType.APPLICATION_JSON);
		
		String jsonResponse = mapper.writeValueAsString(project);		
//		System.out.println(jsonResponse);
		
		MvcResult result = mockMvc.perform(request)
							.andExpect(status().isOk())
							.andExpect(content().json(jsonResponse))
							.andReturn();

		JSONAssert.assertEquals(jsonResponse, result.getResponse().getContentAsString(), false);
	}
	
}
