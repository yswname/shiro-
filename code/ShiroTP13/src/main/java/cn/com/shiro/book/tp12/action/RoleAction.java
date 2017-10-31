package cn.com.shiro.book.tp12.action;

import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import cn.com.shiro.book.tp12.entity.ShrRole;
import cn.com.shiro.book.tp12.service.IRoleService;

@Controller("roleAction")
public class RoleAction {
    private ShrRole role;
    private List<ShrRole> roleList;
    private String myData;
    
    public String demoJson(){
    	System.out.println("*************"+this.myData);
    	JSONArray obj = JSONArray.fromObject(myData);
    	this.roleList = JSONArray.toList(obj, ShrRole.class);
    	if(roleList != null){
    		for(ShrRole r:roleList){
    			System.out.println(r.getRlName()+"," + r.getRlRemark());
    			 
    		}
    	}
    	System.out.println("!!!!!!!!!!!!!!1   ");
    	return "success1";
    }
    
    public String execute(){
    	//IRoleService roleService = new RoleServiceImpl();
    	role = roleService.createRole(role);
    	if(role != null){
    		roleList = roleService.findAll();
    	}
    	return "success";
    }

	public ShrRole getRole() {
		return role;
	}

	public void setRole(ShrRole role) {
		this.role = role;
	}

	public List<ShrRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<ShrRole> roleList) {
		this.roleList = roleList;
	}

	public String getMyData() {
		return myData;
	}

	public void setMyData(String myData) {
		this.myData = myData;
	}
    
	@Autowired
	@Qualifier("roleServiceImpl")
	private IRoleService roleService;
    
}
