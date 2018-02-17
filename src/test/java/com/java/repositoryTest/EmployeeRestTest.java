package com.java.repositoryTest;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.GsonBuilder;
import com.java.appconfig.SpringJdbcConfig;
import com.java.controller.EmployeeController;
import com.java.dto.Employee;
import com.java.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {SpringJdbcConfig.class})
@Transactional
public class EmployeeRestTest 
{
	
	private MockMvc mockMvc;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeController controller;
	
	
	@Autowired
	MappingJackson2HttpMessageConverter messageConverter;
	
	
	@Before
	public void setUp()
	{
		 // this must be called for the @Mock annotations above to be processed
        // and for the mock service to be injected into the controller under
        // test.
		
		MockitoAnnotations.initMocks(this);
		//EmployeeController controller=new EmployeeController(employeeService);
		this.mockMvc=MockMvcBuilders.standaloneSetup(controller).setMessageConverters(messageConverter).build();
	}
	
	
/*	@Test
	@Transactional
	public void getEmployeeDetails() throws Exception
	{
		//Mockito.when(employeeService.saveEmployee(Mockito.any(Employee.class))).thenReturn(Mockito.anyString());
		RequestBuilder reqBuilder=MockMvcRequestBuilders.get("/employee/getEmployee/{id}",2).accept(MediaType.APPLICATION_JSON);
		
		MvcResult result=mockMvc.perform(reqBuilder).andReturn();
		
		System.out.println(result.getResponse());
		String expected = "{\"id\":2,\"name\":\"Hello\",\"created_date\":1518546600000}";
		
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		

	}*/
	
	
	@Test()
	@Transactional
	public void employeeSaveTest() throws Exception
	{
		//Mockito.when(employeeService.saveEmployee(Mockito.any(Employee.class))).thenReturn(Mockito.anyString());
		Employee emp = new Employee();
		emp.setId(6);
		emp.setName("Janakiram");
		emp.setCreated_date(new Date());
		//Gson gson=new GsonBuilder().setDateFormat("");
		RequestBuilder reqBuilder=MockMvcRequestBuilders.post("/employee/findOne")
				.accept(MediaType.TEXT_PLAIN).content(new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(emp)).contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result=mockMvc.perform(reqBuilder).andReturn();
		
		System.out.println(result.getResponse().getContentAsString());
		
		JSONAssert.assertEquals("Success", result.getResponse().getContentAsString(), false);
		

	}

}
