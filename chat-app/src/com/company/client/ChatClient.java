package com.company.client;

import com.company.server.Cryptography;

import java.io.*;
import java.util.Base64;
import java.util.Scanner;

public class ChatClient  {

    public static void main(String[] args) throws IOException {

        Client client=new Client();
        client.start();
        Cryptography cryptography=new Cryptography();
        String message;

        while(true){
            System.out.println("Enter Message: ");
            Scanner input = new Scanner(System.in);
            message = input.nextLine();
            client.sendMessage(cryptography.encode(message));
            if(message.equalsIgnoreCase("exit"))
                break;

        }

        System.out.println("Client finished the execution");

    }
}
