package cn.com.shiro.book.tp10.filter.authc;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;

public class MyFormLoginFilter extends PathMatchingFilter {
	private String loginUrl = "/index.jsp";
	private String successUrl = "/welcome.jsp";

	@Override
	protected boolean onPreHandle(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		boolean result = false;

		Subject subject = SecurityUtils.getSubject();
		// 判断subject是否有验证
		if (subject.isAuthenticated()) {
			result = true;// 有验证，直接通过
		} else {
			// 判断是否是登录请求
			if (this.pathsMatch(loginUrl, request)) {
				// 是登录请求
				HttpServletRequest req = (HttpServletRequest) request;
				HttpServletResponse res = (HttpServletResponse) response;
				if ("post".equalsIgnoreCase(req.getMethod())) {
					String userName = req.getParameter("userName");
					String password = req.getParameter("password");
					UsernamePasswordToken token = new UsernamePasswordToken(
							userName, password);
					try {
						subject.login(token);
						// 保存重定向到成功页面的url
						WebUtils.redirectToSavedRequest(req, res, successUrl);
						result = false;
					} catch (Exception e) {
						req.setAttribute("shiroLoginFailure",
								"登录失败:" + e.getMessage());
						// 保存当前请求
						WebUtils.saveRequest(request);
						// 保存重定向登录页面的url
						WebUtils.issueRedirect(request, response, loginUrl);
					}
				} else {
					result = true;
				}
			} else {
				// 保存当前请求
				WebUtils.saveRequest(request);
				// 保存重定向登录页面的url
				WebUtils.issueRedirect(request, response, loginUrl);
			}
		}

		return result;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public void setSuccessUrl(String successUrl) {
		this.successUrl = successUrl;
	}

}
