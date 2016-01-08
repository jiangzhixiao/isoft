package io.isoft.reg.repository;

import io.isoft.reg.domain.MonitorUsersConfig;
import org.springframework.data.repository.Repository;

public interface WarnUserCfgRepo extends Repository<MonitorUsersConfig, Long> {
	MonitorUsersConfig findByAutoId(String autoId);
	MonitorUsersConfig save(MonitorUsersConfig config);
}
