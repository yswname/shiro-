package cn.com.shiro.book.tp12.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.com.shiro.book.tp12.entity.ShrResource;
import cn.com.shiro.book.tp12.entity.ShrResourceItem;
import cn.com.shiro.book.tp12.service.IResourceService;

@Controller("resourceAction")
@Scope("prototype")
public class ResourceAction {
	private ShrResource resource;
	private List<ShrResourceItem> itemList;
	private List<String> itmNames;
	private List<String> itmRemarks;
	private List<Integer> itmTypes;
	private List<String> itmUrls;
	private List<Integer> itmIds;
	
	private List<ShrResource> resourceList;
	
	private String message;
	
	public String view(){
		this.resource = this.resService.findResourceById(resource.getRscId());
		return "viewSuccess";
	}
	
	public String initAdd(){
		return "initAddSuccess";
	}
	
	public String findAll(){
		String result = "findSuccess";
		this.resourceList = this.resService.findAllResources();
		return result;
	}
	
    public String add(){
    	this.message = "添加资源成功!";
    	try{
//    		IResourceService resService = new ResourceServiceImpl();
    		List<ShrResourceItem> items = new ArrayList<ShrResourceItem>();
    		ShrResourceItem item = null;
    		for(int i=0;i<itmTypes.size();i++){
    			item = new ShrResourceItem();
    			item.setItmType(itmTypes.get(i));
    			item.setItmRemark(this.itmRemarks.get(i));
    			item.setItmUrl(itmUrls.get(i));
    			if(item.getItmUrl() == null || "".equals(item.getItmUrl())){
    				continue;
    			}
    			items.add(item);
    		}
    		resService.addResource(resource, items);
    	}catch(Exception e){
    		e.printStackTrace();
    		message = "添加失败:" + e.getMessage();
    	}
    	return "addSuccess";
    }
    
    public String edit(){
    	this.message = "修改资源成功!";
    	try{
//    		IResourceService resService = new ResourceServiceImpl();
    		List<ShrResourceItem> items = new ArrayList<ShrResourceItem>();
    		ShrResourceItem item = null;
    		for(int i=0;i<itmTypes.size();i++){
    			item = new ShrResourceItem();
    			item.setItmType(itmTypes.get(i));
    			item.setItmRemark(this.itmRemarks.get(i));
    			item.setItmUrl(itmUrls.get(i));
    			if(itmIds.get(i) != -1){
    				item.setItmId(itmIds.get(i));
    			}
    			if(item.getItmUrl() == null || "".equals(item.getItmUrl())){
    				continue;
    			}
    			items.add(item);
    		}
    		resService.editResource(resource, items);
    	}catch(Exception e){
    		e.printStackTrace();
    		message = "修改失败:" + e.getMessage();
    	}
    	return "addSuccess";
    }
    
	public List<ShrResource> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<ShrResource> resourceList) {
		this.resourceList = resourceList;
	}

	public ShrResource getResource() {
		return resource;
	}
	public void setResource(ShrResource resource) {
		this.resource = resource;
	}
	public List<ShrResourceItem> getItemList() {
		return itemList;
	}
	public void setItemList(List<ShrResourceItem> itemList) {
		this.itemList = itemList;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getItmNames() {
		return itmNames;
	}
	public void setItmNames(List<String> itmNames) {
		this.itmNames = itmNames;
	}
	public List<String> getItmRemarks() {
		return itmRemarks;
	}
	public void setItmRemarks(List<String> itmRemarks) {
		this.itmRemarks = itmRemarks;
	}
	public List<Integer> getItmTypes() {
		return itmTypes;
	}
	public void setItmTypes(List<Integer> itmTypes) {
		this.itmTypes = itmTypes;
	}
	public List<String> getItmUrls() {
		return itmUrls;
	}
	public void setItmUrls(List<String> itmUrls) {
		this.itmUrls = itmUrls;
	}
    
	public List<Integer> getItmIds() {
		return itmIds;
	}

	public void setItmIds(List<Integer> itmIds) {
		this.itmIds = itmIds;
	}

	@Autowired
	@Qualifier("resourceServiceImpl")
    private IResourceService resService ;
}
