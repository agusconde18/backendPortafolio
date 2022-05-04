package com.example.backendPortafolio.User;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.security.SecureRandom;
import java.util.HashMap;

@NoArgsConstructor
public class UserTokenValid {


    HashMap<Long,String> tokenUsr=new HashMap<>();




   public boolean checkUser(Long id, String token){
        return tokenUsr.containsKey(id) && tokenUsr.get(id).equals(token);
    }

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    String randomString(int len){
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public UserData addUser(Long id){
        String token= randomString(15);
        tokenUsr.put(id,token);
        return new UserData(id,token);
    }


}
