package shop.model;

public class Brand {
	private Integer id;
	private String name;
	private String address;
	private String phone;
	private String des;
	public Brand() {
		super();
	}
	
	public Brand(Integer id, String name, String address, String phone, String des) {
		this(name, address, phone, des);
		this.id = id;
	}
	public Brand(String name, String address, String phone, String des) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.des = des;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	
	
}
