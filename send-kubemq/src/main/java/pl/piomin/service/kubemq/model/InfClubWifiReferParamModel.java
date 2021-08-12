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
public class InfClubWifiReferParamModel {

    @JsonProperty("ecid")
    private String ecid;
       
    @JsonProperty("FlowEventId")
    private String flowEventId;
  
    @JsonProperty("FlowId")
    private String flowId;  
	
    @JsonProperty("CorrelationFlowId")
    private String correlationFlowId; 

    @JsonProperty("quiescing.SCAEntityId")
    private String sCAEntityId;  

    public String getEcid() {
        return ecid;
    }

    public void setEcid(String ecid) {
        this.ecid = ecid;
    }

    public String getFlowEventId() {
        return flowEventId;
    }

    public void setFlowEventId(String flowEventId) {
        this.flowEventId = flowEventId;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getCorrelationFlowId() {
        return correlationFlowId;
    }

    public void setCorrelationFlowId(String correlationFlowId) {
        this.correlationFlowId = correlationFlowId;
    }

    public String getsCAEntityId() {
        return sCAEntityId;
    }

    public void setsCAEntityId(String sCAEntityId) {
        this.sCAEntityId = sCAEntityId;
    }
        
   
    
}
