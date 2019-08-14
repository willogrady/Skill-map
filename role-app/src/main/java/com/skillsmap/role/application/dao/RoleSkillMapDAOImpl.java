package com.skillsmap.role.application.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.skillsmap.role.application.entity.RoleSkillMap;
import com.skillsmap.role.application.repository.RoleSkillMapRepository;

@Component
@Service
@Primary
public class RoleSkillMapDAOImpl implements RoleSkillMapDAO {
	
	private String sfia_url = "http://localhost:9900/sfia/list";
	private String sfia_skill_code_url = "http://localhost:9900/sfia/skillcode/";
	private String find_role_from_skill_url = "http://localhost:9901/role_skill_map/skillcode";
	private String find_role_url = "http://localhost:9901/role/id/";
	private String find_skill_list_from_role = "http://localhost:9901/role_skill_map/skill_id_for_one_role";
	
	@Autowired
	private RoleSkillMapRepository rsmRepo;
	
	public RoleSkillMapRepository getRsmRepo() {
		return rsmRepo;
	}

	public void setRsmRepo(RoleSkillMapRepository rsmRepo) {
		this.rsmRepo = rsmRepo;
	}

	@Override
	public String readAll(Reader rd) {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    try {
			while ((cp = rd.read()) != -1) {
			  sb.append((char) cp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return sb.toString();
	}

	@Override
	public String readStringFromUrl(String url) throws IOException {
		InputStream is = new URL(url).openStream();
		try {
		   	BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		   	String jsonText = readAll(rd);
		      return jsonText;
		    } finally {
		      is.close();
		    }
	}

	// ---methods for role_by_skill---
	@Override
	public String getRoleViaSkill(RoleSkillMap roleSkillMap) throws IOException {
		String url =  find_role_from_skill_url+"?skillcode="+roleSkillMap.skillcode;
		String strResponse = readStringFromUrl(url);
		return strResponse;
	}
	
	@Override
	public String getSkillviaSkillId(RoleSkillMap roleSkillMap) throws IOException {
		String url = sfia_skill_code_url+roleSkillMap.skillcode;
		String strResponse = readStringFromUrl(url);
		return strResponse; 
		}

	@Override
	public String mapRoleWithSkillInfo(RoleSkillMap roleSkillMap) throws IOException {
		String strResponse = getRoleViaSkill(roleSkillMap)+getSkillviaSkillId(roleSkillMap);
		return strResponse;
	}

	// ---methods for skill_by_role---
	@Override
    public List<RoleSkillMap> getRoleinDao(RoleSkillMap roleSkillMap, int role_id) throws IOException {
        List<RoleSkillMap> roleResponse = getRsmRepo().findByRoleId(role_id);   
        return roleResponse;
    }

	public String getRolefromRole(RoleSkillMap roleSkillMap) throws IOException {
		String url = find_role_url+roleSkillMap.role_id;
		String strResponse = readStringFromUrl(url);
		return strResponse;
	}

	@Override
	public List<RoleSkillMap> getSkillviaRoleId(int role_id) throws IOException {	
		List<RoleSkillMap> response = getRsmRepo().findSkillsByRoleId(role_id);
		return response;
	}
	
	@Override		
	public String mapSkillWithRoleInfo(RoleSkillMap roleSkillMap, int role_id) throws IOException {
		String roleResponse = getRolefromRole(roleSkillMap);
		String url = find_skill_list_from_role+"?role_id="+roleSkillMap.role_id;
		String skillResponse = readStringFromUrl(url);
		return roleResponse+skillResponse;
	}
	
}
