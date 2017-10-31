package cn.com.shiro.book.tp10.filter.authc;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

public class MyRoleAccessControlFilter extends AccessControlFilter {

	private String unauthorizedUrl = "/unauthorized.jsp";
	private String loginUrl = "/login";

	@Override
	protected boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		boolean result = false;
		String[] roles = (String[]) mappedValue;
		if (roles == null) {
			result = true;
		} else {
			Subject subject = this.getSubject(request, response);
			for (String role : roles) {
				if (subject.hasRole(role)) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		boolean result = false;

		Subject subject = getSubject(request, response);
		if (subject.getPrincipal() == null) {// 表示没有登录，重定向到登录页面
			saveRequest(request);
			WebUtils.issueRedirect(request, response, loginUrl);
		} else {
			if (StringUtils.hasText(unauthorizedUrl)) {// 如果有未授权页面跳转过去
				WebUtils.issueRedirect(request, response, unauthorizedUrl);
			} else {// 否则返回401未授权状态码
				WebUtils.toHttp(response).sendError(
						HttpServletResponse.SC_UNAUTHORIZED);
			}
		}

		return result;
	}

	public void setUnauthorizedUrl(String unauthorizedUrl) {
		this.unauthorizedUrl = unauthorizedUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

}
