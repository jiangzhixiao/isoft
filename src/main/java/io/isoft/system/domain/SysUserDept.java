package io.isoft.system.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2015-11-18.
 */
@Entity
@Table(name = "SYS_USER_DEPT", schema = "SUPBLOOD", catalog = "")
public class SysUserDept {
    private BigDecimal id;
    private String unitsCode;
    private String userCode;
    private String userName;
    private String deptCode;
    private String deptName;

    @Basic
    @Id
    @Column(name = "ID", nullable = true, insertable = true, updatable = true, precision = -127)
    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    @Basic
    @Column(name = "UNITS_CODE", nullable = false, insertable = true, updatable = true, length = 10)
    public String getUnitsCode() {
        return unitsCode;
    }

    public void setUnitsCode(String unitsCode) {
        this.unitsCode = unitsCode;
    }

    @Basic
    @Column(name = "USER_CODE", nullable = false, insertable = true, updatable = true, length = 20)
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Basic
    @Column(name = "USER_NAME", nullable = true, insertable = true, updatable = true, length = 20)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "DEPT_CODE", nullable = false, insertable = true, updatable = true, length = 20)
    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    @Basic
    @Column(name = "DEPT_NAME", nullable = false, insertable = true, updatable = true, length = 40)
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUserDept that = (SysUserDept) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (unitsCode != null ? !unitsCode.equals(that.unitsCode) : that.unitsCode != null) return false;
        if (userCode != null ? !userCode.equals(that.userCode) : that.userCode != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (deptCode != null ? !deptCode.equals(that.deptCode) : that.deptCode != null) return false;
        if (deptName != null ? !deptName.equals(that.deptName) : that.deptName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (unitsCode != null ? unitsCode.hashCode() : 0);
        result = 31 * result + (userCode != null ? userCode.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (deptCode != null ? deptCode.hashCode() : 0);
        result = 31 * result + (deptName != null ? deptName.hashCode() : 0);
        return result;
    }
}
