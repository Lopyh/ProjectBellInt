package eas.hash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.util.Random;

@Component
public class HashCreator{
    public static String randomString(){
        String mas ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rm = new Random();
        StringBuilder stringBuilder = new StringBuilder(5);
        for (int i = 0; i < 5; i++) {
            stringBuilder.append(mas.charAt(rm.nextInt(26)+1));
        }
        return stringBuilder.toString();
    }

    @Autowired
    public static String getSHA256(String data){
        StringBuffer sb = new StringBuffer();
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(data.getBytes());
            byte byteData[] = md.digest();

            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }
}
