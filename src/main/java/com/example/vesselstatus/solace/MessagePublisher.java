package com.example.vesselstatus.solace;

import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePublisher {
  @Autowired
  private CamelContext camelContext;

  public void sendMessageToTopic(String topic, Object message) {
//    camelContext.createProducerTemplate().sendBody(SOLACE_SYSTEM_TOPIC_PREFIX + topic, JSONObject.toJSON(message).toString());
  }

//  public String buildStopEventAssociationTopic(StopEventAssociation assMsg) {
//    return String.format(STOP_UPD_EVT_TOPIC, "N", assMsg.getVesselGid(), assMsg.getEventType(), assMsg.getEventTime());
//  }

}
