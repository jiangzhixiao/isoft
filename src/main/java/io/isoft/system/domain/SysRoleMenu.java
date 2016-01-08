package io.isoft.system.domain;

import javax.persistence.*;

/**
 * Created by Administrator on 2015-11-30.
 */
@Entity
@Table(name = "SYS_ROLE_MENU")
@IdClass(SysRoleMenuPK.class)
public class SysRoleMenu {
    private String roleCode;
    private String menuNo;
    private String purviewNo;
    private String purviewName; // 扩充
    private String oftenUse;

    private String parentCode;// 上级编码

    private boolean hasPurview; // 0：否；1：是
    private String menuName; // 扩充
    private String menuIcon; // 菜单图标
    private String moduleDetail; // 执行模块路径名称

    @Id
    @Column(name = "ROLE_CODE", nullable = false, length = 10)
    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }


    @Id
    @Column(name = "MENU_NO", nullable = false, length = 20)
    public String getMenuNo() {
        return menuNo;
    }

    public void setMenuNo(String menuNo) {
        this.menuNo = menuNo;
    }

    @Basic
    @Column(name = "PURVIEW_NO", nullable = true, length = 60)
    public String getPurviewNo() {
        return purviewNo;
    }

    public void setPurviewNo(String purviewNo) {
        this.purviewNo = purviewNo;
    }

    public void setPurviewName(String purviewName) {
        this.purviewName = purviewName;
    }

    public void setOftenUse(String oftenUse) {
        this.oftenUse = oftenUse;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public void setHasPurview(boolean hasPurview) {
        this.hasPurview = hasPurview;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public void setModuleDetail(String moduleDetail) {
        this.moduleDetail = moduleDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysRoleMenu that = (SysRoleMenu) o;

        if (roleCode != null ? !roleCode.equals(that.roleCode) : that.roleCode != null) return false;
        if (menuNo != null ? !menuNo.equals(that.menuNo) : that.menuNo != null) return false;
        if (purviewNo != null ? !purviewNo.equals(that.purviewNo) : that.purviewNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleCode != null ? roleCode.hashCode() : 0;
        result = 31 * result + (menuNo != null ? menuNo.hashCode() : 0);
        result = 31 * result + (purviewNo != null ? purviewNo.hashCode() : 0);
        return result;
    }
}
