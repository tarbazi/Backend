package com.Backend.CampusOrdering.service;

import com.Backend.CampusOrdering.repository.OrderInterface;
import com.Backend.CampusOrdering.model.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

import org.json.JSONObject;
import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {

    private OrderInterface orderInterface;

    @Autowired
    public OrderService(OrderInterface orderInterface){
        this.orderInterface = orderInterface;
    }

    public Map<String, Object> placeOrder(String studentnum, String message){
        
        Client myClient = new Client();

        Map<String, Object> myJSONResponse = new HashMap<>();
        String key  = "response";
        String ackVal = "Ack";
        String nakVal = "Nak";
 
        String myMessage = "Please give a resolution in the form a JSON formatted ({Result: [{item:itemName quantity:quantityValue}]} itemName is a single String value for the item, quantityValue is an integer) string for the following text:" + message;
        GenerateContentResponse myResponse;

        try{

            myResponse = myClient.models.generateContent("gemini-2.5-flash", myMessage, null);
            myClient.close();

            String strResponse = myResponse.text().trim();
            if (strResponse.startsWith("```json")) {
                strResponse = strResponse.replaceAll("```json", "").replaceAll("```", "").trim();
            }

            JSONObject myJsonObject = new JSONObject(strResponse);
            JSONArray myJsonArr = myJsonObject.getJSONArray("Result");
            JSONObject tempObj;
            
            for (int i = 0; i < myJsonArr.length(); i++){
                tempObj = myJsonArr.getJSONObject(i);
                orderInterface.save(new Order(studentnum, tempObj.getString("item"), tempObj.getInt("quantity")));
            }

        }

        catch(Exception e){

            myClient.close();
            myJSONResponse.put(key, nakVal);

            System.out.println(e);  // To replace with log-file write;

            return myJSONResponse;

        }

        myJSONResponse.put(key, ackVal);

        return myJSONResponse;

    }
}
