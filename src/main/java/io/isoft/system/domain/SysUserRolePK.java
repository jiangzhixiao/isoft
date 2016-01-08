package io.isoft.system.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Administrator on 2015-11-18.
 */
public class SysUserRolePK implements Serializable {
    private String userCode;
    private String roleCode;

    @Column(name = "USER_CODE", nullable = false, insertable = true, updatable = true, length = 12)
    @Id
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Column(name = "ROLE_CODE", nullable = false, insertable = true, updatable = true, length = 10)
    @Id
    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUserRolePK that = (SysUserRolePK) o;

        if (userCode != null ? !userCode.equals(that.userCode) : that.userCode != null) return false;
        if (roleCode != null ? !roleCode.equals(that.roleCode) : that.roleCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userCode != null ? userCode.hashCode() : 0;
        result = 31 * result + (roleCode != null ? roleCode.hashCode() : 0);
        return result;
    }
}
