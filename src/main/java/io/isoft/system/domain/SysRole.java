package io.isoft.system.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2015-12-03.
 */
@Entity
@Table(name = "SYS_ROLE")
public class SysRole {

    @Id
    @Column(name = "ROLE_CODE", nullable = false, length = 10)
    private String roleCode;

    @Basic
    @Column(name = "ROLE_NAME", nullable = true, length = 60)
    private String roleName;

    @Basic
    @Column(name = "SHARE_INDIC", nullable = true, length = 1)
    private String shareIndic;

//    @ManyToMany(mappedBy="roles")
//    private Set<SysUser> users = new HashSet<SysUser>();

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name="SYS_ROLE_MENU",
            joinColumns={@JoinColumn(name="ROLE_CODE",referencedColumnName="ROLE_CODE")},
            inverseJoinColumns={@JoinColumn(name="MENU_NO",referencedColumnName = "MENU_NO")})
    private Set<SysMenu> menus = new HashSet<SysMenu>();

//    public Set<SysUser> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<SysUser> users) {
//        this.users = users;
//    }

    public Set<SysMenu> getMenus() {

        return menus;
    }

    public void setMenus(Set<SysMenu> menus) {
        this.menus = menus;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    public String getShareIndic() {
        return shareIndic;
    }

    public void setShareIndic(String shareIndic) {
        this.shareIndic = shareIndic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysRole sysRole = (SysRole) o;

        if (roleCode != null ? !roleCode.equals(sysRole.roleCode) : sysRole.roleCode != null) return false;
        if (roleName != null ? !roleName.equals(sysRole.roleName) : sysRole.roleName != null) return false;
        if (shareIndic != null ? !shareIndic.equals(sysRole.shareIndic) : sysRole.shareIndic != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleCode != null ? roleCode.hashCode() : 0;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (shareIndic != null ? shareIndic.hashCode() : 0);
        return result;
    }
}
