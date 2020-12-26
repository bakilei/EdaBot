package com.tufypace.yaedabot.model.courierinfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tufypace.yaedabot.model.order.OrderModel;
import com.tufypace.yaedabot.model.order.Time;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CourierInfo {
    @JsonProperty("balance")
    public int balance;
    public String billingType;
    public Time blockedUntil;
    public boolean cardLinked;
    @JsonProperty("fullName")
    public CourierFullname courierFullname;
    @JsonProperty("id")
    public int courierId;
    public int encashmentAmount;
    @JsonProperty("metaData")
    public MetaDataCourierInfo metaData;
    public int overdraft;
    @JsonProperty("region")
    public CourierRegion region;
    @JsonProperty(OrderModel.STATUS)
    public String status;
    public String timezone;
    public String type;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getBillingType() {
        return billingType;
    }

    public void setBillingType(String billingType) {
        this.billingType = billingType;
    }

    public Time getBlockedUntil() {
        return blockedUntil;
    }

    public void setBlockedUntil(Time blockedUntil) {
        this.blockedUntil = blockedUntil;
    }

    public boolean isCardLinked() {
        return cardLinked;
    }

    public void setCardLinked(boolean cardLinked) {
        this.cardLinked = cardLinked;
    }

    public CourierFullname getCourierFullname() {
        return courierFullname;
    }

    public void setCourierFullname(CourierFullname courierFullname) {
        this.courierFullname = courierFullname;
    }

    public int getCourierId() {
        return courierId;
    }

    public void setCourierId(int courierId) {
        this.courierId = courierId;
    }

    public int getEncashmentAmount() {
        return encashmentAmount;
    }

    public void setEncashmentAmount(int encashmentAmount) {
        this.encashmentAmount = encashmentAmount;
    }

    public MetaDataCourierInfo getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaDataCourierInfo metaData) {
        this.metaData = metaData;
    }

    public int getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(int overdraft) {
        this.overdraft = overdraft;
    }

    public CourierRegion getRegion() {
        return region;
    }

    public void setRegion(CourierRegion region) {
        this.region = region;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CourierInfo() {
    }


}
