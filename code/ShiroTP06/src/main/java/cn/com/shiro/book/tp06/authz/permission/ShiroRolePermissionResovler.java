package cn.com.shiro.book.tp06.authz.permission;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;
/**
 * 基于角色名称，解析出对应的权限
 * */
public class ShiroRolePermissionResovler implements RolePermissionResolver {
    private Map<String,Collection<Permission>> rolePerms = new HashMap<String,Collection<Permission>>();
    {
    	rolePerms.put("admin", Arrays.asList((Permission)new WildcardPermission("*")));
    	rolePerms.put("role1", Arrays.asList((Permission)new BitPermission(1,1),
    			(Permission)new BitPermission(1,2), (Permission)new WildcardPermission("user:create")));
    	rolePerms.put("role2", Arrays.asList((Permission)new BitPermission(1,1),
    			(Permission)new BitPermission(1,3)));
    	rolePerms.put("role3", Arrays.asList((Permission)new BitPermission(1,1),
    			(Permission)new BitPermission(1,4)));
    }
	@Override
	public Collection<Permission> resolvePermissionsInRole(String roleString) {
		return this.rolePerms.get(roleString);
	}

}
