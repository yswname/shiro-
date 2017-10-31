package cn.com.shiro.book.tp12.entity;

/**
 * ShrUserPermission entity. @author MyEclipse Persistence Tools
 */

public class ShrUserPermission extends ShrPermission implements java.io.Serializable {

	// Fields

	private Integer prmId;
	private ShrUser shrUser;
	//private ShrResource shrResource;
	private Integer prmOperationCode;

	// Constructors

	/** default constructor */
	public ShrUserPermission() {
	}

	/** minimal constructor */
	public ShrUserPermission(ShrUser shrUser, ShrResource shrResource) {
		this.shrUser = shrUser;
		//this.shrResource = shrResource;
	}

	/** full constructor */
	public ShrUserPermission(ShrUser shrUser, ShrResource shrResource,
			Integer prmOperationCode) {
		this.shrUser = shrUser;
		//this.shrResource = shrResource;
		this.prmOperationCode = prmOperationCode;
	}

	// Property accessors

	public Integer getPrmId() {
		return this.prmId;
	}

	public void setPrmId(Integer prmId) {
		this.prmId = prmId;
	}

	public ShrUser getShrUser() {
		return this.shrUser;
	}

	public void setShrUser(ShrUser shrUser) {
		this.shrUser = shrUser;
	}

//	public ShrResource getShrResource() {
//		return this.shrResource;
//	}
//
//	public void setShrResource(ShrResource shrResource) {
//		this.shrResource = shrResource;
//	}

	public Integer getPrmOperationCode() {
		return this.prmOperationCode;
	}

	public void setPrmOperationCode(Integer prmOperationCode) {
		this.prmOperationCode = prmOperationCode;
	}

}