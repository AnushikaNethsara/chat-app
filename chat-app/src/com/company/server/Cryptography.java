package com.company.server;

import java.util.Base64;

public class Cryptography {

   public String encode(String encodeText){
       String encodedString = Base64.getEncoder().encodeToString(encodeText.getBytes());
       return encodedString;
   }

   public String decode(String encodedString){
       byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
       String decodedString = new String(decodedBytes);
       return decodedString;
   }
}
