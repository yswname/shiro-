package cn.com.shiro.book.tp06.authz.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;
/**
 * 基于权限字符串，解析出权限对象
 * */
public class BitAndWildcardPermissionResolver implements PermissionResolver {
	@Override
	public Permission resolvePermission(String permissionString) {
		if (permissionString.startsWith("+")) {
			return new BitPermission(permissionString);
		}
		return new WildcardPermission(permissionString);
	}

}
