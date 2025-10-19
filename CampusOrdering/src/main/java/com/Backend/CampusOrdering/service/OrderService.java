package com.Backend.CampusOrdering.service;

import com.Backend.CampusOrdering.repository.OrderInterface;
import com.Backend.CampusOrdering.model.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

import org.json.JSONObject;
import org.json.JSONArray;

@Service
public class OrderService {

    private OrderInterface orderInterface;

    @Autowired
    public OrderService(OrderInterface orderInterface){
        this.orderInterface = orderInterface;
    }

    public JSONObject placeOrder(String studentNum, String message){
        
        Client myClient = new Client();

        String myMessage = "Please give a resolution in the form an JSON formatted ({Result: [{item:itemName quantity:quantityValue}]} itemName is a single String value for the item, quantityValue is an integer) string for the following text:" + message;

        GenerateContentResponse myResponse = myClient.models.generateContent("gemini-2.5-flash", myMessage, null);

        if (myResponse != null){

            String strResponse = myResponse.text().trim();
            if (strResponse.startsWith("```json")) {
                strResponse = strResponse.replaceAll("```json", "").replaceAll("```", "").trim();
            }

            System.out.println(strResponse);
            JSONObject myJsonObject = new JSONObject(strResponse);
            System.out.println(myJsonObject);
            JSONArray myJsonArr = myJsonObject.getJSONArray("Result");
            
            JSONObject tempObj;
            
            for (int i = 0; i < myJsonArr.length(); i++){

                tempObj = myJsonArr.getJSONObject(i);

                orderInterface.save(new Order(studentNum, tempObj.getString("item"), tempObj.getInt("quantity")));

            }

        }

        System.out.println("Here");
        
        myClient.close();

        JSONObject myJSON = new JSONObject();
        String key  = "response";
        String val = "Ack";
        myJSON.put(key, val);

        System.out.println(myJSON);

        return myJSON;
    }
}
