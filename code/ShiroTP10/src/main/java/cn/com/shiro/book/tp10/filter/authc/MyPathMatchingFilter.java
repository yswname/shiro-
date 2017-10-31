package cn.com.shiro.book.tp10.filter.authc;

import java.util.Arrays;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.PathMatchingFilter;

public class MyPathMatchingFilter extends PathMatchingFilter {

	@Override
	protected boolean onPreHandle(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		System.out.println("url matches,config is " + Arrays.toString((String[])mappedValue));
		return super.onPreHandle(request, response, mappedValue);
	}

}
