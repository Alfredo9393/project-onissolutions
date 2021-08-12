/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.piomin.service.kubemq.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
/**
 *
 * @author APerez
 */
public class InfClubWifiProcessResponseModel {
    public InfClubWifiProcessResponseModel() {}
    
    @JsonProperty("Result")
    private InfClubWifiResultModel result = null;

    @JsonProperty("Name")
    private String name;
    
    @JsonProperty("Phone")
    private String phone;
    
    @JsonProperty("Email")
    private String email;

    public InfClubWifiResultModel getResult() {
        return result;
    }

    public void setResult(InfClubWifiResultModel result) {
        this.result = result;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
}

