package io.isoft.reg.service;

import io.isoft.base.filter.MyFilter;
import io.isoft.base.filter.MyFilterResult;
import io.isoft.reg.domain.MonitorUsersConfig;

public interface UserCfgService {
	MonitorUsersConfig getUserCfg(String autoId);
	MonitorUsersConfig addUserCfg(MonitorUsersConfig config);
	MyFilterResult getUserCfg(MyFilter filter);
}
