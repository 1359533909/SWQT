package cn.mxl.pojo;


public class QueryVo {
	private String custName;
	private String commodity_name;
	private Integer page = 1;
	private Integer start;
	private Integer size = 7;
	private String account;
	private String acceptance;
	private String logistics_massage;
	private String cust_company;
	private String commodity_id;
	private int company_id;
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCommodity_name() {
		return commodity_name;
	}
	public void setCommodity_name(String commodity_name) {
		this.commodity_name = commodity_name;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAcceptance() {
		return acceptance;
	}
	public void setAcceptance(String acceptance) {
		this.acceptance = acceptance;
	}
	public String getLogistics_massage() {
		return logistics_massage;
	}
	public void setLogistics_massage(String logistics_massage) {
		this.logistics_massage = logistics_massage;
	}
	public String getCust_company() {
		return cust_company;
	}
	public void setCust_company(String cust_company) {
		this.cust_company = cust_company;
	}
	public String getCommodity_id() {
		return commodity_id;
	}
	public void setCommodity_id(String commodity_id) {
		this.commodity_id = commodity_id;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
}
