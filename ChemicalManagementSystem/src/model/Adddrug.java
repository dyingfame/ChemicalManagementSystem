package model;

/**
 * Adddrug entity. @author MyEclipse Persistence Tools
 */

public class Adddrug implements java.io.Serializable {

	// Fields

	private String drugName;
	private Double drugCount;

	// Constructors

	/** default constructor */
	public Adddrug() {
	}

	/** full constructor */
	public Adddrug(String drugName, Double drugCount) {
		this.drugName = drugName;
		this.drugCount = drugCount;
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

}