package model;

/**
 * Drugstock entity. @author MyEclipse Persistence Tools
 */

public class Drugstock implements java.io.Serializable {

	// Fields

	private String drugName;
	private Double drugCount;
	private Double drugLimit;
	private String drugLight;
	private String drugVolat;
	private String remark;
	private Double drugUnitPrice;

	// Constructors

	/** default constructor */
	public Drugstock() {
	}

	/** minimal constructor */
	public Drugstock(String drugName, Double drugCount, Double drugLimit,
			String drugLight, String drugVolat, Double drugUnitPrice) {
		this.drugName = drugName;
		this.drugCount = drugCount;
		this.drugLimit = drugLimit;
		this.drugLight = drugLight;
		this.drugVolat = drugVolat;
		this.drugUnitPrice = drugUnitPrice;
	}

	/** full constructor */
	public Drugstock(String drugName, Double drugCount, Double drugLimit,
			String drugLight, String drugVolat, String remark,
			Double drugUnitPrice) {
		this.drugName = drugName;
		this.drugCount = drugCount;
		this.drugLimit = drugLimit;
		this.drugLight = drugLight;
		this.drugVolat = drugVolat;
		this.remark = remark;
		this.drugUnitPrice = drugUnitPrice;
	}

	// Property accessors

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

	public Double getDrugLimit() {
		return this.drugLimit;
	}

	public void setDrugLimit(Double drugLimit) {
		this.drugLimit = drugLimit;
	}

	public String getDrugLight() {
		return this.drugLight;
	}

	public void setDrugLight(String drugLight) {
		this.drugLight = drugLight;
	}

	public String getDrugVolat() {
		return this.drugVolat;
	}

	public void setDrugVolat(String drugVolat) {
		this.drugVolat = drugVolat;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getDrugUnitPrice() {
		return this.drugUnitPrice;
	}

	public void setDrugUnitPrice(Double drugUnitPrice) {
		this.drugUnitPrice = drugUnitPrice;
	}

}