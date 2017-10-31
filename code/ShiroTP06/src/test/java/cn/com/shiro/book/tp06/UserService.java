package cn.com.shiro.book.tp06;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;

public class UserService {
	@RequiresPermissions(value={"user:create"})
    public void addUser(){
    	System.out.println("添加用户");
    }
    @RequiresRoles(value={"admin"})
    public void editUser(){
    	System.out.println("编辑用户");
    }
    
    public void deleteUser(){
    	System.out.println("删除用户");
    }
    
    @RequiresAuthentication
    public void viewUser(){
    	System.out.println("查看用户");
    }
    @RequiresGuest
    public void verifyUser(){
    	System.out.println("验证用户");
    }
}
