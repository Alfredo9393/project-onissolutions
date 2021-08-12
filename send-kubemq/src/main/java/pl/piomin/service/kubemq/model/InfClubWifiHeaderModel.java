/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.piomin.service.kubemq.model;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 *
 * @author APerez
 */
public class InfClubWifiHeaderModel {
    
    @JsonProperty("MessageID")
    private String messageID;

    @JsonProperty("ReplyTo")
    private InfClubWifiReplyToModel replyTo = null;

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public InfClubWifiReplyToModel getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(InfClubWifiReplyToModel replyTo) {
        this.replyTo = replyTo;
    }


    
    

}
    