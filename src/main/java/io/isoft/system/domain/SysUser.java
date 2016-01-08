/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.isoft.system.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "SYS_USER")
public class SysUser implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "USER_CODE", nullable = false)
	private String userCode;
	
    @Column(nullable = true)
	private String userName;
	  
    @Column(nullable = true)
	private String deptName;  	  
	@Column(nullable = false)
	private String deptCode;

	@Column(nullable = true)
	private String subDeptName;  	  
	@Column(nullable = true)
	private String subDeptCode;

	@Column(nullable = true)
	private String password;

	@Column(nullable = true)
	private String state;
	@Column(nullable = true)
	private String freezeSign;
	
	@Column(nullable = true)
	private String inputCode;
	
	@Column(nullable = true)
	private Date createDate;


    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name="SYS_USER_ROLE",
            joinColumns={@JoinColumn(name="USER_CODE",referencedColumnName = "USER_CODE")},
            inverseJoinColumns={@JoinColumn(name="ROLE_CODE",referencedColumnName = "ROLE_CODE")})
    private List<SysRole> roles = new ArrayList<SysRole>();

	public List<SysRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<SysRole> userRoles) {
		this.userRoles = userRoles;
	}

	@Transient

	private List<SysRole> userRoles =  new ArrayList<SysRole>();
	protected SysUser() {
	}

    public SysUser(String userCode, String userName, String deptName,
                   String deptCode, String subDeptName, String subDeptCode,
                   String password, String state, String freezeSign, String inputCode,
                   Date createDate) {
		super();
		this.userCode = userCode;
		this.userName = userName;
		this.deptName = deptName;
		this.deptCode = deptCode;
		this.subDeptName = subDeptName;
		this.subDeptCode = subDeptCode;
		this.password = password;
		this.state = state;
		this.freezeSign = freezeSign;
		this.inputCode = inputCode;
		this.createDate = createDate;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getSubDeptName() {
		return subDeptName;
	}

	public void setSubDeptName(String subDeptName) {
		this.subDeptName = subDeptName;
	}

	public String getSubDeptCode() {
		return subDeptCode;
	}

	public void setSubDeptCode(String subDeptCode) {
		this.subDeptCode = subDeptCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getFreezeSign() {
		return freezeSign;
	}

	public void setFreezeSign(String freezeSign) {
		this.freezeSign = freezeSign;
	}

	public String getInputCode() {
		return inputCode;
	}

	public void setInputCode(String inputCode) {
		this.inputCode = inputCode;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public List<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return getUserName() + "," + getDeptCode() + "," + getUserName();
	}
}
