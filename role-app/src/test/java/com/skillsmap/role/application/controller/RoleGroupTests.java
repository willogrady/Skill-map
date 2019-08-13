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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.skillsmap.role.application.entity.RoleGroup;
import com.skillsmap.role.application.repository.RoleGroupRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RoleGroup.class})
public class RoleGroupTests {
		
	private MockMvc mockMvc;
	
	@InjectMocks
	private RoleGroupController controller;
	
	@Mock
	private RoleGroupRepository repo;

	@Before
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
			.andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void listIDTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/role_group/id/{role_group_id}",
				"1"))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void listGroupTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/role_group/listgroup"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
		
	@Test
	public void postTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/role_group/create?role_group={role_group}"
				+ "&version_id={version_id}",
				"Testing","1"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
		.andExpect(MockMvcResultMatchers.content().string("Created and saved"));
	}
	
	@Test
	public void deleteTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/role_group/delete/{role_group_id}",
				"9"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
		.andExpect(MockMvcResultMatchers.content().string("Role group deleted"));
	}
	
	@Test
	public void putTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.put("/role_group/edit?role_group={role_group}"
				+ "&role_group_id={role_group_id}"
				+ "&version_id={version_id}",
				"Testing","9","1"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
		.andExpect(MockMvcResultMatchers.content().string("Updated role_group"));
	}

}
