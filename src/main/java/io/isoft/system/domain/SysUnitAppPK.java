package io.isoft.system.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Administrator on 2015-11-18.
 */
public class SysUnitAppPK implements Serializable {
    private String unitsCode;
    private String application;

    @Column(name = "UNITS_CODE", nullable = false, insertable = true, updatable = true, length = 10)
    @Id
    public String getUnitsCode() {
        return unitsCode;
    }

    public void setUnitsCode(String unitsCode) {
        this.unitsCode = unitsCode;
    }

    @Column(name = "APPLICATION", nullable = false, insertable = true, updatable = true, length = 24)
    @Id
    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUnitAppPK that = (SysUnitAppPK) o;

        if (unitsCode != null ? !unitsCode.equals(that.unitsCode) : that.unitsCode != null) return false;
        if (application != null ? !application.equals(that.application) : that.application != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = unitsCode != null ? unitsCode.hashCode() : 0;
        result = 31 * result + (application != null ? application.hashCode() : 0);
        return result;
    }
}
