/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.ffserver;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kaush
 */
public class FFserver extends Thread {

    HashMap<String, String> ap = new HashMap<>();
    HashMap<String, Integer> score = new HashMap<>();
    ServerSocket server;
    List<ClientHandler> clients;

    DataOutputStream ot;

    DataInputStream in, in2;
    int i, x = 0,c=0;

    public FFserver(int port) {
        try {
            Scanner sc = new Scanner(System.in);
            ap.put("1", "A");
            ap.put("2", "B");
            ap.put("3", "A");
            ap.put("4", "C");
            ap.put("5", "D");
            this.server = new ServerSocket(port);
            System.out.println("New server initialized!");
            System.out.println("Enter the total number of players :");
            i = sc.nextInt();
            clients = Collections.synchronizedList(new ArrayList<ClientHandler>());
            this.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
       
        while (true) {
            if (i > x) {
                try {
                    Socket client = server.accept();
                    String st = "";
                    in = new DataInputStream(new BufferedInputStream(client.getInputStream()));
                    st = in.readUTF();
                    x++;
                    System.out.println(st + " connected" + x);
                    ClientHandler newClient = new ClientHandler(client);
                    clients.add(newClient);
                    score.put(st, 0);
                    new SendMessage(clients, i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                  StringBuilder sb = new StringBuilder("");
                  long time=Long.MAX_VALUE;
                for (ClientHandler cl : clients) {
                    try {
                        in = new DataInputStream(new BufferedInputStream(cl.client.getInputStream()));
                        String st1 = in.readUTF();
                        System.out.println(st1);
                        String sp[] = st1.split(" ");
                       
                  
                        String tym[] = sp[8].split(":");
                        long curr = Long.parseLong(tym[0])*3600 +Long.parseLong(tym[1])*60 + Long.parseLong(tym[2]);
                        if(ap.get(sp[0]).equalsIgnoreCase(sp[1]) && time>curr)
                        {
                            time = curr;
                            sb = new StringBuilder(sp[4]);
                        }

                        //  ap.put(cl.client,)
                    } catch (IOException ex) {
                        Logger.getLogger(FFserver.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(time<Long.MAX_VALUE) 
                     score.put(sb.toString(),score.getOrDefault(sb.toString(),0)+1 );
                for(String s:score.keySet())
                {
                    System.out.println(s+" "+score.get(s));
                }
                c++;
            }
            if(c==5)
            {
                
                StringBuilder winner = new StringBuilder("No one has answered correctly ");
                int maxi=-1;
                for(String el:score.keySet())

                {
                    if(score.get(el)>maxi)
                    {
                        maxi = score.get(el);
                        winner = new StringBuilder(el);
                    }
                }
                if (maxi==0)
                    winner=new StringBuilder("None, as no one has answered correctly :(");
                
                
                for (ClientHandler client : clients) {
                                client.out.println("Game Over : WInner is "+winner);
                                client.out.flush();
                              
                            }
                System.out.println("winner is "+winner);
                try {
                    server.close();
                } catch (IOException ex) {
                    Logger.getLogger(FFserver.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        new FFserver(1200);
    }
}
