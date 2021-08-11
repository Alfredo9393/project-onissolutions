/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.InformationClubWifi.controller;

import com.api.InformationClubWifi.model.InfClubWifiEnvelopeModel;
import com.api.InformationClubWifi.model.InfClubWifiRequestModel;
import com.api.InformationClubWifi.model.UserModel;
import com.api.InformationClubWifi.service.InformationClubWifiService;
import com.api.kubemq.enums.InformationClubWifiStatus;
import io.kubemq.sdk.basic.ServerAddressNotSuppliedException;
import io.kubemq.sdk.queue.Queue;
import io.kubemq.sdk.queue.Message;
import io.kubemq.sdk.queue.SendMessageResult;
import io.kubemq.sdk.tools.Converter;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author APerez
 */
@RestController
@RequestMapping("/api/informationclubwifi")
public class InformationClubWifiController {
   
    
    @Autowired
    private InformationClubWifiService informationClubWifiService;

    
    private Queue queue;
    
//    @Autowired
    public InformationClubWifiController(Queue queue) {
        this.queue = queue;
    }
        
    @RequestMapping(value="/getInformation",method=RequestMethod.GET)
    public String getInformation(){
        System.out.println("Get microservice status: ON ");        
        return "Microservice status: ON";
    }
    
    
    @RequestMapping(value="/sendMessage",method=RequestMethod.GET)
    public String sendMessage(){
        System.out.println("Send Message");    
        UserModel user = new UserModel();
        try {
            user.setName("alfredo");
            user.setFirstName("Del Angel");
            user.setLastName("Perez");
            final SendMessageResult result = queue.SendQueueMessage(new Message()
                    .setBody(Converter.ToByteArray(user)));

            user.setId(result.getMessageID());
            user.setStatus(InformationClubWifiStatus.ACCEPTED);
        } catch (ServerAddressNotSuppliedException | IOException e) {
            user.setStatus(InformationClubWifiStatus.ERROR);
        }
        return "finish";
    }
    
    @RequestMapping(value="/processReceive",method=RequestMethod.POST)
    public InfClubWifiEnvelopeModel getProcessReceive(@RequestBody InfClubWifiRequestModel informationClubWifiModel){
        System.out.println("Get api POST: Account: "+informationClubWifiModel.getAccount());      
        return informationClubWifiService.validateAccout(informationClubWifiModel.getAccount());   
    }
}
