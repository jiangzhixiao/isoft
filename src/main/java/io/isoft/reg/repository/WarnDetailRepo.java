package io.isoft.reg.repository;

import io.isoft.reg.domain.MonitorWarnDetail;
import org.springframework.data.repository.Repository;

public interface WarnDetailRepo extends Repository<MonitorWarnDetail, String> {

	MonitorWarnDetail findByRecordId(String recordId);
}
