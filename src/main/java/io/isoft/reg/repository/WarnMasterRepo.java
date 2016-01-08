package io.isoft.reg.repository;

import io.isoft.reg.domain.MonitorWarnMaster;
import org.springframework.data.repository.Repository;

public interface WarnMasterRepo extends Repository<MonitorWarnMaster, String> {
	MonitorWarnMaster findByWarnId(String warnId);
}
