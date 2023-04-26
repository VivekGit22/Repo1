/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ffserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 *switch(this.userInput){
                       case "1":
                           this.userInput="What is the capital of France?";
                           break;
                       case "2":
                           this.userInput="What is the largest planet in our solar system?";
                           break;
                       case "3":
                           this.userInput="Who directed the movie Jaws?";
                           break;
                       case "4":
                           this.userInput="What is the highest mountain in Africa?";
                           break;
                       case "5":
                           this.userInput="What is the chemical symbol for gold?"; 
                           break;
                       default:
                           this.userInput="Game Over";
                       
                   
                   
                   
                   }
                   * 
                   * 
                   *  if (clients.size() == i) {
                System.out.println("All players joined successfully\nStarting the game !!!!!!!!!!!  ");
            }
            else{
                System.out.println("More to join !");
            }
            try {
                if (clients.size() == i) {
                   for (int j = 0; j < 5; j++) {
                 Choose a random question
                    String ques = questions.get(j);

                    this.userInput = ques;
                        if (userInput != null & userInput.length() > 0) {
                            for (ClientHandler client : clients) {
                                client.out.println(userInput);
                                client.out.flush();
                            Thread.currentThread();
                            Thread.sleep(1 * 1000);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
 * @author kaush
 */
public class SendMessage extends Thread {
     List<ClientHandler> clients;
     String userInput,inp;
     int i;
     BufferedReader console;

        public SendMessage(List<ClientHandler> clients,int i) {
            this.clients = clients;
            this.userInput = null;
            this.inp=null;
            this.i=i;
            this.start();
        }

        public void run() {
           
            if (clients.size() == i) {
                System.out.println("All players joined successfully\nStarting the game !!!!!!!!!!!  ");
            }
            else{
                System.out.println("More to join !");
            }
            try {
                
                if (clients.size() == i) {                    
                    System.out.println("Enter the Questions:");
                    
                   this.console = new BufferedReader(new InputStreamReader( System.in));
                   this.userInput=console.readLine();
                   //System.out.println(this.userInput);
                   switch(this.userInput){
                       case "1":
                           this.userInput="1 What is the capital of France? A.Paris B.Rouen C.Caen D.Rennes";
                           break;
                       case "2":
                           this.userInput="2 What is the largest planet in our solar system? A.Neptune B.Jupiter C.Mars D.Uranus";
                           break;
                       case "3":
                           this.userInput="3 Winner of FIFA 2022? A.Argentina B.France C.Brazil D.Poland ";
                           break;
                       case "4":
                           this.userInput="4 Which is the highest mountain in Africa? A.Kenya B.Cameroon C.Kilimanjaro D.Elgon";
                           break;
                       case "5":
                           this.userInput="5 What is the chemical symbol for gold? A.Ag B.Al C.Fe D.Au "; 
                           break;
                       default:
                           this.userInput="Game Over";
                           break;
                   }
                    while ((this.userInput) != null) {
                        
                        if (userInput != null & userInput.length() > 0) {
                            for (ClientHandler client : clients) {
                                client.out.println(userInput);
                                client.out.flush();
                            Thread.currentThread();
                            Thread.sleep(1 * 1000);
                            
                            
                            }
                            this.userInput=null;
                            
                        }
                         this.console = new BufferedReader(new InputStreamReader( System.in));
                   this.userInput=console.readLine();
                   switch(this.userInput){
                       case "1":
                           this.userInput="1 What is the capital of France? A.Paris B.Rouen C.Caen D.Rennes";
                           break;
                       case "2":
                           this.userInput="2 What is the largest planet in our solar system? A.Neptune B.Jupiter C.Mars D.Uranus";
                           break;
                       case "3":
                           this.userInput="3 Winner of FIFA 2022? A.Argentina B.France C.Brazil D.Poland ";
                           break;
                       case "4":
                           this.userInput="4 Which is the highest mountain in Africa? A.Kenya B.Cameroon C.Kilimanjaro D.Elgon";
                           break;
                       case "5":
                           this.userInput="5 What is the chemical symbol for gold? A.Ag B.Al C.Fe D.Au "; 
                           break;
                       default:
                           this.userInput="Game Over";
                           break;
                    }
                    
                }
            }} catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
