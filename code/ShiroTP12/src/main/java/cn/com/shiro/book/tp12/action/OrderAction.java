package cn.com.shiro.book.tp12.action;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("orderAction")
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OrderAction {
    public String add(){
    	String result = "successAdd";
    	System.out.println("执行添加订单功能");//
    	return result;
    }
    public String edit(){
    	String result = "successEdit";
    	System.out.println("执行修改订单功能");
    	return result;
    }
    public String delete(){
    	String result = "successDelete";
    	System.out.println("执行删除订单功能");
    	return result;
    }
    public String query(){
    	String result = "successQuery";
    	System.out.println("执行查询订单功能");
    	return result;
    }
}
