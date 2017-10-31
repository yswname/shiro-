package cn.com;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.shiro.book.tp12.entity.ShrPermission;
import cn.com.shiro.book.tp12.entity.ShrResource;
import cn.com.shiro.book.tp12.entity.ShrUserPermission;
import cn.com.shiro.book.tp12.hibernate.dao.ShrResourceDAO;
import cn.com.shiro.book.tp12.hibernate.dao.ShrUserPermissionDAO;
import cn.com.shiro.book.tp12.service.IUserService;

public class TestMain {

	public static void main(String[] args) {
//		String str = "$shiro1$SHA-512$1$$9UhX/dkPCgMt1O557ajj3ixbm09AofWfV+3eCe9zui7SCyvLNV/nfUd6VGAs2dcj7UiIQ43cNLugGDhQifpoVA==";
//		System.out.println(str.length());
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml"); 
		IUserService userService = (IUserService)ctx.getBean("userServiceImpl");
		List<ShrPermission> permList = userService.findPermissions("zhangsan");
		for(ShrPermission perm:permList){
			System.out.println(perm.getPrmRscId() + ":" + perm.getPrmOperationCode() + ",,," + perm.getShrResource().getRscId());
		}
		
//		ShrUserPermissionDAO permDAO = (ShrUserPermissionDAO)ctx.getBean("ShrUserPermissionDAO");
//		ShrUserPermission p = permDAO.findById(1);
//		System.out.println(p.getShrResource());
//		//System.out.println(p.getShrUser());
//		
//		ShrResourceDAO resDAO = (ShrResourceDAO)ctx.getBean("ShrResourceDAO");
//		ShrResource res = resDAO.findById(17);
		//System.out.println(res.getShrUserPermissions());
	}

}
