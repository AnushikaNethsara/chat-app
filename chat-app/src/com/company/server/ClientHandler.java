package com.company.server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket client;
    public ClientHandler(Socket socket){
        this.client=socket;

    }

    public void run(){
        try {
            Thread.sleep(1000); // wait for 1 second before executing rest
            InputStream inputStream=client.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));

            DataOutputStream outputStream=new DataOutputStream(client.getOutputStream());

            Cryptography cryptography=new Cryptography();


            //continuous reading data from client
            String inputData;
            while ((inputData= cryptography.decode(bufferedReader.readLine())) !=null){
                switch (inputData){
                    case  "Hello from the Client":
                        outputStream.writeBytes("Hello from the server...\n");
                        break;
                    case  "How are you?":
                        outputStream.writeBytes("I'm fine. How are you? \n");
                        break;
                    case  "I'm fine":
                        outputStream.writeBytes("Okay good to know. \n");
                        break;
                    case  "Thank you":
                        outputStream.writeBytes("You are welcome. \n");
                        break;
                    default:
                        outputStream.writeBytes("I didn't understand that. \n");

                }

                //send data to client
                if(inputData.equals("exit")){
                    break;
                }

            }


            this.client.close();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }


        //receive data

    }

    //two ways to create a thread in java
    //1. Extend the class using Thread super class
    //2. Implement the class using Runnable interface
}
