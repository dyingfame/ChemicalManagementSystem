package model;

/**
 * Useregister entity. @author MyEclipse Persistence Tools
 */

public class Useregister implements java.io.Serializable {

	// Fields

	private String record;
	private String userName;
	private String userNum;
	private String drugName;
	private Double drugCount;
	private String date;

	// Constructors

	/** default constructor */
	public Useregister() {
	}

	/** full constructor */
	public Useregister(String record, String userName, String userNum,
			String drugName, Double drugCount, String date) {
		this.record = record;
		this.userName = userName;
		this.userNum = userNum;
		this.drugName = drugName;
		this.drugCount = drugCount;
		this.date = date;
	}

	// Property accessors

	public String getRecord() {
		return this.record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNum() {
		return this.userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public String getDrugName() {
		return this.drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public Double getDrugCount() {
		return this.drugCount;
	}

	public void setDrugCount(Double drugCount) {
		this.drugCount = drugCount;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}