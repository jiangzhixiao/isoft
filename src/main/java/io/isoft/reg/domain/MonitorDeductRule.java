package io.isoft.reg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * MonitorDeductRule entity. @author MyEclipse Persistence Tools
 */
@Entity
public class MonitorDeductRule implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private String ruleId;
	
	@Column(nullable = true)
	private String ruleName;
	
	@Column(nullable = true)
	private String columnCode;
	
	@Column(nullable = true)
	private String columnName;
	
	@Column(nullable = false)
	private String indexCode;
	
	@Column(nullable = true)
	private String indexName;
	
	@Column(nullable = true)
	private String valveUnit1;
	
	@Column(nullable = true)
	private Double valveY1;
	
	@Column(nullable = true)
	private Double valveR1;
	
	@Column(nullable = true)
	private String valveUnit2;
	
	@Column(nullable = true)
	private Double valveY2;
	
	@Column(nullable = true)
	private Double valveR2;
	
	@Column(nullable = true)
	private String noSign;
	
	@Column(nullable = true)
	private String startTime;
	
	@Column(nullable = true)
	private Double monitorFrequency;
	
	@Column(nullable = true)
	private String frequencyUnit;
	
	@Column(nullable = true)
	private String operateTime;
	
	@Column(nullable = true)
	private Double deductValue;
	
	@Column(nullable = true)
	private String currentStatus;

	// Constructors

	/** default constructor */
	public MonitorDeductRule() {
	}

	/** minimal constructor */
	public MonitorDeductRule(String ruleId, String indexCode) {
		this.ruleId = ruleId;
		this.indexCode = indexCode;
	}

	/** full constructor */
	public MonitorDeductRule(String ruleId, String ruleName, String columnCode,String columnName,
			String indexCode, String valveUnit1, Double valveY1,
			Double valveR1, String valveUnit2, Double valveY2,
			Double valveR2, String noSign, String startTime,
			Double monitorFrequency, String frequencyUnit,
			String operateTime, Double deductValue, String currentStatus,String indexName) {
		this.ruleId = ruleId;
		this.ruleName = ruleName;
		this.columnCode = columnCode;
		this.indexCode = indexCode;
		this.valveUnit1 = valveUnit1;
		this.valveY1 = valveY1;
		this.valveR1 = valveR1;
		this.valveUnit2 = valveUnit2;
		this.valveY2 = valveY2;
		this.valveR2 = valveR2;
		this.noSign = noSign;
		this.startTime = startTime;
		this.monitorFrequency = monitorFrequency;
		this.frequencyUnit = frequencyUnit;
		this.operateTime = operateTime;
		this.deductValue = deductValue;
		this.currentStatus = currentStatus;
		this.columnName = columnName;
		this.indexName = indexName;
	}

	// Property accessors

	public String getRuleId() {
		return this.ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public String getRuleName() {
		return this.ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getColumnCode() {
		return this.columnCode;
	}

	public void setColumnCode(String columnCode) {
		this.columnCode = columnCode;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getIndexCode() {
		return this.indexCode;
	}

	public void setIndexCode(String indexCode) {
		this.indexCode = indexCode;
	}

	public String getValveUnit1() {
		return this.valveUnit1;
	}

	public void setValveUnit1(String valveUnit1) {
		this.valveUnit1 = valveUnit1;
	}

	public Double getValveY1() {
		return this.valveY1;
	}

	public void setValveY1(Double valveY1) {
		this.valveY1 = valveY1;
	}

	public Double getValveR1() {
		return this.valveR1;
	}

	public void setValveR1(Double valveR1) {
		this.valveR1 = valveR1;
	}

	public String getValveUnit2() {
		return this.valveUnit2;
	}

	public void setValveUnit2(String valveUnit2) {
		this.valveUnit2 = valveUnit2;
	}

	public Double getValveY2() {
		return this.valveY2;
	}

	public void setValveY2(Double valveY2) {
		this.valveY2 = valveY2;
	}

	public Double getValveR2() {
		return this.valveR2;
	}

	public void setValveR2(Double valveR2) {
		this.valveR2 = valveR2;
	}

	public String getNoSign() {
		return this.noSign;
	}

	public void setNoSign(String noSign) {
		this.noSign = noSign;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Double getMonitorFrequency() {
		return this.monitorFrequency;
	}

	public void setMonitorFrequency(Double monitorFrequency) {
		this.monitorFrequency = monitorFrequency;
	}

	public String getFrequencyUnit() {
		return this.frequencyUnit;
	}

	public void setFrequencyUnit(String frequencyUnit) {
		this.frequencyUnit = frequencyUnit;
	}

	public String getOperateTime() {
		return this.operateTime;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}

	public Double getDeductValue() {
		return this.deductValue;
	}

	public void setDeductValue(Double deductValue) {
		this.deductValue = deductValue;
	}

	public String getCurrentStatus() {
		return this.currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}
	
}