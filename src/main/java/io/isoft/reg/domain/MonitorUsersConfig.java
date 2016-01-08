package io.isoft.reg.domain;

import javax.persistence.*;


/**
 * MonitorUsersConfig entity. @author MyEclipse Persistence Tools
 */
@Entity
public class MonitorUsersConfig implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="seqMonitor")
	@SequenceGenerator(name="seqMonitor",sequenceName="seq_monitor_users")
	private Long autoId;
	
	@Column(nullable = false)
	private String userCode;
	
	@Column(nullable = false)
	private String columnCode;
	
	@Column(nullable = true)
	private String columnName;
	
	@Column(nullable = true)
	private String ruleId;
	
	@Column(nullable = true)
	private String ruleName;
	
	@Column(nullable = true)
	private String useRange;
	
	@Column(nullable = true)
	private String startTime;
	
	@Column(nullable = true)
	private Double monitorFrequency;
	
	@Column(nullable = true)
	private String frequencyUnit;
	
	@Column(nullable = true)
	private String operateTime;

	// Constructors

	/** default constructor */
	public MonitorUsersConfig() {
	}

	/** minimal constructor */
	public MonitorUsersConfig(Long autoId, String userCode, String columnCode) {
		this.autoId = autoId;
		this.userCode = userCode;
		this.columnCode = columnCode;
	}

	/** full constructor */
	public MonitorUsersConfig(Long autoId, String userCode,
			String columnCode, String ruleId, String useRange,
			String startTime, Double monitorFrequency,
			String frequencyUnit, String operateTime,String columnName,String ruleName) {
		this.autoId = autoId;
		this.userCode = userCode;
		this.columnCode = columnCode;
		this.ruleId = ruleId;
		this.useRange = useRange;
		this.startTime = startTime;
		this.monitorFrequency = monitorFrequency;
		this.frequencyUnit = frequencyUnit;
		this.operateTime = operateTime;
		this.ruleName= ruleName;
		this.columnName = columnName;
	}

	// Property accessors

	public Long getAutoId() {
		return this.autoId;
	}

	public void setAutoId(Long autoId) {
		this.autoId = autoId;
	}

	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getColumnCode() {
		return this.columnCode;
	}

	public void setColumnCode(String columnCode) {
		this.columnCode = columnCode;
	}

	public String getRuleId() {
		return this.ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public String getUseRange() {
		return this.useRange;
	}

	public void setUseRange(String useRange) {
		this.useRange = useRange;
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

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

}