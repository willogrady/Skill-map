package com.skillsmap.role.application.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.skillsmap.role.application.entity.RoleSkillMap;
import com.skillsmap.role.application.repository.RoleSkillMapRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RoleSkillMap.class})
public class RoleSkillMapTests {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private RoleSkillMapController controller;
	
	@Mock
	private RoleSkillMapRepository repo;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void listTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/role_skill_map/list"))
			.andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void listSkillIDTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/role_skill_map/skillcode?skillcode={skillcode}",
				"GOVN"))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void listRoleIDTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/role_skill_map/role_id?role_id={role_id}",
				"1"))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void postTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/role_skill_map/create?role_skill_map_id={role_skill_map_id}"
				+ "&role_id={role_id}"
				+ "&skillcode={skillcode}"
				+ "&level={level}"
				+ "&version_id={version_id}",
				"15","7","GOVN","3","1"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
		.andExpect(MockMvcResultMatchers.content().string("Created and saved"));
	}


}
