package cn.com.shiro.book.tp12.authz.permission;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

/**
 * 基于角色名称，解析出对应的权限
 * */
public class ShiroRolePermissionResovler implements RolePermissionResolver {
	private Map<String, List<String>> rolePermsMap = new HashMap<String, List<String>>();
	{
		// 初始化角色权限信息
		rolePermsMap.put("admin", Arrays.asList("*"));
		rolePermsMap.put("role1",
				Arrays.asList("user:add", "user:edit", "user:delete"));
		rolePermsMap.put("role2",
				Arrays.asList("order:add", "order:edit", "order:delete"));
		rolePermsMap.put("role3", Arrays.asList("user:query", "order:query"));
	}

	@Override
	public Collection<Permission> resolvePermissionsInRole(String roleString) {
		Collection<Permission> permissions = new HashSet<Permission>();
		List<String> permStrs = this.rolePermsMap.get(roleString);
		if(permStrs != null){
			for(String permStr:permStrs){
				permissions.add((Permission)new WildcardPermission(permStr));
			}
		}
		return permissions;
	}

}
