package io.isoft.blood.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2015-10-08.
 */
@Entity
@javax.persistence.Table(name = "BLOOD_RDS_DETAIL", schema = "SUPBLOOD", catalog = "")
public class BloodRdsDetail {
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

    private String mainAutoId;

    @Basic
    @javax.persistence.Column(name = "MAIN_AUTO_ID", nullable = false, insertable = true, updatable = true, length = 22)
    public String getMainAutoId() {
        return mainAutoId;
    }

    public void setMainAutoId(String mainAutoId) {
        this.mainAutoId = mainAutoId;
    }

    private String productCode;

    @Basic
    @javax.persistence.Column(name = "PRODUCT_CODE", nullable = false, insertable = true, updatable = true, length = 40)
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    private String bloodBagCode;

    @Basic
    @javax.persistence.Column(name = "BLOOD_BAG_CODE", nullable = true, insertable = true, updatable = true, length = 40)
    public String getBloodBagCode() {
        return bloodBagCode;
    }

    public void setBloodBagCode(String bloodBagCode) {
        this.bloodBagCode = bloodBagCode;
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

    private String typeCode;

    @Basic
    @javax.persistence.Column(name = "TYPE_CODE", nullable = true, insertable = true, updatable = true, length = 2)
    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    private String typeName;

    @Basic
    @javax.persistence.Column(name = "TYPE_NAME", nullable = true, insertable = true, updatable = true, length = 40)
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    private String spec;

    @Basic
    @javax.persistence.Column(name = "SPEC", nullable = true, insertable = true, updatable = true, length = 40)
    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    private BigDecimal amount;

    @Basic
    @javax.persistence.Column(name = "AMOUNT", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    private String units;

    @Basic
    @javax.persistence.Column(name = "UNITS", nullable = true, insertable = true, updatable = true, length = 10)
    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    private BigDecimal assiAmount;

    @Basic
    @javax.persistence.Column(name = "ASSI_AMOUNT", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getAssiAmount() {
        return assiAmount;
    }

    public void setAssiAmount(BigDecimal assiAmount) {
        this.assiAmount = assiAmount;
    }

    private String assiUnits;

    @Basic
    @javax.persistence.Column(name = "ASSI_UNITS", nullable = true, insertable = true, updatable = true, length = 10)
    public String getAssiUnits() {
        return assiUnits;
    }

    public void setAssiUnits(String assiUnits) {
        this.assiUnits = assiUnits;
    }

    private BigDecimal tradePrice;

    @Basic
    @javax.persistence.Column(name = "TRADE_PRICE", nullable = true, insertable = true, updatable = true, precision = 4)
    public BigDecimal getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(BigDecimal tradePrice) {
        this.tradePrice = tradePrice;
    }

    private BigDecimal totalCosts;

    @Basic
    @javax.persistence.Column(name = "TOTAL_COSTS", nullable = true, insertable = true, updatable = true, precision = 4)
    public BigDecimal getTotalCosts() {
        return totalCosts;
    }

    public void setTotalCosts(BigDecimal totalCosts) {
        this.totalCosts = totalCosts;
    }

    private BigDecimal retailPrice;

    @Basic
    @javax.persistence.Column(name = "RETAIL_PRICE", nullable = true, insertable = true, updatable = true, precision = 4)
    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    private BigDecimal totalCharges;

    @Basic
    @javax.persistence.Column(name = "TOTAL_CHARGES", nullable = true, insertable = true, updatable = true, precision = 4)
    public BigDecimal getTotalCharges() {
        return totalCharges;
    }

    public void setTotalCharges(BigDecimal totalCharges) {
        this.totalCharges = totalCharges;
    }

    private String bloodDonorCode;

    @Basic
    @javax.persistence.Column(name = "BLOOD_DONOR_CODE", nullable = true, insertable = true, updatable = true, length = 20)
    public String getBloodDonorCode() {
        return bloodDonorCode;
    }

    public void setBloodDonorCode(String bloodDonorCode) {
        this.bloodDonorCode = bloodDonorCode;
    }

    private String bloodDonorName;

    @Basic
    @javax.persistence.Column(name = "BLOOD_DONOR_NAME", nullable = true, insertable = true, updatable = true, length = 20)
    public String getBloodDonorName() {
        return bloodDonorName;
    }

    public void setBloodDonorName(String bloodDonorName) {
        this.bloodDonorName = bloodDonorName;
    }

    private Timestamp collectDate;

    @Basic
    @javax.persistence.Column(name = "COLLECT_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(Timestamp collectDate) {
        this.collectDate = collectDate;
    }

    private Timestamp availDate;

    @Basic
    @javax.persistence.Column(name = "AVAIL_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getAvailDate() {
        return availDate;
    }

    public void setAvailDate(Timestamp availDate) {
        this.availDate = availDate;
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

    private String bagReturnSign;

    @Basic
    @javax.persistence.Column(name = "BAG_RETURN_SIGN", nullable = true, insertable = true, updatable = true, length = 1)
    public String getBagReturnSign() {
        return bagReturnSign;
    }

    public void setBagReturnSign(String bagReturnSign) {
        this.bagReturnSign = bagReturnSign;
    }

    private String modifyPerson;

    @Basic
    @javax.persistence.Column(name = "MODIFY_PERSON", nullable = true, insertable = true, updatable = true, length = 20)
    public String getModifyPerson() {
        return modifyPerson;
    }

    public void setModifyPerson(String modifyPerson) {
        this.modifyPerson = modifyPerson;
    }

    private Timestamp modifyDate;

    @Basic
    @javax.persistence.Column(name = "MODIFY_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate;
    }

    private String billId;

    @Basic
    @javax.persistence.Column(name = "BILL_ID", nullable = true, insertable = true, updatable = true, length = 30)
    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    private String remark;

    @Basic
    @javax.persistence.Column(name = "REMARK", nullable = true, insertable = true, updatable = true, length = 120)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    private String scrappedSign;

    @Basic
    @javax.persistence.Column(name = "SCRAPPED_SIGN", nullable = true, insertable = true, updatable = true, length = 1)
    public String getScrappedSign() {
        return scrappedSign;
    }

    public void setScrappedSign(String scrappedSign) {
        this.scrappedSign = scrappedSign;
    }

    private String typeProp;

    @Basic
    @javax.persistence.Column(name = "TYPE_PROP", nullable = true, insertable = true, updatable = true, length = 1)
    public String getTypeProp() {
        return typeProp;
    }

    public void setTypeProp(String typeProp) {
        this.typeProp = typeProp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BloodRdsDetail that = (BloodRdsDetail) o;

        if (autoId != null ? !autoId.equals(that.autoId) : that.autoId != null) return false;
        if (unitsCode != null ? !unitsCode.equals(that.unitsCode) : that.unitsCode != null) return false;
        if (mainAutoId != null ? !mainAutoId.equals(that.mainAutoId) : that.mainAutoId != null) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (bloodBagCode != null ? !bloodBagCode.equals(that.bloodBagCode) : that.bloodBagCode != null) return false;
        if (bloodCode != null ? !bloodCode.equals(that.bloodCode) : that.bloodCode != null) return false;
        if (typeCode != null ? !typeCode.equals(that.typeCode) : that.typeCode != null) return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;
        if (rhSign != null ? !rhSign.equals(that.rhSign) : that.rhSign != null) return false;
        if (spec != null ? !spec.equals(that.spec) : that.spec != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (units != null ? !units.equals(that.units) : that.units != null) return false;
        if (assiAmount != null ? !assiAmount.equals(that.assiAmount) : that.assiAmount != null) return false;
        if (assiUnits != null ? !assiUnits.equals(that.assiUnits) : that.assiUnits != null) return false;
        if (tradePrice != null ? !tradePrice.equals(that.tradePrice) : that.tradePrice != null) return false;
        if (totalCosts != null ? !totalCosts.equals(that.totalCosts) : that.totalCosts != null) return false;
        if (retailPrice != null ? !retailPrice.equals(that.retailPrice) : that.retailPrice != null) return false;
        if (totalCharges != null ? !totalCharges.equals(that.totalCharges) : that.totalCharges != null) return false;
        if (bloodDonorCode != null ? !bloodDonorCode.equals(that.bloodDonorCode) : that.bloodDonorCode != null)
            return false;
        if (bloodDonorName != null ? !bloodDonorName.equals(that.bloodDonorName) : that.bloodDonorName != null)
            return false;
        if (collectDate != null ? !collectDate.equals(that.collectDate) : that.collectDate != null) return false;
        if (availDate != null ? !availDate.equals(that.availDate) : that.availDate != null) return false;
        if (currentStatus != null ? !currentStatus.equals(that.currentStatus) : that.currentStatus != null)
            return false;
        if (bagReturnSign != null ? !bagReturnSign.equals(that.bagReturnSign) : that.bagReturnSign != null)
            return false;
        if (modifyPerson != null ? !modifyPerson.equals(that.modifyPerson) : that.modifyPerson != null) return false;
        if (modifyDate != null ? !modifyDate.equals(that.modifyDate) : that.modifyDate != null) return false;
        if (billId != null ? !billId.equals(that.billId) : that.billId != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (scrappedSign != null ? !scrappedSign.equals(that.scrappedSign) : that.scrappedSign != null) return false;
        if (typeProp != null ? !typeProp.equals(that.typeProp) : that.typeProp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = autoId != null ? autoId.hashCode() : 0;
        result = 31 * result + (unitsCode != null ? unitsCode.hashCode() : 0);
        result = 31 * result + (mainAutoId != null ? mainAutoId.hashCode() : 0);
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (bloodBagCode != null ? bloodBagCode.hashCode() : 0);
        result = 31 * result + (bloodCode != null ? bloodCode.hashCode() : 0);
        result = 31 * result + (typeCode != null ? typeCode.hashCode() : 0);
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + (rhSign != null ? rhSign.hashCode() : 0);
        result = 31 * result + (spec != null ? spec.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (units != null ? units.hashCode() : 0);
        result = 31 * result + (assiAmount != null ? assiAmount.hashCode() : 0);
        result = 31 * result + (assiUnits != null ? assiUnits.hashCode() : 0);
        result = 31 * result + (tradePrice != null ? tradePrice.hashCode() : 0);
        result = 31 * result + (totalCosts != null ? totalCosts.hashCode() : 0);
        result = 31 * result + (retailPrice != null ? retailPrice.hashCode() : 0);
        result = 31 * result + (totalCharges != null ? totalCharges.hashCode() : 0);
        result = 31 * result + (bloodDonorCode != null ? bloodDonorCode.hashCode() : 0);
        result = 31 * result + (bloodDonorName != null ? bloodDonorName.hashCode() : 0);
        result = 31 * result + (collectDate != null ? collectDate.hashCode() : 0);
        result = 31 * result + (availDate != null ? availDate.hashCode() : 0);
        result = 31 * result + (currentStatus != null ? currentStatus.hashCode() : 0);
        result = 31 * result + (bagReturnSign != null ? bagReturnSign.hashCode() : 0);
        result = 31 * result + (modifyPerson != null ? modifyPerson.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + (billId != null ? billId.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (scrappedSign != null ? scrappedSign.hashCode() : 0);
        result = 31 * result + (typeProp != null ? typeProp.hashCode() : 0);
        return result;
    }
}
