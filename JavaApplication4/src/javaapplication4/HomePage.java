/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication4;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import java.util.Scanner;




 

public class HomePage {
    customerView view = new customerView();
    private String statement, user_input;
    
    //To display everything on home page
    public void display() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
        LocalDateTime current = LocalDateTime.now();  
        statement = "Welcome to Greb Application!\nOptions : \n(Current time : "+dtf.format(current)+")"
                    + "\nA - View System Dashboard\nB - Enter Customer View\nC - Add / Remove Driver\n";
        System.out.println(statement);
    }
    
    //Identify what is the input and execute the function of the user input
    public void input() {
        Scanner s = new Scanner(System.in);
        System.out.print(">> ");
        user_input = s.next();
        Outerloop:
        while(!(user_input.equals("A")||user_input.equals("B")||user_input.equals("C")) ){
            System.out.println("The user input is case-sensitive, please enter a valid alphabet");
            System.out.print(">> ");
            user_input = s.next();
            if(user_input.equals("A")||user_input.equals("B")||user_input.equals("C")) {
                break Outerloop;
            }
        }

        switch(user_input){
            case "A":
                    System.out.println("Hey1");
                    break;
            case "B":
                    view.display();
                    break;
            case "C":
                    System.out.println("Hey3");
                    break;
            default:
        }

    }
}
    

