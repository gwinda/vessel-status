package com.example.vesselstatus.controller;

import com.example.vesselstatus.base.BaseResponse;
import com.example.vesselstatus.base.Constant;

import com.example.vesselstatus.service.VesselStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/status")
@CrossOrigin(maxAge = 3600)
public class StatusController {

    @Autowired
    private VesselStatusService vesselStatusService;

    @ResponseBody
    @GetMapping("/{vesselGid}")
    public BaseResponse getOneVessel(@PathVariable String vesselGid) {

//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa*********************************************************************************************************************************");
//        try { Thread.sleep ( 20000 ) ;
//        } catch (InterruptedException ie){}
//        System.out.println("weak up");
//        BaseResponse baseResponse = new BaseResponse();
        return vesselStatusService.findVesselStatusByVesselGid(vesselGid);
//        baseResponse.setMsg(Constant.SUCCESS);
//        baseResponse.setCode(Constant.SUCCESS);
//        return baseResponse;
    }
}
