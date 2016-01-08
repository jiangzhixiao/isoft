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

package io.isoft.reg.repository;

import io.isoft.reg.domain.StaffDict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface StaffDictRepository extends Repository<StaffDict, Long> {

	Page<StaffDict> findAll(Pageable pageable);
	List<StaffDict> findAll();
	Page<StaffDict> findByInputCodeIgnoringCase(String inputCode, Pageable pageable);
	Page<StaffDict> findByDeptCode(String deptCode, Pageable pageable);
	List<StaffDict> findByDeptCode(String deptCode);
	StaffDict findById(String id); 

}
