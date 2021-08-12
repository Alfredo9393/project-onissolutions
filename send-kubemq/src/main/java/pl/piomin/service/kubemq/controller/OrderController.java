package pl.piomin.service.kubemq.controller;

import io.kubemq.sdk.basic.ServerAddressNotSuppliedException;
import io.kubemq.sdk.queue.Message;
import io.kubemq.sdk.queue.Queue;
import io.kubemq.sdk.queue.SendMessageResult;
import io.kubemq.sdk.tools.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.piomin.service.kubemq.model.Order;
import pl.piomin.service.kubemq.model.OrderStatus;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.piomin.service.kubemq.model.InfClubWifiEnvelopeModel;
import pl.piomin.service.kubemq.service.OrderProcessor;

@RestController
@RequestMapping("/api/informationclubwifi")
public class OrderController {

    @Autowired
    private OrderProcessor orderProcessor;
        
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
        
    
    @RequestMapping(value="/send",method=RequestMethod.POST)
    public InfClubWifiEnvelopeModel sendOrder(@RequestBody Order order) {
        System.out.println("Get api POST: Account: "+order.getAccount());      
        return orderProcessor.validateAccout(order.getAccount());  

    }
    
    

}
