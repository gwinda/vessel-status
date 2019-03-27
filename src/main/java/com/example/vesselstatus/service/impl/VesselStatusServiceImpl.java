package com.example.vesselstatus.service.impl;


import com.example.vesselstatus.base.BaseResponse;
import com.example.vesselstatus.base.Constant;
import com.example.vesselstatus.dao.VesselStatusDao;
import com.example.vesselstatus.entity.VesselStatus;
import com.example.vesselstatus.service.VesselStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VesselStatusServiceImpl implements VesselStatusService {
  @Autowired
  VesselStatusDao vesselStatusDaoImpl;

  @Override
  public BaseResponse removeVesselStatus(String vesselGid) {
    BaseResponse baseResponse = new BaseResponse();
    VesselStatus vesselStatus = vesselStatusDaoImpl.findByVesselGid(vesselGid);
    if (vesselStatus != null) {
      boolean delResult = vesselStatusDaoImpl.remove(vesselStatus);
      if (delResult) {
        baseResponse.setCode(Constant.SUCCESS_CODE);
        baseResponse.setMsg(Constant.SUCCESS);
        baseResponse.setData(vesselStatus);
      } else {
        baseResponse.setCode(Constant.FAIL_CODE);
        baseResponse.setMsg(Constant.FAIL);
      }
    } else {
      baseResponse.setCode(Constant.FAIL_CODE);
      baseResponse.setMsg(Constant.FAIL);
    }
    return baseResponse;
  }

  @Override
  public BaseResponse updateVesselStatus(VesselStatus vessel) {
    BaseResponse baseResponse = new BaseResponse();
    VesselStatus newVessel = vesselStatusDaoImpl.findByVesselGid(vessel.getVesselGid());
    if (newVessel != null) {
      boolean updateResult = vesselStatusDaoImpl.update(vessel);
      if (updateResult) {
        baseResponse.setCode(Constant.SUCCESS_CODE);
        baseResponse.setMsg(Constant.SUCCESS);
        baseResponse.setData(newVessel);
      } else {
        baseResponse.setCode(Constant.FAIL_CODE);
        baseResponse.setMsg("update failed");
      }
    } else {
      baseResponse.setCode(Constant.FAIL_CODE);
      baseResponse.setMsg("Not found this vesselStatus , update failed");
    }

    return baseResponse;
  }

  @Override
  public BaseResponse findVesselStatusByVesselGid(String vesselGid) {
    BaseResponse baseResponse = new BaseResponse();
    VesselStatus vesselStatus = vesselStatusDaoImpl.findByVesselGid(vesselGid);
    if (vesselStatus != null) {
      baseResponse.setCode(Constant.SUCCESS_CODE);
      baseResponse.setData(vesselStatus);
    } else {
      baseResponse.setCode(Constant.FAIL_CODE);
      baseResponse.setMsg(Constant.FAIL);
    }
    return baseResponse;
  }



  @Override
  public BaseResponse saveVesselStatus(VesselStatus vessel) {
    BaseResponse baseResponse = new BaseResponse();
    VesselStatus status = vesselStatusDaoImpl.save(vessel);
    if(status !=null){
      baseResponse.setCode(Constant.SUCCESS_CODE);
      baseResponse.setData(status);
      baseResponse.setMsg(Constant.SUCCESS);
    }else{
      baseResponse.setCode(Constant.FAIL_CODE);
      baseResponse.setMsg(Constant.FAIL);
    }
    return baseResponse;
  }

  @Override
  public BaseResponse<List<VesselStatus>> getAllVessel() {
    BaseResponse baseResponse = new BaseResponse();
    List<VesselStatus> vessels = vesselStatusDaoImpl.getAll();

    if (vessels.size() == 0) {
      baseResponse.setMsg(Constant.FAIL);
    } else {
      baseResponse.setMsg(Constant.SUCCESS);
    }
    baseResponse.setCode(Constant.SUCCESS_CODE);
    baseResponse.setData(vessels);
    return baseResponse;
  }
}
