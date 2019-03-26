package com.example.vesselstatus.service;


import com.example.vesselstatus.base.BaseResponse;
import com.example.vesselstatus.entity.VesselStatus;

import java.util.List;

public interface VesselStatusService {

  BaseResponse saveVesselStatus(VesselStatus vessel);

  BaseResponse removeVesselStatus(String vesselGid);

  BaseResponse updateVesselStatus(VesselStatus vessel);

  BaseResponse findVesselStatusByVesselGid(String vesselGid);

  BaseResponse<List<VesselStatus>> getAllVessel();
}
