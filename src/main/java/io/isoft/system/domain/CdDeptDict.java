package io.isoft.system.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2015-11-30.
 */
@Entity
@javax.persistence.Table(name = "CD_DEPT_DICT")
public class CdDeptDict implements Serializable {
    private String unitsCode;

    @Id
    @javax.persistence.Column(name = "UNITS_CODE", nullable = false, length = 10)
    public String getUnitsCode() {
        return unitsCode;
    }

    public void setUnitsCode(String unitsCode) {
        this.unitsCode = unitsCode;
    }

    private String deptCode;

    @Id
    @javax.persistence.Column(name = "DEPT_CODE", nullable = false, length = 20)
    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    private String deptName;

    @Basic
    @javax.persistence.Column(name = "DEPT_NAME", nullable = false, length = 40)
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    private String director;

    @Basic
    @javax.persistence.Column(name = "DIRECTOR", nullable = true, length = 20)
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    private String attribute;

    @Basic
    @javax.persistence.Column(name = "ATTRIBUTE", nullable = true, length = 20)
    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    private String nationCode;

    @Basic
    @javax.persistence.Column(name = "NATION_CODE", nullable = true, length = 20)
    public String getNationCode() {
        return nationCode;
    }

    public void setNationCode(String nationCode) {
        this.nationCode = nationCode;
    }

    private String address;

    @Basic
    @javax.persistence.Column(name = "ADDRESS", nullable = true, length = 40)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String clinicType;

    @Basic
    @javax.persistence.Column(name = "CLINIC_TYPE", nullable = true, length = 1)
    public String getClinicType() {
        return clinicType;
    }

    public void setClinicType(String clinicType) {
        this.clinicType = clinicType;
    }

    private BigDecimal bedNum;

    @Basic
    @javax.persistence.Column(name = "BED_NUM", nullable = true, precision = 1)
    public BigDecimal getBedNum() {
        return bedNum;
    }

    public void setBedNum(BigDecimal bedNum) {
        this.bedNum = bedNum;
    }

    private String specialDeptSign;

    @Basic
    @javax.persistence.Column(name = "SPECIAL_DEPT_SIGN", nullable = true, length = 1)
    public String getSpecialDeptSign() {
        return specialDeptSign;
    }

    public void setSpecialDeptSign(String specialDeptSign) {
        this.specialDeptSign = specialDeptSign;
    }

    private String deptSign;

    @Basic
    @javax.persistence.Column(name = "DEPT_SIGN", nullable = true, length = 1)
    public String getDeptSign() {
        return deptSign;
    }

    public void setDeptSign(String deptSign) {
        this.deptSign = deptSign;
    }

    private String groupSign;

    @Basic
    @javax.persistence.Column(name = "GROUP_SIGN", nullable = true, length = 1)
    public String getGroupSign() {
        return groupSign;
    }

    public void setGroupSign(String groupSign) {
        this.groupSign = groupSign;
    }

    private String openClinicSign;

    @Basic
    @javax.persistence.Column(name = "OPEN_CLINIC_SIGN", nullable = true, length = 1)
    public String getOpenClinicSign() {
        return openClinicSign;
    }

    public void setOpenClinicSign(String openClinicSign) {
        this.openClinicSign = openClinicSign;
    }

    private String openWardSign;

    @Basic
    @javax.persistence.Column(name = "OPEN_WARD_SIGN", nullable = true, length = 1)
    public String getOpenWardSign() {
        return openWardSign;
    }

    public void setOpenWardSign(String openWardSign) {
        this.openWardSign = openWardSign;
    }

    private String openEmergSign;

    @Basic
    @javax.persistence.Column(name = "OPEN_EMERG_SIGN", nullable = true, length = 1)
    public String getOpenEmergSign() {
        return openEmergSign;
    }

    public void setOpenEmergSign(String openEmergSign) {
        this.openEmergSign = openEmergSign;
    }

    private String openFamilyBedSign;

    @Basic
    @javax.persistence.Column(name = "OPEN_FAMILY_BED_SIGN", nullable = true, length = 1)
    public String getOpenFamilyBedSign() {
        return openFamilyBedSign;
    }

    public void setOpenFamilyBedSign(String openFamilyBedSign) {
        this.openFamilyBedSign = openFamilyBedSign;
    }

    private String openObserveSign;

    @Basic
    @javax.persistence.Column(name = "OPEN_OBSERVE_SIGN", nullable = true, length = 1)
    public String getOpenObserveSign() {
        return openObserveSign;
    }

    public void setOpenObserveSign(String openObserveSign) {
        this.openObserveSign = openObserveSign;
    }

    private String codeLevel;

    @Basic
    @javax.persistence.Column(name = "CODE_LEVEL", nullable = true, length = 1)
    public String getCodeLevel() {
        return codeLevel;
    }

    public void setCodeLevel(String codeLevel) {
        this.codeLevel = codeLevel;
    }

    private String parentCode;

    @Basic
    @javax.persistence.Column(name = "PARENT_CODE", nullable = true, length = 20)
    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    private String endSign;

    @Basic
    @javax.persistence.Column(name = "END_SIGN", nullable = true, length = 1)
    public String getEndSign() {
        return endSign;
    }

    public void setEndSign(String endSign) {
        this.endSign = endSign;
    }

    private String remark;

    @Basic
    @javax.persistence.Column(name = "REMARK", nullable = true, length = 256)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    private String phoInputCode;

    @Basic
    @javax.persistence.Column(name = "PHO_INPUT_CODE", nullable = true, length = 10)
    public String getPhoInputCode() {
        return phoInputCode;
    }

    public void setPhoInputCode(String phoInputCode) {
        this.phoInputCode = phoInputCode;
    }

    private String fiveInputCode;

    @Basic
    @javax.persistence.Column(name = "FIVE_INPUT_CODE", nullable = true, length = 10)
    public String getFiveInputCode() {
        return fiveInputCode;
    }

    public void setFiveInputCode(String fiveInputCode) {
        this.fiveInputCode = fiveInputCode;
    }

    private String oprSign;

    @Basic
    @javax.persistence.Column(name = "OPR_SIGN", nullable = true, length = 1)
    public String getOprSign() {
        return oprSign;
    }

    public void setOprSign(String oprSign) {
        this.oprSign = oprSign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CdDeptDict that = (CdDeptDict) o;

        if (unitsCode != null ? !unitsCode.equals(that.unitsCode) : that.unitsCode != null) return false;
        if (deptCode != null ? !deptCode.equals(that.deptCode) : that.deptCode != null) return false;
        if (deptName != null ? !deptName.equals(that.deptName) : that.deptName != null) return false;
        if (director != null ? !director.equals(that.director) : that.director != null) return false;
        if (attribute != null ? !attribute.equals(that.attribute) : that.attribute != null) return false;
        if (nationCode != null ? !nationCode.equals(that.nationCode) : that.nationCode != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (clinicType != null ? !clinicType.equals(that.clinicType) : that.clinicType != null) return false;
        if (bedNum != null ? !bedNum.equals(that.bedNum) : that.bedNum != null) return false;
        if (specialDeptSign != null ? !specialDeptSign.equals(that.specialDeptSign) : that.specialDeptSign != null)
            return false;
        if (deptSign != null ? !deptSign.equals(that.deptSign) : that.deptSign != null) return false;
        if (groupSign != null ? !groupSign.equals(that.groupSign) : that.groupSign != null) return false;
        if (openClinicSign != null ? !openClinicSign.equals(that.openClinicSign) : that.openClinicSign != null)
            return false;
        if (openWardSign != null ? !openWardSign.equals(that.openWardSign) : that.openWardSign != null) return false;
        if (openEmergSign != null ? !openEmergSign.equals(that.openEmergSign) : that.openEmergSign != null)
            return false;
        if (openFamilyBedSign != null ? !openFamilyBedSign.equals(that.openFamilyBedSign) : that.openFamilyBedSign != null)
            return false;
        if (openObserveSign != null ? !openObserveSign.equals(that.openObserveSign) : that.openObserveSign != null)
            return false;
        if (codeLevel != null ? !codeLevel.equals(that.codeLevel) : that.codeLevel != null) return false;
        if (parentCode != null ? !parentCode.equals(that.parentCode) : that.parentCode != null) return false;
        if (endSign != null ? !endSign.equals(that.endSign) : that.endSign != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (phoInputCode != null ? !phoInputCode.equals(that.phoInputCode) : that.phoInputCode != null) return false;
        if (fiveInputCode != null ? !fiveInputCode.equals(that.fiveInputCode) : that.fiveInputCode != null)
            return false;
        if (oprSign != null ? !oprSign.equals(that.oprSign) : that.oprSign != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = unitsCode != null ? unitsCode.hashCode() : 0;
        result = 31 * result + (deptCode != null ? deptCode.hashCode() : 0);
        result = 31 * result + (deptName != null ? deptName.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + (attribute != null ? attribute.hashCode() : 0);
        result = 31 * result + (nationCode != null ? nationCode.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (clinicType != null ? clinicType.hashCode() : 0);
        result = 31 * result + (bedNum != null ? bedNum.hashCode() : 0);
        result = 31 * result + (specialDeptSign != null ? specialDeptSign.hashCode() : 0);
        result = 31 * result + (deptSign != null ? deptSign.hashCode() : 0);
        result = 31 * result + (groupSign != null ? groupSign.hashCode() : 0);
        result = 31 * result + (openClinicSign != null ? openClinicSign.hashCode() : 0);
        result = 31 * result + (openWardSign != null ? openWardSign.hashCode() : 0);
        result = 31 * result + (openEmergSign != null ? openEmergSign.hashCode() : 0);
        result = 31 * result + (openFamilyBedSign != null ? openFamilyBedSign.hashCode() : 0);
        result = 31 * result + (openObserveSign != null ? openObserveSign.hashCode() : 0);
        result = 31 * result + (codeLevel != null ? codeLevel.hashCode() : 0);
        result = 31 * result + (parentCode != null ? parentCode.hashCode() : 0);
        result = 31 * result + (endSign != null ? endSign.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (phoInputCode != null ? phoInputCode.hashCode() : 0);
        result = 31 * result + (fiveInputCode != null ? fiveInputCode.hashCode() : 0);
        result = 31 * result + (oprSign != null ? oprSign.hashCode() : 0);
        return result;
    }
}
