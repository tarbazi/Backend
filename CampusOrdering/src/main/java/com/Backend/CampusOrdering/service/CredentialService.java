package com.Backend.CampusOrdering.service;

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Backend.CampusOrdering.repository.CredentialInterface;
import com.Backend.CampusOrdering.model.Credential;

@Service
public class CredentialService {

    private CredentialInterface credentialInterface;

    @Autowired
    public CredentialService(CredentialInterface credentialInterface){
        this.credentialInterface = credentialInterface;
    }

    public Map<String, Object> createUser(String studentnum, String password){

        Map<String, Object> myResponse = new HashMap<>();
        
        String response = "response";
        String ackVal = "Ack";
        String nakVal = "Nak";
        String nakVal_ = "Nak_";
        
        try{

            boolean outcome = credentialInterface.existsByStudentnum(studentnum);

            if (outcome == false){
                credentialInterface.save(new Credential(studentnum, password));
                myResponse.put(response, ackVal);
            }

            else{
                myResponse.put(response, nakVal_);
            }

            return myResponse;

        }

        catch(Exception e){
            System.out.println(e);  // To replace with log-file write;
        }

        myResponse.put(response, nakVal);

        return myResponse;

    }
    
    public Map<String, Object> login(String studentnum, String password){

        Map<String, Object> myResponse = new HashMap<>();

        String response = "response";
        String ackVal = "Ack";
        String nakVal = "Nak";
        String nakVal_ = "Nak_";

        try{

            boolean outcome = credentialInterface.existsByStudentnum(studentnum);
            System.out.println(outcome);

            if (outcome == true){
                System.out.println("Started");
                Credential tempCred = credentialInterface.getByStudentnum(studentnum);
                System.out.println("Finished");
                System.out.println(tempCred.getPassword());
                
                if (password.equals(tempCred.getPassword())){
                    myResponse.put(response, ackVal);

                    return myResponse;
                }

                myResponse.put(response, nakVal_);

            }

        }

        catch(Exception e){
            System.out.println(e); // To replace with log-file write;  
        }

        myResponse.put(response, nakVal);

        return myResponse;

    }

}
