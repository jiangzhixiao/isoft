package io.isoft.system.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Administrator on 2015-11-18.
 */
@Entity
@Table(name = "SYS_USER_ROLE", schema = "SUPBLOOD", catalog = "")
@IdClass(SysUserRolePK.class)
public class SysUserRole {
    private String userCode;
    private String roleCode;
    private String password;

    @Id
    @Column(name = "USER_CODE", nullable = false, insertable = true, updatable = true, length = 12)
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Id
    @Column(name = "ROLE_CODE", nullable = false, insertable = true, updatable = true, length = 10)
    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @Basic
    @Column(name = "PASSWORD", nullable = true, insertable = true, updatable = true, length = 30)


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUserRole that = (SysUserRole) o;

        if (userCode != null ? !userCode.equals(that.userCode) : that.userCode != null) return false;
        if (roleCode != null ? !roleCode.equals(that.roleCode) : that.roleCode != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userCode != null ? userCode.hashCode() : 0;
        result = 31 * result + (roleCode != null ? roleCode.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
