package cn.com.shiro.book.tp10.filter.authc;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.servlet.OncePerRequestFilter;

public class MyOncePerRequestFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(ServletRequest request,
			ServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		System.out.println("执行MyOncePerRequestFilter---------");
		chain.doFilter(request, response);
	}

}
