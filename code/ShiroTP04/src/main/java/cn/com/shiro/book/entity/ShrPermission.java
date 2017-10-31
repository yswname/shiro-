package cn.com.shiro.book.entity;

public class ShrPermission {
	private Integer prmId;
	private ShrResource prmResource;
	private Integer prmRscId;
	private Integer prmOperationCode;
	
	public Integer getPrmRscId() {
		if(this.prmResource != null){
			return this.prmResource.getRscId();
		}
		return prmRscId;
	}
	public void setPrmRscId(Integer prmRscId) {
		//this.prmRscId = prmRscId;
		if(this.prmResource == null){
			this.prmResource = new ShrResource();
		}
		this.prmResource.setRscId(prmRscId);
	}
	public Integer getPrmId() {
		return prmId;
	}
	public void setPrmId(Integer prmId) {
		this.prmId = prmId;
	}
	public ShrResource getPrmResource() {
		return prmResource;
	}
	public void setPrmResource(ShrResource prmResource) {
		this.prmResource = prmResource;
	}
	public Integer getPrmOperationCode() {
		return prmOperationCode;
	}
	public void setPrmOperationCode(Integer prmOperationCode) {
		this.prmOperationCode = prmOperationCode;
	}
}
