package cn.com.shiro.book.tp12.shiro.authz.permission;

import org.apache.shiro.authz.Permission;

/**
 * 权限对象，实现比较逻辑
 * */
public class BitPermission implements Permission {

	private int resourceId = -1;
	private int operateCode = -1;
	private int instanceId = -1;

	/**
	 * +资源id+操作码+对象id
	 * */
	public BitPermission(String perm) {
		String[] arrays = perm.split("\\+");
		if (arrays.length > 1) {
			this.resourceId = Integer.parseInt(arrays[1]);
		}
		if (arrays.length > 2) {
			this.operateCode = Integer.parseInt(arrays[2]);
		}
		if (arrays.length > 3) {
			this.instanceId = Integer.parseInt(arrays[3]);
		}
	}

	public BitPermission(int resourceId, int operateCode) {
		this.resourceId = resourceId;
		this.operateCode = operateCode;
	}

	public BitPermission(int resourceId, int operateCode, int instanceId) {
		this.resourceId = resourceId;
		this.operateCode = operateCode;
		this.instanceId = instanceId;
	}

	@Override
	// 实现两个权限对象的比较
	public boolean implies(Permission p) {
		boolean bool = false;
		if (p != null && p instanceof BitPermission) {
			BitPermission bitPrm = (BitPermission) p;
			if (this.hasAll() || bitPrm.hasAll()) {
				bool = true;
			} else {
				System.out.println("target->" + bitPrm.resourceId + ":"
						+ bitPrm.operateCode);
				bool = (this.resourceId == bitPrm.resourceId)
						&& ((this.operateCode & bitPrm.operateCode) == this.operateCode || (this.operateCode & bitPrm.operateCode) == bitPrm.operateCode);
			}
		}
		return bool;
	}

	private boolean hasAll() {
		return this.resourceId == -1 && this.operateCode == -1
				&& this.instanceId == -1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + operateCode;
		result = prime * result + resourceId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BitPermission other = (BitPermission) obj;
		if (operateCode != other.operateCode)
			return false;
		if (resourceId != other.resourceId)
			return false;
		return true;
	}

}
