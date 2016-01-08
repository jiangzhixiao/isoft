package io.isoft.system.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2015-11-18.
 */
@Entity
@Table(name = "SYS_UNIT_INFOR", schema = "SUPBLOOD", catalog = "")
public class SysUnitInfor {
    private String unitsCode;
    private String unitsName;
    private String unitsSimpleName;
    private String organCode;
    private String corporation;
    private String phone;
    private String fax;
    private String address;
    private String zipCode;
    private String eMail;
    private String taxCode;
    private String remark;
    private String state;
    private String codeLevel;
    private String parentCode;
    private String endSign;
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

    @Basic
    @Column(name = "UNITS_NAME", nullable = true, insertable = true, updatable = true, length = 60)
    public String getUnitsName() {
        return unitsName;
    }

    public void setUnitsName(String unitsName) {
        this.unitsName = unitsName;
    }

    @Basic
    @Column(name = "UNITS_SIMPLE_NAME", nullable = true, insertable = true, updatable = true, length = 60)
    public String getUnitsSimpleName() {
        return unitsSimpleName;
    }

    public void setUnitsSimpleName(String unitsSimpleName) {
        this.unitsSimpleName = unitsSimpleName;
    }

    @Basic
    @Column(name = "ORGAN_CODE", nullable = true, insertable = true, updatable = true, length = 20)
    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    @Basic
    @Column(name = "CORPORATION", nullable = true, insertable = true, updatable = true, length = 40)
    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    @Basic
    @Column(name = "PHONE", nullable = true, insertable = true, updatable = true, length = 50)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "FAX", nullable = true, insertable = true, updatable = true, length = 50)
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Basic
    @Column(name = "ADDRESS", nullable = true, insertable = true, updatable = true, length = 80)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "ZIP_CODE", nullable = true, insertable = true, updatable = true, length = 6)
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Basic
    @Column(name = "E_MAIL", nullable = true, insertable = true, updatable = true, length = 40)
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Basic
    @Column(name = "TAX_CODE", nullable = true, insertable = true, updatable = true, length = 20)
    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    @Basic
    @Column(name = "REMARK", nullable = true, insertable = true, updatable = true, length = 100)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "STATE", nullable = true, insertable = true, updatable = true, length = 1)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "CODE_LEVEL", nullable = true, insertable = true, updatable = true, length = 1)
    public String getCodeLevel() {
        return codeLevel;
    }

    public void setCodeLevel(String codeLevel) {
        this.codeLevel = codeLevel;
    }

    @Basic
    @Column(name = "PARENT_CODE", nullable = true, insertable = true, updatable = true, length = 20)
    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    @Basic
    @Column(name = "END_SIGN", nullable = true, insertable = true, updatable = true, length = 1)
    public String getEndSign() {
        return endSign;
    }

    public void setEndSign(String endSign) {
        this.endSign = endSign;
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

        SysUnitInfor that = (SysUnitInfor) o;

        if (unitsCode != null ? !unitsCode.equals(that.unitsCode) : that.unitsCode != null) return false;
        if (unitsName != null ? !unitsName.equals(that.unitsName) : that.unitsName != null) return false;
        if (unitsSimpleName != null ? !unitsSimpleName.equals(that.unitsSimpleName) : that.unitsSimpleName != null)
            return false;
        if (organCode != null ? !organCode.equals(that.organCode) : that.organCode != null) return false;
        if (corporation != null ? !corporation.equals(that.corporation) : that.corporation != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (fax != null ? !fax.equals(that.fax) : that.fax != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (zipCode != null ? !zipCode.equals(that.zipCode) : that.zipCode != null) return false;
        if (eMail != null ? !eMail.equals(that.eMail) : that.eMail != null) return false;
        if (taxCode != null ? !taxCode.equals(that.taxCode) : that.taxCode != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (codeLevel != null ? !codeLevel.equals(that.codeLevel) : that.codeLevel != null) return false;
        if (parentCode != null ? !parentCode.equals(that.parentCode) : that.parentCode != null) return false;
        if (endSign != null ? !endSign.equals(that.endSign) : that.endSign != null) return false;
        if (modifyPerson != null ? !modifyPerson.equals(that.modifyPerson) : that.modifyPerson != null) return false;
        if (modifyDate != null ? !modifyDate.equals(that.modifyDate) : that.modifyDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = unitsCode != null ? unitsCode.hashCode() : 0;
        result = 31 * result + (unitsName != null ? unitsName.hashCode() : 0);
        result = 31 * result + (unitsSimpleName != null ? unitsSimpleName.hashCode() : 0);
        result = 31 * result + (organCode != null ? organCode.hashCode() : 0);
        result = 31 * result + (corporation != null ? corporation.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (taxCode != null ? taxCode.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (codeLevel != null ? codeLevel.hashCode() : 0);
        result = 31 * result + (parentCode != null ? parentCode.hashCode() : 0);
        result = 31 * result + (endSign != null ? endSign.hashCode() : 0);
        result = 31 * result + (modifyPerson != null ? modifyPerson.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        return result;
    }
}
