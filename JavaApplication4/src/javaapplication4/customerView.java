/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author hongjun
 */
public class customerView {
    
    Scanner scan = new Scanner(System.in);
    

    
    
    public String display(){
        String option;
        System.out.println("You are in customer view now (Enter"+" exit "+ "to go back to homepage): ");
        System.out.println("Option: ");
        System.out.println("A - Create customer requests");
        System.out.println("B - Update customer requests");
        option = scan.nextLine();
        return option;
         
    }
    
    
    
    
   

    


    
    
    
    
    
    
}
