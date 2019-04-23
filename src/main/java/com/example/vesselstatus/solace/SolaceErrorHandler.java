package com.example.vesselstatus.solace;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.DefaultErrorHandlerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("SolaceErrorHandler")
public class SolaceErrorHandler extends DefaultErrorHandlerBuilder implements Processor {
  private static final Logger logger = LoggerFactory.getLogger(SolaceErrorHandler.class);

  @Override
  public void process(Exchange exchange) {
    logger.error("Get a exception when processing message");
    logger.error("Message detail:");
    logger.error(exchange.getIn().getBody(String.class));
  }

}
