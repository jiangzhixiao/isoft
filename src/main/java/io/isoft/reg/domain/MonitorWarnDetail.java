package io.isoft.reg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

/**
 * MonitorWarnDetail entity. @author MyEclipse Persistence Tools
 */
@Entity
public class MonitorWarnDetail implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Fields
	@Id
	@GeneratedValue
	private String recordId;
	
	@Column(nullable = false)
	private String warnId;
	
	@Column(nullable = false)
	private String ruleId;
	
	@Column(nullable = true)
	private String columnCode;
	
	@Column(nullable = false)
	private String indexCode;
	
	@Column(nullable = true)
	private String deductReason;
	
	@Column(nullable = true)
	private Double deductValue;
	
	@Column(nullable = true)
	private String operateTime;
	
	@Column(nullable = true)
	private Date createDate;
	
	@Column(nullable = true)
	private String noSign;
	
	@Column(nullable = true)
	private String warnGrade;

	// Constructors

	/** default constructor */
	public MonitorWarnDetail() {
	}

	/** minimal constructor */
	public MonitorWarnDetail(String recordId, String warnId, String ruleId,
			String indexCode) {
		this.recordId = recordId;
		this.warnId = warnId;
		this.ruleId = ruleId;
		this.indexCode = indexCode;
	}

	/** full constructor */
	public MonitorWarnDetail(String recordId, String warnId, String ruleId,
			String columnCode, String indexCode, String deductReason,
			Double deductValue, String operateTime, Timestamp createDate,
			String noSign, String warnGrade) {
		this.recordId = recordId;
		this.warnId = warnId;
		this.ruleId = ruleId;
		this.columnCode = columnCode;
		this.indexCode = indexCode;
		this.deductReason = deductReason;
		this.deductValue = deductValue;
		this.operateTime = operateTime;
		this.createDate = createDate;
		this.noSign = noSign;
		this.warnGrade = warnGrade;
	}

	// Property accessors

	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getWarnId() {
		return this.warnId;
	}

	public void setWarnId(String warnId) {
		this.warnId = warnId;
	}

	public String getRuleId() {
		return this.ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public String getColumnCode() {
		return this.columnCode;
	}

	public void setColumnCode(String columnCode) {
		this.columnCode = columnCode;
	}

	public String getIndexCode() {
		return this.indexCode;
	}

	public void setIndexCode(String indexCode) {
		this.indexCode = indexCode;
	}

	public String getDeductReason() {
		return this.deductReason;
	}

	public void setDeductReason(String deductReason) {
		this.deductReason = deductReason;
	}

	public Double getDeductValue() {
		return this.deductValue;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setDeductValue(Double deductValue) {
		this.deductValue = deductValue;
	}

	public String getOperateTime() {
		return this.operateTime;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}

	public String getNoSign() {
		return this.noSign;
	}

	public void setNoSign(String noSign) {
		this.noSign = noSign;
	}

	public String getWarnGrade() {
		return this.warnGrade;
	}

	public void setWarnGrade(String warnGrade) {
		this.warnGrade = warnGrade;
	}

}