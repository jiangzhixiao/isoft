package io.isoft.system.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2015-12-07.
 */
@Entity
@Table(name = "CD_NOTICE")
public class CdNotice implements Serializable {
    @Id
    @Column(name = "NOTICE_NO", nullable = false, length = 20)
    private String noticeNo;

    @Column
    private String unitsCode;

    @Column
    private String noticeType;

    @Column
    private Date noticeDate;

    @Column
    private String noticeTitle;

    @Column
    private String noticeContent;

    @Column
    private String currentStatus;

    @Column
    private String createPerson;

    @Column
    private Date createDate;

    @Column
    private String visibleSign;

    public CdNotice(String noticeNo, String unitsCode, String noticeType, Date noticeDate, String noticeTitle, String noticeContent, String currentStatus, String createPerson, Date createDate, String visibleSign) {
        this.noticeNo = noticeNo;
        this.unitsCode = unitsCode;
        this.noticeType = noticeType;
        this.noticeDate = noticeDate;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.currentStatus = currentStatus;
        this.createPerson = createPerson;
        this.createDate = createDate;
        this.visibleSign = visibleSign;
    }

    public String getNoticeNo() {
        return noticeNo;
    }

    public void setNoticeNo(String noticeNo) {
        this.noticeNo = noticeNo;
    }

    public String getUnitsCode() {
        return unitsCode;
    }

    public void setUnitsCode(String unitsCode) {
        this.unitsCode = unitsCode;
    }

    public CdNotice() {
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    public Date getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getVisibleSign() {
        return visibleSign;
    }

    public void setVisibleSign(String visibleSign) {
        this.visibleSign = visibleSign;
    }
}
