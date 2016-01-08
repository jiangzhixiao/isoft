package io.isoft.reg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

/**
 * MonitorWarnMaster entity. @author MyEclipse Persistence Tools
 */
@Entity
public class MonitorWarnMaster implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Fields
	@Id
	@GeneratedValue
	private String warnId;
	
	@Column(nullable = true)
	private String userCode;
	
	@Column(nullable = true)
	private String warnGrade;
	
	@Column(nullable = true)
	private String warnContent;
	
	@Column(nullable = true)
	private String readSign;
	
	@Column(nullable = true)
	private Date createDate;
	
	@Column(nullable = true)
	private Date readDate;
	
	@Column(nullable = true)
	private String hasNoSign;
	
	@Column(nullable = true)
	private Double deductValue;
	
	

	// Constructors

	/** default constructor */
	public MonitorWarnMaster() {
	}

	/** minimal constructor */
	public MonitorWarnMaster(String warnId) {
		this.warnId = warnId;
	}

	/** full constructor */
	public MonitorWarnMaster(String warnId, String userCode, String warnGrade,
			String warnContent, String readSign, Timestamp createDate) {
		this.warnId = warnId;
		this.userCode = userCode;
		this.warnGrade = warnGrade;
		this.warnContent = warnContent;
		this.readSign = readSign;
		this.createDate = createDate;
	}

	// Property accessors

	public String getWarnId() {
		return this.warnId;
	}

	public void setWarnId(String warnId) {
		this.warnId = warnId;
	}

	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getWarnGrade() {
		return this.warnGrade;
	}

	public void setWarnGrade(String warnGrade) {
		this.warnGrade = warnGrade;
	}

	public String getWarnContent() {
		return this.warnContent;
	}

	public void setWarnContent(String warnContent) {
		this.warnContent = warnContent;
	}

	public String getReadSign() {
		return this.readSign;
	}

	public void setReadSign(String readSign) {
		this.readSign = readSign;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getReadDate() {
		return readDate;
	}

	public void setReadDate(Date readDate) {
		this.readDate = readDate;
	}

	public String getHasNoSign() {
		return hasNoSign;
	}

	public void setHasNoSign(String hasNoSign) {
		this.hasNoSign = hasNoSign;
	}

	public Double getDeductValue() {
		return deductValue;
	}

	public void setDeductValue(Double deductValue) {
		this.deductValue = deductValue;
	}


}