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
public class InfClubWifiReplyToModel {
    
    @JsonProperty("Address")
    private String address;
   
    @JsonProperty("ReferenceParameters")
    private InfClubWifiReferParamModel referenceParameters = null;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public InfClubWifiReferParamModel getReferenceParameters() {
        return referenceParameters;
    }

    public void setReferenceParameters(InfClubWifiReferParamModel referenceParameters) {
        this.referenceParameters = referenceParameters;
    }


    
}
