package com.example.vesselstatus.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "vessel-status")
public class VesselStatus implements Serializable {
    private static final long serialVersionUID = 1L;

    @Field
    private String vesselGid;

    @Field
    private String runningState;

    public String getVesselGid() {
        return vesselGid;
    }

    public void setVesselGid(String vesselGid) {
        this.vesselGid = vesselGid;
    }

    public String getRunningState() {
        return runningState;
    }

    public void setRunningState(String runningState) {
        this.runningState = runningState;
    }
}
