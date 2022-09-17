package com.srs.common.kafka.message.market;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;


public class DemoKafkaMessage implements Serializable {

    private String marketName;
    private String street;
    private UUID barangayId;
    private int marketType;
    private int type;
    private String mappedLocation;
    private int marketStatus;

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public UUID getBarangayId() {
        return barangayId;
    }

    public void setBarangayId(UUID barangayId) {
        this.barangayId = barangayId;
    }

    public int getMarketType() {
        return marketType;
    }

    public void setMarketType(int marketType) {
        this.marketType = marketType;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMappedLocation() {
        return mappedLocation;
    }

    public void setMappedLocation(String mappedLocation) {
        this.mappedLocation = mappedLocation;
    }

    public int getMarketStatus() {
        return marketStatus;
    }

    public void setMarketStatus(int marketStatus) {
        this.marketStatus = marketStatus;
    }
}
