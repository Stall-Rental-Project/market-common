package com.srs.common.kafka.message.rental;

import java.io.Serializable;
import java.util.UUID;

public class LeaseApprovedKafkaMessage implements Serializable {
    private String marketCode;
    private String floorCode;
    private String stallCode;
    private UUID applicationId;
    private int leaseStatus;

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getFloorCode() {
        return floorCode;
    }

    public void setFloorCode(String floorCode) {
        this.floorCode = floorCode;
    }

    public String getStallCode() {
        return stallCode;
    }

    public void setStallCode(String stallCode) {
        this.stallCode = stallCode;
    }

    public UUID getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(UUID applicationId) {
        this.applicationId = applicationId;
    }


    public int getLeaseStatus() {
        return leaseStatus;
    }

    public void setLeaseStatus(int leaseStatus) {
        this.leaseStatus = leaseStatus;
    }
}
