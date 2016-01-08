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

package io.isoft.reg.repository.criteria;

import org.springframework.util.Assert;

import java.io.Serializable;

public class StaffDictSearchCriteria implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String inputCode;
	private String deptCode;
	

	public StaffDictSearchCriteria() {
	}

	public StaffDictSearchCriteria(String inputCode) {
		Assert.notNull(inputCode, "inputCode must not be null");
		this.inputCode = inputCode;
	}

	public StaffDictSearchCriteria(String inputCode,String deptCode) {
		this.inputCode = inputCode;
		this.deptCode  = deptCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInputCode() {
		return inputCode;
	}

	public void setInputCode(String inputCode) {
		this.inputCode = inputCode;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	
}
