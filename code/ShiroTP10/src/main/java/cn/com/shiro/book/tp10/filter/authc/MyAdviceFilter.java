package cn.com.shiro.book.tp10.filter.authc;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.servlet.AdviceFilter;

public class MyAdviceFilter extends AdviceFilter {

	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response)
			throws Exception {
		System.out.println("执行MyAdviceFilter->preHandle");
		return super.preHandle(request, response);
	}

	@Override
	protected void postHandle(ServletRequest request, ServletResponse response)
			throws Exception {
		super.postHandle(request, response);
		System.out.println("执行MyAdviceFilter->postHandle");
	}

	@Override
	public void afterCompletion(ServletRequest request,
			ServletResponse response, Exception exception) throws Exception {
		super.afterCompletion(request, response, exception);
		System.out.println("执行MyAdviceFilter->afterCompletion");
	}

}
