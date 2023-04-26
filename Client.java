/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ffserver;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  

/**
 *
 * @author kaush
 */
public class Client {

    Socket client;
    BufferedReader in;
    DataOutputStream ot, ot1;

    public Client(String hostName, int ip) {
        try {
            this.client = new Socket(hostName, ip);

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your name:");
            String l = sc.nextLine();
            ot = new DataOutputStream(this.client.getOutputStream());
            ot.writeUTF(l);
            this.in = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
            String buffer = null;
            while ((buffer = in.readLine()) != null) {
                
                System.out.println(buffer);
                
                 String sp[] = buffer.split(" ");
                 if(sp[0].charAt(0)-'0'>=0 && sp[0].charAt(0)-'0'<=9){
                System.out.println("Answer:");
                String l1 = sc.nextLine();
                
                l1 = sp[0]+" "+ l1 + " received from " + l +" "+ new java.util.Date();
                ot = new DataOutputStream(this.client.getOutputStream());
                ot.writeUTF(l1);
                 }
                 else
                    System.exit(0);
     }

        } catch (UnknownHostException e) {
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
        new Client("192.168.137.1", 1200);
    }
}
