/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.kubemq.listener;

import com.api.InformationClubWifi.model.UserModel;
import com.api.kubemq.enums.InformationClubWifiStatus;
import io.kubemq.sdk.event.Channel;
import io.kubemq.sdk.event.Event;
import io.kubemq.sdk.queue.Queue;
import io.kubemq.sdk.queue.Transaction;
import io.kubemq.sdk.tools.Converter;
import io.kubemq.sdk.queue.TransactionMessagesResponse;
import javax.annotation.PostConstruct;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

/**
 * 
 *
 * @author APerez
 */
@Component
public class UserListener {
    
    private Queue queue;
    private Channel channel;
//    private OrderProcessor orderProcessor;
    private TaskExecutor taskExecutor;
    
    public UserListener(Queue queue, Channel channel, TaskExecutor taskExecutor) {
        this.queue = queue;
        this.channel = channel;
        this.taskExecutor = taskExecutor;
    }
                
        
    @PostConstruct
    public void listen() {
        
        taskExecutor.execute(() -> {
            while (true) {
                try {
                    Transaction transaction = queue.CreateTransaction();
                    TransactionMessagesResponse response = transaction.Receive(10, 10);
                    if (response.getMessage().getBody().length > 0) {
                        UserModel user = (UserModel) Converter.FromByteArray(response.getMessage().getBody());
                        user.setStatus(InformationClubWifiStatus.CONFIRMED);
                        
                        if (user.getStatus().equals(InformationClubWifiStatus.CONFIRMED)) {
                            transaction.AckMessage();
                            Event event = new Event();
                            event.setEventId(response.getMessage().getMessageID());
                            event.setBody(Converter.ToByteArray(user));
                            System.out.println("");
                            channel.SendEvent(event);
                        } else {
                            transaction.RejectMessage();
                        }
                    } else {
                        System.out.println("No messages");
                    }
                    Thread.sleep(10000);
                } catch (Exception e) {
                    System.out.println("Error: " +e);
                }
            }
        });
        
        
    }
}
