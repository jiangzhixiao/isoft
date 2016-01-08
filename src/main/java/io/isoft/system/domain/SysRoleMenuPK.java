package io.isoft.system.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Administrator on 2015-11-30.
 */
public class SysRoleMenuPK implements Serializable {
    private String roleCode;
    private String menuNo;

    @Column(name = "ROLE_CODE", nullable = false, length = 10)
    @Id
    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }


    @Column(name = "MENU_NO", nullable = false, length = 20)
    @Id
    public String getMenuNo() {
        return menuNo;
    }

    public void setMenuNo(String menuNo) {
        this.menuNo = menuNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysRoleMenuPK that = (SysRoleMenuPK) o;

        if (roleCode != null ? !roleCode.equals(that.roleCode) : that.roleCode != null) return false;
        if (menuNo != null ? !menuNo.equals(that.menuNo) : that.menuNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleCode != null ? roleCode.hashCode() : 0;
        result = 31 * result + (menuNo != null ? menuNo.hashCode() : 0);
        return result;
    }
}
