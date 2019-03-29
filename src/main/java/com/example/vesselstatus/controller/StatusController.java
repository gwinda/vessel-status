package com.example.vesselstatus.controller;

import com.example.vesselstatus.base.BaseResponse;
import com.example.vesselstatus.base.Constant;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/getStatus")
@CrossOrigin(maxAge = 3600)
public class StatusController {


    @ResponseBody
    @GetMapping("/{vesselGid}")
    public BaseResponse getOneVessel(@PathVariable String vesselGid) {

//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa*********************************************************************************************************************************");
//        try { Thread.sleep ( 20000 ) ;
//        } catch (InterruptedException ie){}
//        System.out.println("weak up");
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMsg(Constant.SUCCESS);
        baseResponse.setCode(Constant.SUCCESS);
        return baseResponse;
    }
}
