package io.isoft.reg.service;

import io.isoft.base.filter.MyFilter;
import io.isoft.base.filter.MyFilterResult;
import io.isoft.reg.domain.MonitorWarnDetail;
import io.isoft.reg.domain.MonitorWarnMaster;

public interface WarnService {
	MonitorWarnMaster getWarnMaster(String wardId);
	MonitorWarnDetail getWarnDetail(String recordId);
	
	MyFilterResult getWarnMaster(MyFilter filter);
	MyFilterResult getWarnDetail(MyFilter filter);
}
