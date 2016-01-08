package io.isoft.system.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2015-11-30.
 */
@Entity
@Table(name = "SYS_USER_LOG", schema = "SUPBLOOD", catalog = "")
public class SysUserLog {
    private String logNo;
    private String userCode;
    private String application;
    private Timestamp logonTime;
    private String computerName;
    private String operaItem;
    private String operaValue;
    private String remark;
    private String userName;
    private String deptName;

    @Id
    @Column(name = "LOG_NO", nullable = false, length = 20)
    public String getLogNo() {
        return logNo;
    }

    public void setLogNo(String logNo) {
        this.logNo = logNo;
    }

    @Basic
    @Column(name = "USER_CODE", nullable = false, length = 12)
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Basic
    @Column(name = "APPLICATION", nullable = false, length = 24)
    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    @Basic
    @Column(name = "LOGON_TIME", nullable = false)
    public Timestamp getLogonTime() {
        return logonTime;
    }

    public void setLogonTime(Timestamp logonTime) {
        this.logonTime = logonTime;
    }

    @Basic
    @Column(name = "COMPUTER_NAME", nullable = true, length = 80)
    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    @Basic
    @Column(name = "OPERA_ITEM", nullable = true, length = 60)
    public String getOperaItem() {
        return operaItem;
    }

    public void setOperaItem(String operaItem) {
        this.operaItem = operaItem;
    }

    @Basic
    @Column(name = "OPERA_VALUE", nullable = true, length = 40)
    public String getOperaValue() {
        return operaValue;
    }

    public void setOperaValue(String operaValue) {
        this.operaValue = operaValue;
    }

    @Basic
    @Column(name = "REMARK", nullable = true, length = 100)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "USER_NAME", nullable = true, length = 20)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "DEPT_NAME", nullable = true, length = 20)
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

        SysUserLog that = (SysUserLog) o;

        if (logNo != null ? !logNo.equals(that.logNo) : that.logNo != null) return false;
        if (userCode != null ? !userCode.equals(that.userCode) : that.userCode != null) return false;
        if (application != null ? !application.equals(that.application) : that.application != null) return false;
        if (logonTime != null ? !logonTime.equals(that.logonTime) : that.logonTime != null) return false;
        if (computerName != null ? !computerName.equals(that.computerName) : that.computerName != null) return false;
        if (operaItem != null ? !operaItem.equals(that.operaItem) : that.operaItem != null) return false;
        if (operaValue != null ? !operaValue.equals(that.operaValue) : that.operaValue != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (deptName != null ? !deptName.equals(that.deptName) : that.deptName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = logNo != null ? logNo.hashCode() : 0;
        result = 31 * result + (userCode != null ? userCode.hashCode() : 0);
        result = 31 * result + (application != null ? application.hashCode() : 0);
        result = 31 * result + (logonTime != null ? logonTime.hashCode() : 0);
        result = 31 * result + (computerName != null ? computerName.hashCode() : 0);
        result = 31 * result + (operaItem != null ? operaItem.hashCode() : 0);
        result = 31 * result + (operaValue != null ? operaValue.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (deptName != null ? deptName.hashCode() : 0);
        return result;
    }
}
