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
public class InfClubWifiResultModel {
    
   @JsonProperty("IdResult")
    private String idResult;
 
    @JsonProperty("Result")
    private String result;
    
    @JsonProperty("ResultDescription")
    private String resultDescription;

    public String getIdResult() {
        return idResult;
    }

    public void setIdResult(String idResult) {
        this.idResult = idResult;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }
    
    
}


