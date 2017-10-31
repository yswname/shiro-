package cn.com.shiro.book.tp12.entity;

/**
 * ShrResourceItem entity. @author MyEclipse Persistence Tools
 */

public class ShrResourceItem implements java.io.Serializable {

	// Fields

	private Integer itmId;
	private ShrResource shrResource;
	private Integer itmType;
	private String itmUrl;
	private String itmRemark;

	// Constructors

	/** default constructor */
	public ShrResourceItem() {
	}

	/** minimal constructor */
	public ShrResourceItem(ShrResource shrResource, Integer itmType) {
		this.shrResource = shrResource;
		this.itmType = itmType;
	}

	/** full constructor */
	public ShrResourceItem(ShrResource shrResource, Integer itmType,
			String itmUrl, String itmRemark) {
		this.shrResource = shrResource;
		this.itmType = itmType;
		this.itmUrl = itmUrl;
		this.itmRemark = itmRemark;
	}

	// Property accessors

	public Integer getItmId() {
		return this.itmId;
	}

	public void setItmId(Integer itmId) {
		this.itmId = itmId;
	}

	public ShrResource getShrResource() {
		return this.shrResource;
	}

	public void setShrResource(ShrResource shrResource) {
		this.shrResource = shrResource;
	}

	public Integer getItmType() {
		return this.itmType;
	}

	public void setItmType(Integer itmType) {
		this.itmType = itmType;
	}

	public String getItmUrl() {
		return this.itmUrl;
	}

	public void setItmUrl(String itmUrl) {
		this.itmUrl = itmUrl;
	}

	public String getItmRemark() {
		return this.itmRemark;
	}

	public void setItmRemark(String itmRemark) {
		this.itmRemark = itmRemark;
	}

}