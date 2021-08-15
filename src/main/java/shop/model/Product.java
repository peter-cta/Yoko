package shop.model;

public class Product {
	private Integer id;
	private String name;
	private String img;
	private double price;
	private String des;
	private Integer brandID;
	public Product() {
		super();
	}
	public Product(Integer id, String name, String img, double price, String des, Integer brandID) {
		this(name, img, price, des, brandID);
		this.id = id;
		
	}
	
	public Product(String name, String img, double price, String des, Integer brandID) {
		this.name = name;
		this.img = img;
		this.price = price;
		this.des = des;
		this.brandID = brandID;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public Integer getBrandID() {
		return brandID;
	}
	public void setBrandID(Integer brandID) {
		this.brandID = brandID;
	}
	
	
}
