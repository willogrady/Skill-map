package com.skillsmap.role.application.controller;

import static org.junit.Assert.*;

import javax.ws.rs.core.MediaType;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.skillsmap.role.application.repository.RoleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class RoleTests {
	
	private MockMvc mockMvc;

	@InjectMocks
	private RoleController controller;
	
	@Mock
	private RoleRepository repo;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void testRoleList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:9901/role/list"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testRoleId() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:9901/role/id/{role_id}", "5"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void deleteRole() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("http://localhost:9901/role/delete/{role_id}", "30"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("role deleted"));
				
	}
	
	@Test
    public void postTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:9901/role/create?role_title={role_title}"
        		+ "&role_grade={role_grade}"
        		+ "&role_summary={role_summary}"
        		+ "&version_id={version_id}"
        		+ "&role_group_id={role_group_id}",
               
                "Role Title","G16","Testing role summary","0","9"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Created and saved"));
    }
	
	// ---Update Tests---
	@Test
    public void updateSummary() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("http://localhost:9901/role/edit/role_summary?role_id={role_id}&role_summary={role_summary}",
                "1","summary update test"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("updated role summary"));
    }
	@Test
    public void updateTitle() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("http://localhost:9901/role/edit/role_title?role_id={role_id}&role_title={role_title}",
                "1","Technical Architect"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("updated role title"));
    }
	
	@Test
    public void updateGrade() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("http://localhost:9901/role/edit/role_grade?role_id={role_id}&role_grade={role_grade}",
                "1","G14"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("updated role grade"));
    }
	
	@Test
    public void updateRoleGroup() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("http://localhost:9901/role/edit/role_group_id?role_id={role_id}&role_group_id={role_group_id}",
                "1","2"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("updated role_group_id"));
    }
	
	
	

}
