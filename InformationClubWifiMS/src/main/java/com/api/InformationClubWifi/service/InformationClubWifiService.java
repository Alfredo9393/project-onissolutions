/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.InformationClubWifi.service;


import com.api.InformationClubWifi.model.InfClubWifiBodyModel;
import com.api.InformationClubWifi.model.InfClubWifiEnvelopeModel;
import com.api.InformationClubWifi.model.InfClubWifiHeaderModel;
import com.api.InformationClubWifi.model.InfClubWifiReferParamModel;
import com.api.InformationClubWifi.model.InfClubWifiReplyToModel;
import com.api.InformationClubWifi.model.InfClubWifiProcessResponseModel;
import com.api.InformationClubWifi.model.InfClubWifiResultModel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author APerez
 */
@Service
public class InformationClubWifiService {
      

    public InfClubWifiEnvelopeModel validateAccout(String accout){
        
        InfClubWifiEnvelopeModel res = new InfClubWifiEnvelopeModel();
        res.setHeader(setHeader());
        res.setBody(setBody(accout));
         
        return res;
    }
    
        
    public InfClubWifiBodyModel setBody(String accout){
        InfClubWifiBodyModel body = new InfClubWifiBodyModel();
        
        try {
            
            if(accout.length()==10 && accout!=""){
                System.out.println("Cuenta valida "+ accout);

                System.out.println("select data from account where F1 = " +accout);

                if(accout.equals("0100002392")){
                    body.setProcessResponse(setResultSucces());
                }else{
                    System.out.println("Cuenta no existe "+accout );
                    body.setProcessResponse(setResultFalled("3990513","Petición fallida: Cuenta no existe"));
                }
            }else{
                System.out.println("Falled - Ingresar una cuenta valida");
                body.setProcessResponse(setResultFalled("3980522","Peticion fallida: Ingresar una cuenta valida"));
            }
                      
        } catch (Exception e) {
            System.out.println("Error" +e);
            body.setProcessResponse(setResultError());
        }
      
        return body;
    }    
        
    
    public InfClubWifiProcessResponseModel setResultSucces(){
        InfClubWifiProcessResponseModel objProRes = new InfClubWifiProcessResponseModel();
    
        InfClubWifiResultModel obj = new InfClubWifiResultModel();
        obj.setIdResult("3923536");
        obj.setResult("0");
        obj.setResultDescription("Peticion realizada con exito");
        
        objProRes.setResult(obj);
        objProRes.setName(format("MARCELI ELIZABETH MORENO ROMERO"));
        objProRes.setPhone(validateNumber());
        objProRes.setEmail("fedortiz@outlook.com");
        
        return objProRes;
        
    }
    
    public InfClubWifiProcessResponseModel setResultFalled(String code, String msg){
        InfClubWifiProcessResponseModel res = new InfClubWifiProcessResponseModel();
        
        InfClubWifiResultModel obj = new InfClubWifiResultModel();
        obj.setIdResult(code);  ///numeor aleatorio 
        obj.setResult("1");
        obj.setResultDescription(msg);
        
        res.setResult(obj);
        res.setName(format("null"));
        res.setPhone("null");
        res.setEmail("null");
        
        return res;
    }
        
    
    public InfClubWifiProcessResponseModel setResultError(){
        InfClubWifiProcessResponseModel res = new InfClubWifiProcessResponseModel();
        
        InfClubWifiResultModel obj = new InfClubWifiResultModel();
        obj.setIdResult("3980522");
        obj.setResult("1");
        obj.setResultDescription("Ingresar una cuenta valida");
  
        res.setResult(obj);
        res.setName(format("null"));
        res.setPhone("null");
        res.setEmail("null");
        
        return res;
    }
    
    
    public InfClubWifiHeaderModel setHeader(){

        //Create <wsa:ReferenceParameters>
        InfClubWifiReferParamModel ReferenceParametersObj = new InfClubWifiReferParamModel();
        ReferenceParametersObj.setEcid("8b8e86ca-40cc-488e-9116-43f5012ca670-0001151a");
        ReferenceParametersObj.setFlowEventId("54678");
        ReferenceParametersObj.setFlowId("234234");
        ReferenceParametersObj.setCorrelationFlowId("0000Nfh1lt7Bl3k_Ox9Did1WzztQ0000sA");
        ReferenceParametersObj.setsCAEntityId("820112");

        //Create <wsa:ReplyTo>
        InfClubWifiReplyToModel ReplyToObj = new InfClubWifiReplyToModel(); 
        ReplyToObj.setAddress("http://www.w3.org/2005/08/addressing/anonymous");
        ReplyToObj.setReferenceParameters(ReferenceParametersObj);

        
        //Create Header
        InfClubWifiHeaderModel Header = new InfClubWifiHeaderModel();
        Header.setMessageID("urn:f99e26c3-ef9c-11eb-854c-02429dba36fc");
        Header.setReplyTo(ReplyToObj);
        
        return Header;
    }
    
    
    public String validateNumber() {
        System.out.println("Select phones");
        System.out.println("7891012251");
        System.out.println("5551012255");
        System.out.println("8111012256");
        System.out.println("7891012257");
        System.out.println("5519266718");
        String phone="";
        
        List<String> data = new ArrayList<>(); 
        data.add("7891012256");
        data.add("5551012256");
        data.add("8111012256");
        data.add("7891012256");
        data.add("5519266718");
       
        for (int i = 0; i < data.size(); i++) {
            if(data.size()==5){
                phone=data.get(i);
            }else{
                phone="";
            }
        }
        System.out.println("Response phone " +phone);
        return phone;
    }
    
    
    public String format(String name) {
        System.out.println("Request format name "+name);
        String convert = "";
        String[] information = name.split(" ");

        for (int i = 0; i < information.length; i++) {
            if (i < information.length - 1) {
                convert += information[i].substring(0, 1).toUpperCase() + information[i].substring(1).toLowerCase() + " ";
            } else {
                convert += information[i].substring(0, 1).toUpperCase() + information[i].substring(1).toLowerCase();
            }
        }
        System.out.println("Response format name "+convert);
        return convert;
    }
    
    
}

