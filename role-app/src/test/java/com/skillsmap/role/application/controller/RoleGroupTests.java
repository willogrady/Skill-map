package com.skillsmap.role.application.controller;

import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.skillsmap.role.application.entity.RoleGroup;
import com.skillsmap.role.application.repository.RoleGroupRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RoleGroup.class})
public class RoleGroupTests {
		
	private MockMvc mockMvc;
	
	@Autowired
	private RoleGroup roleGroupMock;
	
	@InjectMocks
	private RoleGroupController controller;
	
	@Mock
	private RoleGroupRepository repo;

	@Before	//build objects before the Tests run
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/role_group/test"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string("testing testing 123"));
	}
	
	@Test
	public void listTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/role_group/list"))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
//	@Test
//	public void testPost() throws Exception {
//		String json = "{\n" +
//				" \"role_group\": \"Testing\",\n"+
//				" \"version_id\": \"1\"n" +
//				"}";
//		mockMvc.perform(MockMvcRequestBuilders.post("/role_group/create?role_group=Testing?version_id=1")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(json)
//		)
//			.andExpect(MockMvcResultMatchers.status().isOk());
//	}
	

}
