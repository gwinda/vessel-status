package com.example.vesselstatus.solace;


import com.alibaba.fastjson.JSONObject;
import com.example.vesselstatus.base.BaseResponse;
import com.example.vesselstatus.entity.VesselStatus;
import com.example.vesselstatus.service.VesselStatusService;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "SolaceEventProcessor")
public class SolaceEventProcessor implements Processor {

  private final static String ATTR_DEST = "JMSDestination";
  private final static Logger logger = LoggerFactory.getLogger(SolaceEventProcessor.class);
  @Autowired
  private VesselStatusService vesselStatusService;

  @Override
  public void process(Exchange exchange) {
    Message message = exchange.getIn();
    String body = message.getBody(String.class);
    JSONObject jsonObject = JSONObject.parseObject(body);
    String vesselGid = jsonObject.getString("vesselGid");
    String status = jsonObject.getString("status");
    VesselStatus vesselStatus = new VesselStatus();
    vesselStatus.setVesselGid(vesselGid);
    vesselStatus.setRunningState(status);
    BaseResponse response = vesselStatusService.updateVesselStatus(vesselStatus);
    if (response.getCode().equals("3333")) {
      vesselStatusService.saveVesselStatus(vesselStatus);
    }
  }

}
