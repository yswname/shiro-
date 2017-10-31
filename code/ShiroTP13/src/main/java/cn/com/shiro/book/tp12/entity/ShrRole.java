package cn.com.shiro.book.tp12.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * ShrRole entity. @author MyEclipse Persistence Tools
 */

public class ShrRole implements java.io.Serializable {

	// Fields

	private Integer rlId;
	private String rlName;
	private String rlRemark;
	private Set shrUsers = new HashSet(0);
	private Set shrRolePermissions = new HashSet(0);

	// Constructors

	/** default constructor */
	public ShrRole() {
	}

	/** minimal constructor */
	public ShrRole(String rlName) {
		this.rlName = rlName;
	}

	/** full constructor */
	public ShrRole(String rlName, String rlRemark, Set shrUsers,
			Set shrRolePermissions) {
		this.rlName = rlName;
		this.rlRemark = rlRemark;
		this.shrUsers = shrUsers;
		this.shrRolePermissions = shrRolePermissions;
	}

	// Property accessors

	public Integer getRlId() {
		return this.rlId;
	}

	public void setRlId(Integer rlId) {
		this.rlId = rlId;
	}

	public String getRlName() {
		return this.rlName;
	}

	public void setRlName(String rlName) {
		this.rlName = rlName;
	}

	public String getRlRemark() {
		return this.rlRemark;
	}

	public void setRlRemark(String rlRemark) {
		this.rlRemark = rlRemark;
	}

	public Set getShrUsers() {
		return this.shrUsers;
	}

	public void setShrUsers(Set shrUsers) {
		this.shrUsers = shrUsers;
	}

	public Set getShrRolePermissions() {
		return this.shrRolePermissions;
	}

	public void setShrRolePermissions(Set shrRolePermissions) {
		this.shrRolePermissions = shrRolePermissions;
	}

}