package io.isoft.system.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2015-12-01.
 */
@Entity
@Table(name = "SYS_MENU")
public class SysMenu  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "MENU_NO", nullable = false, length = 20)
    private String menuNo;

    @Column(name = "MENU_NAME", nullable = true, length = 40)
    private String menuName;

    @Column(name = "MENU_ICON", nullable = true, length = 80)
    private String menuIcon;

    @Column(name = "MODULE_SIMPLE", nullable = true, length = 120)
    private String moduleSimple;

    @Basic
    @Column(name = "MODULE_DETAIL", nullable = true, length = 120)
    private String moduleDetail;

    @Column(name = "EXECUTE_SIGN", nullable = true, length = 1)
    private String executeSign;

    @Column(name = "SERIAL_NO", nullable = true, length = 3)
    private String serialNo;

    @Basic
    @Column(name = "USER_DEFINED_SIGN", nullable = true, length = 1)
    private String userDefinedSign;

    @Column(name = "LOGIC_VALIDATE", nullable = true, length = 80)
    private String logicValidate;

    @Column(name = "PARENT_NO", nullable = true, length = 20)
    private String parentNo;

    @Column(name = "REMARK", nullable = true, length = 20)
    private String remark;

    @Column(name = "CODE_LEVEL", nullable = true, length = 1)
    private String codeLevel;

    @Column(name = "CURRENT_STATUS", nullable = true, length = 1)
    private String currentStatus;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

//    @ManyToMany(mappedBy= "menus")
//    private Set<SysRole> roles = new HashSet<SysRole>();
//    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JoinTable(name="SYS_ROLE_MENU",
//            joinColumns={@JoinColumn(name="MENU_NO",referencedColumnName="MENU_NO")},
//            inverseJoinColumns={@JoinColumn(name="ROLE_CODE",referencedColumnName = "ROLE_CODE")})
//    private Set<SysRole> menuRoles = new HashSet<SysRole>();

//    public Set<SysRole> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<SysRole> roles) {
//        this.roles = roles;
//    }


    public String getMenuNo() {
        return menuNo;
    }

    public void setMenuNo(String menuNo) {
        this.menuNo = menuNo;
    }


    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }


    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }


    public String getModuleSimple() {
        return moduleSimple;
    }

    public void setModuleSimple(String moduleSimple) {
        this.moduleSimple = moduleSimple;
    }


    public String getModuleDetail() {
        return moduleDetail;
    }

    public void setModuleDetail(String moduleDetail) {
        this.moduleDetail = moduleDetail;
    }


    public String getExecuteSign() {
        return executeSign;
    }

    public void setExecuteSign(String executeSign) {
        this.executeSign = executeSign;
    }


    public String getUserDefinedSign() {
        return userDefinedSign;
    }

    public void setUserDefinedSign(String userDefinedSign) {
        this.userDefinedSign = userDefinedSign;
    }


    public String getLogicValidate() {
        return logicValidate;
    }

    public void setLogicValidate(String logicValidate) {
        this.logicValidate = logicValidate;
    }


    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }


    public String getParentNo() {
        return parentNo;
    }

    public void setParentNo(String parentNo) {
        this.parentNo = parentNo;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public String getCodeLevel() {
        return codeLevel;
    }

    public void setCodeLevel(String codeLevel) {
        this.codeLevel = codeLevel;
    }


    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysMenu that = (SysMenu) o;

        if (menuNo != null ? !menuNo.equals(that.menuNo) : that.menuNo != null) return false;
        if (menuName != null ? !menuName.equals(that.menuName) : that.menuName != null) return false;
        if (menuIcon != null ? !menuIcon.equals(that.menuIcon) : that.menuIcon != null) return false;
        if (moduleSimple != null ? !moduleSimple.equals(that.moduleSimple) : that.moduleSimple != null) return false;
        if (moduleDetail != null ? !moduleDetail.equals(that.moduleDetail) : that.moduleDetail != null) return false;
        if (executeSign != null ? !executeSign.equals(that.executeSign) : that.executeSign != null) return false;
        if (userDefinedSign != null ? !userDefinedSign.equals(that.userDefinedSign) : that.userDefinedSign != null)
            return false;
        if (logicValidate != null ? !logicValidate.equals(that.logicValidate) : that.logicValidate != null)
            return false;
        if (serialNo != null ? !serialNo.equals(that.serialNo) : that.serialNo != null) return false;
        if (parentNo != null ? !parentNo.equals(that.parentNo) : that.parentNo != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (codeLevel != null ? !codeLevel.equals(that.codeLevel) : that.codeLevel != null) return false;
        if (currentStatus != null ? !currentStatus.equals(that.currentStatus) : that.currentStatus != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = menuNo != null ? menuNo.hashCode() : 0;
        result = 31 * result + (menuName != null ? menuName.hashCode() : 0);
        result = 31 * result + (menuIcon != null ? menuIcon.hashCode() : 0);
        result = 31 * result + (moduleSimple != null ? moduleSimple.hashCode() : 0);
        result = 31 * result + (moduleDetail != null ? moduleDetail.hashCode() : 0);
        result = 31 * result + (executeSign != null ? executeSign.hashCode() : 0);
        result = 31 * result + (userDefinedSign != null ? userDefinedSign.hashCode() : 0);
        result = 31 * result + (logicValidate != null ? logicValidate.hashCode() : 0);
        result = 31 * result + (serialNo != null ? serialNo.hashCode() : 0);
        result = 31 * result + (parentNo != null ? parentNo.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (codeLevel != null ? codeLevel.hashCode() : 0);
        result = 31 * result + (currentStatus != null ? currentStatus.hashCode() : 0);
        return result;
    }

}
