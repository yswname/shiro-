package cn.com.shiro.book.tp12.entity;

/**
 * ShrRolePermission entity. @author MyEclipse Persistence Tools
 */

public class ShrRolePermission extends ShrPermission implements java.io.Serializable {

	// Fields

	private Integer prmId;
	//private ShrResource shrResource;
	private ShrRole shrRole;
	private Integer prmOperationCode;

	// Constructors

	/** default constructor */
	public ShrRolePermission() {
	}

	/** full constructor */
	public ShrRolePermission(ShrResource shrResource, ShrRole shrRole,
			Integer prmOperationCode) {
		//this.shrResource = shrResource;
		this.shrRole = shrRole;
		this.prmOperationCode = prmOperationCode;
	}

	// Property accessors

	public Integer getPrmId() {
		return this.prmId;
	}

	public void setPrmId(Integer prmId) {
		this.prmId = prmId;
	}

//	public ShrResource getShrResource() {
//		return this.shrResource;
//	}
//
//	public void setShrResource(ShrResource shrResource) {
//		this.shrResource = shrResource;
//	}

	public ShrRole getShrRole() {
		return this.shrRole;
	}

	public void setShrRole(ShrRole shrRole) {
		this.shrRole = shrRole;
	}

	public Integer getPrmOperationCode() {
		return this.prmOperationCode;
	}

	public void setPrmOperationCode(Integer prmOperationCode) {
		this.prmOperationCode = prmOperationCode;
	}

}