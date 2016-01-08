package io.isoft.blood.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2015-10-08.
 */
@Entity
@javax.persistence.Table(name = "BLOOD_RDS_MASTER", schema = "SUPBLOOD", catalog = "")
public class BloodRdsMaster {
    private String autoId;

    @Id
    @javax.persistence.Column(name = "AUTO_ID", nullable = false, insertable = true, updatable = true, length = 22)
    public String getAutoId() {
        return autoId;
    }

    public void setAutoId(String autoId) {
        this.autoId = autoId;
    }

    private String unitsCode;

    @Basic
    @javax.persistence.Column(name = "UNITS_CODE", nullable = false, insertable = true, updatable = true, length = 10)
    public String getUnitsCode() {
        return unitsCode;
    }

    public void setUnitsCode(String unitsCode) {
        this.unitsCode = unitsCode;
    }

    private String billNo;

    @Basic
    @javax.persistence.Column(name = "BILL_NO", nullable = false, insertable = true, updatable = true, length = 30)
    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    private Timestamp billDate;

    @Basic
    @javax.persistence.Column(name = "BILL_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getBillDate() {
        return billDate;
    }

    public void setBillDate(Timestamp billDate) {
        this.billDate = billDate;
    }

    private String invoiceType;

    @Basic
    @javax.persistence.Column(name = "INVOICE_TYPE", nullable = true, insertable = true, updatable = true, length = 1)
    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    private String operationNo;

    @Basic
    @javax.persistence.Column(name = "OPERATION_NO", nullable = true, insertable = true, updatable = true, length = 30)
    public String getOperationNo() {
        return operationNo;
    }

    public void setOperationNo(String operationNo) {
        this.operationNo = operationNo;
    }

    private String rdFlag;

    @Basic
    @javax.persistence.Column(name = "RD_FLAG", nullable = false, insertable = true, updatable = true, length = 1)
    public String getRdFlag() {
        return rdFlag;
    }

    public void setRdFlag(String rdFlag) {
        this.rdFlag = rdFlag;
    }

    private String rdType;

    @Basic
    @javax.persistence.Column(name = "RD_TYPE", nullable = true, insertable = true, updatable = true, length = 30)
    public String getRdType() {
        return rdType;
    }

    public void setRdType(String rdType) {
        this.rdType = rdType;
    }

    private String deptCode;

    @Basic
    @javax.persistence.Column(name = "DEPT_CODE", nullable = true, insertable = true, updatable = true, length = 20)
    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    private String personId;

    @Basic
    @javax.persistence.Column(name = "PERSON_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    private String visitDoctor;

    @Basic
    @javax.persistence.Column(name = "VISIT_DOCTOR", nullable = true, insertable = true, updatable = true, length = 20)
    public String getVisitDoctor() {
        return visitDoctor;
    }

    public void setVisitDoctor(String visitDoctor) {
        this.visitDoctor = visitDoctor;
    }

    private String visitDept;

    @Basic
    @javax.persistence.Column(name = "VISIT_DEPT", nullable = true, insertable = true, updatable = true, length = 20)
    public String getVisitDept() {
        return visitDept;
    }

    public void setVisitDept(String visitDept) {
        this.visitDept = visitDept;
    }

    private String visitGroup;

    @Basic
    @javax.persistence.Column(name = "VISIT_GROUP", nullable = true, insertable = true, updatable = true, length = 20)
    public String getVisitGroup() {
        return visitGroup;
    }

    public void setVisitGroup(String visitGroup) {
        this.visitGroup = visitGroup;
    }

    private BigDecimal totalCosts;

    @Basic
    @javax.persistence.Column(name = "TOTAL_COSTS", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getTotalCosts() {
        return totalCosts;
    }

    public void setTotalCosts(BigDecimal totalCosts) {
        this.totalCosts = totalCosts;
    }

    private BigDecimal totalCharges;

    @Basic
    @javax.persistence.Column(name = "TOTAL_CHARGES", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getTotalCharges() {
        return totalCharges;
    }

    public void setTotalCharges(BigDecimal totalCharges) {
        this.totalCharges = totalCharges;
    }

    private String remark;

    @Basic
    @javax.persistence.Column(name = "REMARK", nullable = true, insertable = true, updatable = true, length = 400)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    private String maker;

    @Basic
    @javax.persistence.Column(name = "MAKER", nullable = true, insertable = true, updatable = true, length = 20)
    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    private Timestamp makeDate;

    @Basic
    @javax.persistence.Column(name = "MAKE_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getMakeDate() {
        return makeDate;
    }

    public void setMakeDate(Timestamp makeDate) {
        this.makeDate = makeDate;
    }

    private String verifier;

    @Basic
    @javax.persistence.Column(name = "VERIFIER", nullable = true, insertable = true, updatable = true, length = 20)
    public String getVerifier() {
        return verifier;
    }

    public void setVerifier(String verifier) {
        this.verifier = verifier;
    }

    private Timestamp verifyDate;

    @Basic
    @javax.persistence.Column(name = "VERIFY_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getVerifyDate() {
        return verifyDate;
    }

    public void setVerifyDate(Timestamp verifyDate) {
        this.verifyDate = verifyDate;
    }

    private String currentStatus;

    @Basic
    @javax.persistence.Column(name = "CURRENT_STATUS", nullable = true, insertable = true, updatable = true, length = 1)
    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    private String patientId;

    @Basic
    @javax.persistence.Column(name = "PATIENT_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    private BigInteger visitId;

    @Basic
    @javax.persistence.Column(name = "VISIT_ID", nullable = true, insertable = true, updatable = true, precision = 0)
    public BigInteger getVisitId() {
        return visitId;
    }

    public void setVisitId(BigInteger visitId) {
        this.visitId = visitId;
    }

    private String patientType;

    @Basic
    @javax.persistence.Column(name = "PATIENT_TYPE", nullable = true, insertable = true, updatable = true, length = 1)
    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    private Integer sampleNo;

    @Basic
    @javax.persistence.Column(name = "SAMPLE_NO", nullable = true, insertable = true, updatable = true, precision = 0)
    public Integer getSampleNo() {
        return sampleNo;
    }

    public void setSampleNo(Integer sampleNo) {
        this.sampleNo = sampleNo;
    }

    private String personName;

    @Basic
    @javax.persistence.Column(name = "PERSON_NAME", nullable = true, insertable = true, updatable = true, length = 20)
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    private String billNo2;

    @Basic
    @javax.persistence.Column(name = "BILL_NO2", nullable = true, insertable = true, updatable = true, length = 30)
    public String getBillNo2() {
        return billNo2;
    }

    public void setBillNo2(String billNo2) {
        this.billNo2 = billNo2;
    }

    private String sendVerifier;

    @Basic
    @javax.persistence.Column(name = "SEND_VERIFIER", nullable = true, insertable = true, updatable = true, length = 20)
    public String getSendVerifier() {
        return sendVerifier;
    }

    public void setSendVerifier(String sendVerifier) {
        this.sendVerifier = sendVerifier;
    }

    private String sex;

    @Basic
    @javax.persistence.Column(name = "SEX", nullable = true, insertable = true, updatable = true, length = 1)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private Integer age;

    @Basic
    @javax.persistence.Column(name = "AGE", nullable = true, insertable = true, updatable = true, precision = 0)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private String ageUnits;

    @Basic
    @javax.persistence.Column(name = "AGE_UNITS", nullable = true, insertable = true, updatable = true, length = 2)
    public String getAgeUnits() {
        return ageUnits;
    }

    public void setAgeUnits(String ageUnits) {
        this.ageUnits = ageUnits;
    }

    private String bloodCode;

    @Basic
    @javax.persistence.Column(name = "BLOOD_CODE", nullable = true, insertable = true, updatable = true, length = 2)
    public String getBloodCode() {
        return bloodCode;
    }

    public void setBloodCode(String bloodCode) {
        this.bloodCode = bloodCode;
    }

    private String rhSign;

    @Basic
    @javax.persistence.Column(name = "RH_SIGN", nullable = true, insertable = true, updatable = true, length = 1)
    public String getRhSign() {
        return rhSign;
    }

    public void setRhSign(String rhSign) {
        this.rhSign = rhSign;
    }

    private Integer bedNo;

    @Basic
    @javax.persistence.Column(name = "BED_NO", nullable = true, insertable = true, updatable = true, precision = 0)
    public Integer getBedNo() {
        return bedNo;
    }

    public void setBedNo(Integer bedNo) {
        this.bedNo = bedNo;
    }

    private String clinicDiag;

    @Basic
    @javax.persistence.Column(name = "CLINIC_DIAG", nullable = true, insertable = true, updatable = true, length = 20)
    public String getClinicDiag() {
        return clinicDiag;
    }

    public void setClinicDiag(String clinicDiag) {
        this.clinicDiag = clinicDiag;
    }

    private String clinicDiagName;

    @Basic
    @javax.persistence.Column(name = "CLINIC_DIAG_NAME", nullable = true, insertable = true, updatable = true, length = 80)
    public String getClinicDiagName() {
        return clinicDiagName;
    }

    public void setClinicDiagName(String clinicDiagName) {
        this.clinicDiagName = clinicDiagName;
    }

    private Timestamp printDate;

    @Basic
    @javax.persistence.Column(name = "PRINT_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getPrintDate() {
        return printDate;
    }

    public void setPrintDate(Timestamp printDate) {
        this.printDate = printDate;
    }

    private String transferUnit;

    @Basic
    @javax.persistence.Column(name = "TRANSFER_UNIT", nullable = true, insertable = true, updatable = true, length = 40)
    public String getTransferUnit() {
        return transferUnit;
    }

    public void setTransferUnit(String transferUnit) {
        this.transferUnit = transferUnit;
    }

    private String transfer;

    @Basic
    @javax.persistence.Column(name = "TRANSFER", nullable = true, insertable = true, updatable = true, length = 20)
    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    private String qualityAssess;

    @Basic
    @javax.persistence.Column(name = "QUALITY_ASSESS", nullable = true, insertable = true, updatable = true, length = 100)
    public String getQualityAssess() {
        return qualityAssess;
    }

    public void setQualityAssess(String qualityAssess) {
        this.qualityAssess = qualityAssess;
    }

    private String coldChainStatus;

    @Basic
    @javax.persistence.Column(name = "COLD_CHAIN_STATUS", nullable = true, insertable = true, updatable = true, length = 50)
    public String getColdChainStatus() {
        return coldChainStatus;
    }

    public void setColdChainStatus(String coldChainStatus) {
        this.coldChainStatus = coldChainStatus;
    }

    private String receiver;

    @Basic
    @javax.persistence.Column(name = "RECEIVER", nullable = true, insertable = true, updatable = true, length = 20)
    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    private Timestamp receiveDate;

    @Basic
    @javax.persistence.Column(name = "RECEIVE_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Timestamp receiveDate) {
        this.receiveDate = receiveDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BloodRdsMaster that = (BloodRdsMaster) o;

        if (autoId != null ? !autoId.equals(that.autoId) : that.autoId != null) return false;
        if (unitsCode != null ? !unitsCode.equals(that.unitsCode) : that.unitsCode != null) return false;
        if (billNo != null ? !billNo.equals(that.billNo) : that.billNo != null) return false;
        if (billDate != null ? !billDate.equals(that.billDate) : that.billDate != null) return false;
        if (invoiceType != null ? !invoiceType.equals(that.invoiceType) : that.invoiceType != null) return false;
        if (operationNo != null ? !operationNo.equals(that.operationNo) : that.operationNo != null) return false;
        if (rdFlag != null ? !rdFlag.equals(that.rdFlag) : that.rdFlag != null) return false;
        if (rdType != null ? !rdType.equals(that.rdType) : that.rdType != null) return false;
        if (deptCode != null ? !deptCode.equals(that.deptCode) : that.deptCode != null) return false;
        if (personId != null ? !personId.equals(that.personId) : that.personId != null) return false;
        if (visitDoctor != null ? !visitDoctor.equals(that.visitDoctor) : that.visitDoctor != null) return false;
        if (visitDept != null ? !visitDept.equals(that.visitDept) : that.visitDept != null) return false;
        if (visitGroup != null ? !visitGroup.equals(that.visitGroup) : that.visitGroup != null) return false;
        if (totalCosts != null ? !totalCosts.equals(that.totalCosts) : that.totalCosts != null) return false;
        if (totalCharges != null ? !totalCharges.equals(that.totalCharges) : that.totalCharges != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (maker != null ? !maker.equals(that.maker) : that.maker != null) return false;
        if (makeDate != null ? !makeDate.equals(that.makeDate) : that.makeDate != null) return false;
        if (verifier != null ? !verifier.equals(that.verifier) : that.verifier != null) return false;
        if (verifyDate != null ? !verifyDate.equals(that.verifyDate) : that.verifyDate != null) return false;
        if (currentStatus != null ? !currentStatus.equals(that.currentStatus) : that.currentStatus != null)
            return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;
        if (visitId != null ? !visitId.equals(that.visitId) : that.visitId != null) return false;
        if (patientType != null ? !patientType.equals(that.patientType) : that.patientType != null) return false;
        if (sampleNo != null ? !sampleNo.equals(that.sampleNo) : that.sampleNo != null) return false;
        if (personName != null ? !personName.equals(that.personName) : that.personName != null) return false;
        if (billNo2 != null ? !billNo2.equals(that.billNo2) : that.billNo2 != null) return false;
        if (sendVerifier != null ? !sendVerifier.equals(that.sendVerifier) : that.sendVerifier != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (ageUnits != null ? !ageUnits.equals(that.ageUnits) : that.ageUnits != null) return false;
        if (bloodCode != null ? !bloodCode.equals(that.bloodCode) : that.bloodCode != null) return false;
        if (rhSign != null ? !rhSign.equals(that.rhSign) : that.rhSign != null) return false;
        if (bedNo != null ? !bedNo.equals(that.bedNo) : that.bedNo != null) return false;
        if (clinicDiag != null ? !clinicDiag.equals(that.clinicDiag) : that.clinicDiag != null) return false;
        if (clinicDiagName != null ? !clinicDiagName.equals(that.clinicDiagName) : that.clinicDiagName != null)
            return false;
        if (printDate != null ? !printDate.equals(that.printDate) : that.printDate != null) return false;
        if (transferUnit != null ? !transferUnit.equals(that.transferUnit) : that.transferUnit != null) return false;
        if (transfer != null ? !transfer.equals(that.transfer) : that.transfer != null) return false;
        if (qualityAssess != null ? !qualityAssess.equals(that.qualityAssess) : that.qualityAssess != null)
            return false;
        if (coldChainStatus != null ? !coldChainStatus.equals(that.coldChainStatus) : that.coldChainStatus != null)
            return false;
        if (receiver != null ? !receiver.equals(that.receiver) : that.receiver != null) return false;
        if (receiveDate != null ? !receiveDate.equals(that.receiveDate) : that.receiveDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = autoId != null ? autoId.hashCode() : 0;
        result = 31 * result + (unitsCode != null ? unitsCode.hashCode() : 0);
        result = 31 * result + (billNo != null ? billNo.hashCode() : 0);
        result = 31 * result + (billDate != null ? billDate.hashCode() : 0);
        result = 31 * result + (invoiceType != null ? invoiceType.hashCode() : 0);
        result = 31 * result + (operationNo != null ? operationNo.hashCode() : 0);
        result = 31 * result + (rdFlag != null ? rdFlag.hashCode() : 0);
        result = 31 * result + (rdType != null ? rdType.hashCode() : 0);
        result = 31 * result + (deptCode != null ? deptCode.hashCode() : 0);
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        result = 31 * result + (visitDoctor != null ? visitDoctor.hashCode() : 0);
        result = 31 * result + (visitDept != null ? visitDept.hashCode() : 0);
        result = 31 * result + (visitGroup != null ? visitGroup.hashCode() : 0);
        result = 31 * result + (totalCosts != null ? totalCosts.hashCode() : 0);
        result = 31 * result + (totalCharges != null ? totalCharges.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (maker != null ? maker.hashCode() : 0);
        result = 31 * result + (makeDate != null ? makeDate.hashCode() : 0);
        result = 31 * result + (verifier != null ? verifier.hashCode() : 0);
        result = 31 * result + (verifyDate != null ? verifyDate.hashCode() : 0);
        result = 31 * result + (currentStatus != null ? currentStatus.hashCode() : 0);
        result = 31 * result + (patientId != null ? patientId.hashCode() : 0);
        result = 31 * result + (visitId != null ? visitId.hashCode() : 0);
        result = 31 * result + (patientType != null ? patientType.hashCode() : 0);
        result = 31 * result + (sampleNo != null ? sampleNo.hashCode() : 0);
        result = 31 * result + (personName != null ? personName.hashCode() : 0);
        result = 31 * result + (billNo2 != null ? billNo2.hashCode() : 0);
        result = 31 * result + (sendVerifier != null ? sendVerifier.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (ageUnits != null ? ageUnits.hashCode() : 0);
        result = 31 * result + (bloodCode != null ? bloodCode.hashCode() : 0);
        result = 31 * result + (rhSign != null ? rhSign.hashCode() : 0);
        result = 31 * result + (bedNo != null ? bedNo.hashCode() : 0);
        result = 31 * result + (clinicDiag != null ? clinicDiag.hashCode() : 0);
        result = 31 * result + (clinicDiagName != null ? clinicDiagName.hashCode() : 0);
        result = 31 * result + (printDate != null ? printDate.hashCode() : 0);
        result = 31 * result + (transferUnit != null ? transferUnit.hashCode() : 0);
        result = 31 * result + (transfer != null ? transfer.hashCode() : 0);
        result = 31 * result + (qualityAssess != null ? qualityAssess.hashCode() : 0);
        result = 31 * result + (coldChainStatus != null ? coldChainStatus.hashCode() : 0);
        result = 31 * result + (receiver != null ? receiver.hashCode() : 0);
        result = 31 * result + (receiveDate != null ? receiveDate.hashCode() : 0);
        return result;
    }
}
