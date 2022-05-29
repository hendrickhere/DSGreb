/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication4;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import java.util.Scanner;




 

public class HomePage {
    
    private String statement, user_input,loginTime;

    

    
    public String getTime() {
        return loginTime;
    }
    
    //To display everything on home page
    public void display() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");  
        LocalDateTime current = LocalDateTime.now(); 
        loginTime  = dtf.format(current);
        statement = "\nWelcome to Greb Application!\nOptions : \n(Current time : "+loginTime+")"
                    + "\nA - View System Dashboard\nB - Enter Customer View\nC - Add / Remove Driver\n";
        System.out.println(statement);
    }
    
    //Identify what is the input and execute the function of the user input
    public String input() {
        Scanner s = new Scanner(System.in);
        System.out.print(">> ");
        user_input = s.next();
        Outerloop:
        while(!(user_input.equals("A")||user_input.equals("B")||user_input.equals("C"))){
            System.out.println("The user input is case-sensitive, please enter a valid alphabet");
            System.out.print(">> ");
            user_input = s.next();
            if(user_input.equals("A")||user_input.equals("B")||user_input.equals("C")) {
                break Outerloop;
            }
        }

       return user_input;

    }
}
    

