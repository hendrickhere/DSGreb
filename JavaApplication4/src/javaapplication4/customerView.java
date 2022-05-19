/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication4;

import java.util.Scanner;

/**
 *
 * @author hongjun
 */
public class customerView {
    Scanner scan = new Scanner(System.in);
    public void display(){
        System.out.println("You are in customer view now (Enter"+" exit "+ "to go back to homepage): ");
        System.out.println("Option: ");
        System.out.println("A - Create customer requests");
        System.out.println("B - Update customer requests");
        
        System.out.print(">> ");
        String option = scan.next();
        Outerloop:
        while(!(option.equals("A")||option.equals("B"))){
            System.out.println("The user input is case-sensitive, please enter a valid alphabet");
            System.out.print(">> ");
            option = s.next();
            if(option.equals("A")||option.equals("B")) {
                break Outerloop;
            }
        }

        switch(option){
            case "A":
                    System.out.println("Hey1");
                    break;
            case "B":
                    view.display();
                    break;
            default:
        }
    }
    
}
