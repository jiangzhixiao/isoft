package io.isoft.system.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2015-11-18.
 */
@Entity
@Table(name = "SYS_UNIT_APP", schema = "SUPBLOOD", catalog = "")
@IdClass(SysUnitAppPK.class)
public class SysUnitApp {
    private String unitsCode;
    private String application;
    private String useType;
    private Timestamp startDate;
    private Timestamp stopDate;
    private String authorCode;
    private String modifyPerson;
    private Timestamp modifyDate;

    @Id
    @Column(name = "UNITS_CODE", nullable = false, insertable = true, updatable = true, length = 10)
    public String getUnitsCode() {
        return unitsCode;
    }

    public void setUnitsCode(String unitsCode) {
        this.unitsCode = unitsCode;
    }

    @Id
    @Column(name = "APPLICATION", nullable = false, insertable = true, updatable = true, length = 24)
    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    @Basic
    @Column(name = "USE_TYPE", nullable = true, insertable = true, updatable = true, length = 1)
    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    @Basic
    @Column(name = "START_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "STOP_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getStopDate() {
        return stopDate;
    }

    public void setStopDate(Timestamp stopDate) {
        this.stopDate = stopDate;
    }

    @Basic
    @Column(name = "AUTHOR_CODE", nullable = true, insertable = true, updatable = true, length = 64)
    public String getAuthorCode() {
        return authorCode;
    }

    public void setAuthorCode(String authorCode) {
        this.authorCode = authorCode;
    }

    @Basic
    @Column(name = "MODIFY_PERSON", nullable = true, insertable = true, updatable = true, length = 20)
    public String getModifyPerson() {
        return modifyPerson;
    }

    public void setModifyPerson(String modifyPerson) {
        this.modifyPerson = modifyPerson;
    }

    @Basic
    @Column(name = "MODIFY_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUnitApp that = (SysUnitApp) o;

        if (unitsCode != null ? !unitsCode.equals(that.unitsCode) : that.unitsCode != null) return false;
        if (application != null ? !application.equals(that.application) : that.application != null) return false;
        if (useType != null ? !useType.equals(that.useType) : that.useType != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (stopDate != null ? !stopDate.equals(that.stopDate) : that.stopDate != null) return false;
        if (authorCode != null ? !authorCode.equals(that.authorCode) : that.authorCode != null) return false;
        if (modifyPerson != null ? !modifyPerson.equals(that.modifyPerson) : that.modifyPerson != null) return false;
        if (modifyDate != null ? !modifyDate.equals(that.modifyDate) : that.modifyDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = unitsCode != null ? unitsCode.hashCode() : 0;
        result = 31 * result + (application != null ? application.hashCode() : 0);
        result = 31 * result + (useType != null ? useType.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (stopDate != null ? stopDate.hashCode() : 0);
        result = 31 * result + (authorCode != null ? authorCode.hashCode() : 0);
        result = 31 * result + (modifyPerson != null ? modifyPerson.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        return result;
    }
}
