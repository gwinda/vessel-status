package com.example.vesselstatus.controller;

import com.example.vesselstatus.base.BaseResponse;
import com.example.vesselstatus.entity.VesselStatus;
import com.example.vesselstatus.service.VesselStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VesselController {

    @Autowired
    private VesselStatusService vesselStatusService;

    @RequestMapping("vessel/status/{vesselGid}")
    @ResponseBody
    public BaseResponse getVesselStatus(@PathVariable String vesselGid) {

        return vesselStatusService.findVesselStatusByVesselGid(vesselGid);
    }

    @PostMapping("vessel")
    @ResponseBody
    public BaseResponse getVesselStatus(@RequestBody VesselStatus vesselStatus) {

        return vesselStatusService.saveVesselStatus(vesselStatus);
    }
}
