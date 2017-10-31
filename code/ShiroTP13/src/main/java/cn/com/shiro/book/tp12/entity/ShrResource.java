package cn.com.shiro.book.tp12.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * ShrResource entity. @author MyEclipse Persistence Tools
 */

public class ShrResource implements java.io.Serializable {

	// Fields

	private int rscId;
	private String rscName;
	private String rscRemark;
	private Set shrResourceItems = new HashSet(0);
	private Set shrUserPermissions = new HashSet(0);
	private Set shrRolePermissions = new HashSet(0);

	// Constructors

	/** default constructor */
	public ShrResource() {
	}

	/** full constructor */
	public ShrResource(String rscName, String rscRemark, Set shrResourceItems,
			Set shrUserPermissions, Set shrRolePermissions) {
		this.rscName = rscName;
		this.rscRemark = rscRemark;
		this.shrResourceItems = shrResourceItems;
		this.shrUserPermissions = shrUserPermissions;
		this.shrRolePermissions = shrRolePermissions;
	}

	// Property accessors

	public int getRscId() {
		return this.rscId;
	}

	public void setRscId(int rscId) {
		this.rscId = rscId;
	}

	public String getRscName() {
		return this.rscName;
	}

	public void setRscName(String rscName) {
		this.rscName = rscName;
	}

	public String getRscRemark() {
		return this.rscRemark;
	}

	public void setRscRemark(String rscRemark) {
		this.rscRemark = rscRemark;
	}

	public Set<ShrResourceItem> getShrResourceItems() {
		return this.shrResourceItems;
	}

	public void setShrResourceItems(Set shrResourceItems) {
		this.shrResourceItems = shrResourceItems;
	}

	public Set getShrUserPermissions() {
		return this.shrUserPermissions;
	}

	public void setShrUserPermissions(Set shrUserPermissions) {
		this.shrUserPermissions = shrUserPermissions;
	}

	public Set getShrRolePermissions() {
		return this.shrRolePermissions;
	}

	public void setShrRolePermissions(Set shrRolePermissions) {
		this.shrRolePermissions = shrRolePermissions;
	}

}