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

package io.isoft.system.service;
import io.isoft.base.filter.MyFilter;
import io.isoft.base.filter.MyFilterResult;
import io.isoft.system.domain.SysUser;

import java.util.Map;

public interface SysUserService {
	SysUser getSysUser(String userCode);
	SysUser getSysUser(Map<String,String> params);
	MyFilterResult getSysUsers(MyFilter filter);
}
