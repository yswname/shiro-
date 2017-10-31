package cn.com.shiro.book.tp12.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import cn.com.shiro.book.tp12.entity.ShrUser;
import cn.com.shiro.book.tp12.service.IUserService;

@Controller("userAction")
public class UserAction {
	private ShrUser user;
	private String message;
    public String add(){
    	String result = "successAdd";
    	System.out.println("执行添加用户功能");
    	this.message = "添加成功";
    	try{
    	user = this.userService.createUser(user);
    	}catch(Exception e){
    		e.printStackTrace();
    		this.message = "添加失败:" + e.getMessage();
    	}
    	return result;
    }
    public String edit(){
    	String result = "successEdit";
    	System.out.println("执行修改用户功能");
    	return result;
    }
    public String delete(){
    	String result = "successDelete";
    	System.out.println("执行删除用户功能");
    	return result;
    }
    public String query(){
    	String result = "successQuery";
    	System.out.println("执行查询用户功能");
    	return result;
    }
    // --debug
    public ShrUser getUser() {
		return user;
	}
	public void setUser(ShrUser user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Autowired
    @Qualifier("userServiceImpl")
    private IUserService userService;
}
