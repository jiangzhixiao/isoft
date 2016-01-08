package io.isoft.reg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * WebColumnClass entity. @author MyEclipse Persistence Tools
 */
@Entity
public class WebColumnClass implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Fields
	@Id
	@GeneratedValue
	private String classCode;
	
	@Column(nullable = true)
	private String className;
	@Column(nullable = true)
	private String codeLevel;
	@Column(nullable = true)
	private String parentCode;
	@Column(nullable = true)
	private String endSign;
	@Column(nullable = true)
	private String phoInputCode;
	@Column(nullable = true)
	private String fiveInputCode;
	@Column(nullable = true)
	private String monitorSign;
	@Column(nullable = true)
	private String firstPageSign;

	// Constructors

	/** default constructor */
	public WebColumnClass() {
	}

	/** minimal constructor */
	public WebColumnClass(String classCode) {
		this.classCode = classCode;
	}

	/** full constructor */
	public WebColumnClass(String classCode, String className, String codeLevel,
			String parentCode, String endSign, String phoInputCode,
			String fiveInputCode,String monitorSign,String firstPageSign) {
		this.classCode = classCode;
		this.className = className;
		this.codeLevel = codeLevel;
		this.parentCode = parentCode;
		this.endSign = endSign;
		this.phoInputCode = phoInputCode;
		this.fiveInputCode = fiveInputCode;
		this.firstPageSign = firstPageSign;
		this.monitorSign = monitorSign;
	}

	// Property accessors

	public String getClassCode() {
		return this.classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getCodeLevel() {
		return this.codeLevel;
	}

	public void setCodeLevel(String codeLevel) {
		this.codeLevel = codeLevel;
	}

	public String getParentCode() {
		return this.parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getEndSign() {
		return this.endSign;
	}

	public void setEndSign(String endSign) {
		this.endSign = endSign;
	}

	public String getPhoInputCode() {
		return this.phoInputCode;
	}

	public void setPhoInputCode(String phoInputCode) {
		this.phoInputCode = phoInputCode;
	}

	public String getFiveInputCode() {
		return this.fiveInputCode;
	}

	public void setFiveInputCode(String fiveInputCode) {
		this.fiveInputCode = fiveInputCode;
	}

	public String getMonitorSign() {
		return monitorSign;
	}

	public void setMonitorSign(String monitorSign) {
		this.monitorSign = monitorSign;
	}

	public String getFirstPageSign() {
		return firstPageSign;
	}

	public void setFirstPageSign(String firstPageSign) {
		this.firstPageSign = firstPageSign;
	}

}