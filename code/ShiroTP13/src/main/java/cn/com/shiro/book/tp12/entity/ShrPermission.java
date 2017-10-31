package cn.com.shiro.book.tp12.entity;

public class ShrPermission {
	private Integer prmId;
	private ShrResource shrResource;
	private Integer prmRscId;
	private Integer prmOperationCode;
	
	public Integer getPrmRscId() {
		if(this.shrResource != null){
			return this.shrResource.getRscId();
		}
		return prmRscId;
	}
	public void setPrmRscId(Integer prmRscId) {
		//this.prmRscId = prmRscId;
		if(this.shrResource == null){
			this.shrResource = new ShrResource();
		}
		this.shrResource.setRscId(prmRscId);
	}
	public Integer getPrmId() {
		return prmId;
	}
	public void setPrmId(Integer prmId) {
		this.prmId = prmId;
	}
//	public ShrResource getPrmResource() {
//		return prmResource;
//	}
//	public void setPrmResource(ShrResource prmResource) {
//		this.prmResource = prmResource;
//	}
	
	
	public Integer getPrmOperationCode() {
		return prmOperationCode;
	}
	public ShrResource getShrResource() {
		return shrResource;
	}
	public void setShrResource(ShrResource shrResource) {
		this.shrResource = shrResource;
	}
	public void setPrmOperationCode(Integer prmOperationCode) {
		this.prmOperationCode = prmOperationCode;
	}
}
