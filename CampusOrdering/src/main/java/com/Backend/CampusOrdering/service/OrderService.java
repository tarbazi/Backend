package com.Backend.CampusOrdering.service;

import com.Backend.CampusOrdering.repository.OrderInterface;
import com.Backend.CampusOrdering.model.Orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

import org.json.JSONObject;
import org.json.JSONArray;

@Service
public class OrderService {

    @Autowired
    private OrderInterface orderInterface;

    @Autowired
    public OrderService(OrderInterface orderInterface){
        this.orderInterface = orderInterface;
    }

    public String placeOrder(String studentNum, String message){
        
        Client myClient = new Client();

        String myMessage = "Please give a resolution in the form an JSON formatted ({Result: [{item:itemName quantity:quantityValue}]} itemName is a single String value for the item, quantityValue is an integer) string for the following text:" + message;

        GenerateContentResponse myResponse = myClient.models.generateContent("gemini-2.5-flash", myMessage, null);

        if (myResponse != null){

            String strResponse = myResponse.text().substring(8, myResponse.text().length() - 3);
            System.out.println(strResponse);
            JSONObject myJsonObject = new JSONObject(strResponse);
            System.out.println(myJsonObject);
            JSONArray myJsonArr = myJsonObject.getJSONArray("Result");
            
            JSONObject tempObj;
            
            for (int i = 0; i < myJsonArr.length(); i++){

                tempObj = myJsonArr.getJSONObject(i);

                orderInterface.save(new Orders(studentNum, tempObj.getString("item"), tempObj.getInt("quantity")));

            }

        }

        myClient.close();

        return "OK";
    }
}
