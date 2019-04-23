package com.example.vesselstatus.controller;

import com.example.vesselstatus.base.BaseResponse;
import com.example.vesselstatus.entity.VesselStatus;
import com.example.vesselstatus.service.VesselStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/getVessel")
public class VesselController {

    @Autowired
    private VesselStatusService vesselStatusService;

    @GetMapping("/{vesselGid}")
    @ResponseBody
    public BaseResponse getVesselStatus(@PathVariable String vesselGid) {
        System.out.println("*********************************************************************************************************************************");
        return vesselStatusService.findVesselStatusByVesselGid(vesselGid);
    }

    @PostMapping()
    @ResponseBody
    public BaseResponse createVesselStatus(@RequestBody VesselStatus vesselStatus) {
        return vesselStatusService.saveVesselStatus(vesselStatus);
    }

    @GetMapping()
    @ResponseBody
    public BaseResponse getAllVesselStatus() {
        return vesselStatusService.getAllVessel();
    }
}
