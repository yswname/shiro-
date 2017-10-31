package cn.com.shiro.book.tp09.filter.authc;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class MyFormAuthenticationFilter extends FormAuthenticationFilter {

	public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
		return super.onPreHandle(request, response, mappedValue);
	}
	@Override
	protected boolean executeLogin(ServletRequest request,
			ServletResponse response) throws Exception {
		System.out.println("**************");
		return super.executeLogin(request, response);
	}

}
