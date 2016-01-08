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

package io.isoft.reg.service;

import io.isoft.base.filter.MyFilter;
import io.isoft.base.filter.MyFilterResult;
import io.isoft.base.filter.MyPrintExportFilter;
import io.isoft.reg.domain.StaffDict;
import io.isoft.reg.repository.criteria.StaffDictSearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StaffDictService {

	Page<StaffDict> findStaffs(StaffDictSearchCriteria criteria, Pageable pageable);
	List<StaffDict> findStaffs(StaffDictSearchCriteria criteria);
	StaffDict getStaffDict(String id);

	//flex端调用
	MyFilterResult findByFilter(MyPrintExportFilter filter);
	MyFilterResult findByFilter(MyFilter filter);
}
