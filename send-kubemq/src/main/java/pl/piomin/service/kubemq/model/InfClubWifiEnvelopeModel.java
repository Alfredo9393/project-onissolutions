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
public class InfClubWifiEnvelopeModel {
    
    @JsonProperty("Header")
    private InfClubWifiHeaderModel header = null;

    @JsonProperty("Body")    
    private InfClubWifiBodyModel body;

    public InfClubWifiHeaderModel getHeader() {
        return header;
    }

    public void setHeader(InfClubWifiHeaderModel header) {
        this.header = header;
    }

    public InfClubWifiBodyModel getBody() {
        return body;
    }

    public void setBody(InfClubWifiBodyModel body) {
        this.body = body;
    }


            
    
}
