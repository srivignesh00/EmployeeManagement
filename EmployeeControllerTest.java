package com.employee.management;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.http.HttpStatus;



import com.fasterxml.jackson.databind.ObjectMapper;






@SpringBootTest
@RunWith(MockitoJUnitRunner.class)

public class EmployeeControllerTest {
	@MockBean
	private EmployeeService employeeService;
	private ObjectMapper objectMapper = new ObjectMapper();
	private employee_details ragcrix;
	private employee_details yigit;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
	    ragcrix = new employee_details();
	    ragcrix.setId("aBc123");
	    ragcrix.setName("vignesh");
	    ragcrix.setDateOfBirth("09/01/2008");
	    ragcrix.setAge(23);
	    ragcrix.setEmail("vignesh@gmail.com");
	    
	    yigit = new employee_details();
	    yigit.setId("dEf345");
	    yigit.setName("deepak");
	    yigit.setDateOfBirth("09/09/2000");
	    yigit.setAge(24);
	    yigit.setEmail("deepak@gmail.com");
	}
	
	@Test
	public void givenStudents_whenGetAllStudents_thenReturnJsonArray() throws Exception {
	    given(employeeService.getEmployees()).willReturn(Arrays.asList(ragcrix));
	    mockMvc.perform(get("/api/employee/")
	            .contentType(MediaType.TEXT_XML))
	            .andExpect(status().is(HttpStatus.SERVICE_UNAVAILABLE.value()))
	            .andExpect(jsonPath("$[1].name", is(ragcrix.getName())));
	}


	
	
	}



