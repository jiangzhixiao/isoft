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

package io.isoft.reg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class StaffDict implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private String id;

	@Column(nullable = false)
	private String deptCode;

	@Column(nullable = false)
	private String name;

	@Column(nullable = true)
	private String title;

	@Column(nullable = false)
	private String userName;
	
	@Column(nullable = true)
	private String inputCode;
	
	@Column(nullable = true)
	private String job;

	protected StaffDict() {
	}

	public StaffDict(String deptCode, String name,String title,String userName,String job,String inputCode) {
		super();
		this.deptCode = deptCode;
		this.name = name;
		this.title = title;
		this.userName = userName;
		this.job =job;
		this.inputCode = inputCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public String getInputCode() {
		return inputCode;
	}

	public void setInputCode(String inputCode) {
		this.inputCode = inputCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return getName() + "," + getJob() + "," + getUserName();
	}
}
