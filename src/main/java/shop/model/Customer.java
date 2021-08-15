package shop.model;

public class Customer {
	private Integer id;
	private String name;
	private String email;
	private String phone;
	private String address;
	private Integer account_id;
	
	public Customer() {
		super();
	}
	
	public Customer(Integer id, String name, String email, String phone, String address, Integer account_id) {
		this(name, email, phone, address, account_id);
		this.id = id;
		
	}
	
	public Customer(String name, String email, String phone, String address, Integer account_id) {

		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.account_id = account_id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}

	

	
}
