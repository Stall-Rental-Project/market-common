package com.srs.common.kafka.message;

import com.srs.common.kafka.message.core.email.EmailKafkaMessage;

import java.util.List;


public class AppStatusUpdatedEmailKafkaMessage extends EmailKafkaMessage {

    private String toEmail;

    private List<String> ccEmails;

    private String marketCode;
    private String marketType;
    private String firstName;
    private String lastName;

    private String applicationType;
    private int applicationTypeNumber; // numeric representation of applicationType
    private String applicationNumber; // column "code" in table application
    private String comment;
    private String menuSection;
    private String applicationStatus;
    private int applicationStatusNumber; // numeric representation of applicationStatus

    private int marketTypeNumber;

    public int getMarketTypeNumber() {
        return marketTypeNumber;
    }

    public void setMarketTypeNumber(int marketTypeNumber) {
        this.marketTypeNumber = marketTypeNumber;
    }

    public String getMarketType() {
        return marketType;
    }

    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public List<String> getCcEmails() {
        return ccEmails;
    }

    public void setCcEmails(List<String> ccEmails) {
        this.ccEmails = ccEmails;
    }

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public int getApplicationTypeNumber() {
        return applicationTypeNumber;
    }

    public void setApplicationTypeNumber(int applicationTypeNumber) {
        this.applicationTypeNumber = applicationTypeNumber;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getMenuSection() {
        return menuSection;
    }

    public void setMenuSection(String menuSection) {
        this.menuSection = menuSection;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public int getApplicationStatusNumber() {
        return applicationStatusNumber;
    }

    public void setApplicationStatusNumber(int applicationStatusNumber) {
        this.applicationStatusNumber = applicationStatusNumber;
    }
}
