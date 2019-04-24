package cn.mxl.pojo;

public class Logistics {
	private int id;
	private String username;
	private String commodity_id;
	private String commodity_name;
	private float commodity_price;
	private String logistics_massage;
	private String company_name;
	private String logistics_address;
	private String supplier;
	private String acceptance;
	public String getAcceptance() {
		return acceptance;
	}
	public void setAcceptance(String acceptance) {
		this.acceptance = acceptance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCommodity_id() {
		return commodity_id;
	}
	public void setCommodity_id(String commodity_id) {
		this.commodity_id = commodity_id;
	}
	public String getCommodity_name() {
		return commodity_name;
	}
	public void setCommodity_name(String commodity_name) {
		this.commodity_name = commodity_name;
	}
	public float getCommodity_price() {
		return commodity_price;
	}
	public void setCommodity_price(float commodity_price) {
		this.commodity_price = commodity_price;
	}
	public String getLogistics_massage() {
		return logistics_massage;
	}
	public void setLogistics_massage(String logistics_massage) {
		this.logistics_massage = logistics_massage;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getLogistics_address() {
		return logistics_address;
	}
	public void setLogistics_address(String logistics_address) {
		this.logistics_address = logistics_address;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
}
