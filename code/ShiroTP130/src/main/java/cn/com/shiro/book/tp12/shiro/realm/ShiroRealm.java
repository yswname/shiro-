package cn.com.shiro.book.tp12.shiro.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.com.shiro.book.tp12.dao.IShrResourceItemDAO;
import cn.com.shiro.book.tp12.entity.ShrPermission;
import cn.com.shiro.book.tp12.service.IUserService;
import cn.com.shiro.book.tp12.shiro.authz.permission.BitPermission;

public class ShiroRealm extends AuthorizingRealm {
	private IUserService userService;
    /**
     * 获取当前用户在数据库中记录的权限
     * */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 获取当前用户
		String userName = principals.getPrimaryPrincipal().toString();
		// 如果是admin
		if ("admin".equals(userName)) {
			// 拥有所有的权限
			info.addObjectPermission(new BitPermission("+"));
		} else {
			// 调用userService的方法，获取数据库中当前用户的所有权限实体
			List<ShrPermission> shrPermList = userService
					.findPermissions(userName);
			// 将数据库中的权限实体信息，转换成BitPermission对象，添加到info
			if (shrPermList != null && shrPermList.size() > 0) {
				// 创建一个存放BitPermission对象的集合
				Set<Permission> permissions = new HashSet<Permission>();
				BitPermission bitPerm = null;
				// 循环获取数据库中的权限实体
				for (ShrPermission shrPerm : shrPermList) {
					// 将权限实体转变成BitPermission对象
					bitPerm = new BitPermission(shrPerm.getShrResource()
							.getRscId(), shrPerm.getPrmOperationCode());
					// 添加到BitPermission对象集合
					permissions.add(bitPerm);
				}
				// 将所有的BitPermission对象，添加info
				info.setObjectPermissions(permissions);
			}
		}

		return info;
	}

	// shiro验证 token(userName,password) info(userName,password)
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		// 获取身份标识(用户名)
		// 根据用户找到密码和盐
		// 获取私盐，拼凑新的密码（加密后验证）
		// 封装到Info中返回

		SimpleAuthenticationInfo info = null;
		// 获取身份标识(用户名)
		UsernamePasswordToken pswToken = (UsernamePasswordToken) token;
		String userName = pswToken.getUsername();
		// subject的密码
		String password = new String(pswToken.getPassword());
		// 根据用户找到密码和盐
		String[] result = this.userService
				.findPasswordAndSaltByUserName(userName);
		// 获取私盐，拼凑新的密码（加密后验证）
		String data = result[1].substring(result[1].length() - 1);
		int index = Integer.parseInt(data);
		String privateSalt = result[1].substring(index, 5);
		// 在subject的密码上加上私盐，更新token
		pswToken.setPassword((privateSalt + password).toCharArray());
		// 封装到Info中返回
		info = new SimpleAuthenticationInfo(userName, result[0], this.getName());
		return info;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

}
