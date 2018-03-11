package test3;

public class Order {
	public int oid;
	public String nid;
	public String hid;
	public String location;
	public String starttime;
	public String endtime;
	public String price;
	public String keyword;
	public String description;
	public boolean is_ordered;
	
	
	public int getOID(){
		return this.oid;
	}
	public void setOID(int oid){
		this.oid = oid;
	}
	
	public String getNID(){
		return this.nid;
	}
	public void setNID(String nid){
		this.nid = nid;
	}
	
	public String getHID(){
		return this.hid;
	}
	public void setHID(String hid){
		this.hid = hid;
	}
	
	public String getLocation(){
		return this.location;
	}
	public void setLocation(String location){
		this.location = location; 
	}
	
	public String getStarttime(){
		return this.starttime;
	}
	public void setStarttime(String starttime){
		this.starttime = starttime;
	}
	
	public String getEndtime(){
		return this.endtime;
	}
	public void setEndtime(String endtime){
		this.endtime = endtime;
	}
	
	public String getPrice(){
		return this.price;
	}
	public void setPrice(String price){
		this.price = price;
	}
	
	public String getKeyword(){
		return this.keyword;
	}
	public void setKeyword(String keyword){
		this.keyword = keyword;
	}
	
	public String getDescription(){
		return this.description;
	}
	public void setDescription(String description){
		this.description = description;
	}
	
	public boolean getIsOrdered(){
		return this.is_ordered;
	}
	public void setIsOrdered(boolean is_ordered){
		this.is_ordered = is_ordered;
	}
}