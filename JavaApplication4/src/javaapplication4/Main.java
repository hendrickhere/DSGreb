/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author hongjun
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
        LocalDateTime current = LocalDateTime.now(); 
        
       
        customerView view = new customerView();
        queueCustomer queueCustomer = new queueCustomer();
        queueDriver queueDriver = new queueDriver();
        HomePage a = new HomePage();
        
        
        boolean result = true;

        while(result){
            a.display();
            
            

            switch(a.input()){
                case "A":
                         
                        
                        System.out.println("\nSystem Dashboard : ");
                        System.out.println("");
                        System.out.println("Requests Lists (List Last Updated Time : "+ a.getTime()+ ")"); 
                        System.out.println("(current time : "+ dtf.format(current)+ ")");
                        System.out.println("===================================================================================================================================");
                        System.out.printf("%10s %15s %30s %15s %20s %20s\n", "Customer","Status","Expected Arrival Time","Capacity","Starting Point","Destination");
                        
                        //System.out.println("Customer  Status    Expected Arrival Time   Capacity  Starting Point       Destination      " );        //2 ,4 ,3,2,7
                        queueCustomer.display();
                        System.out.println("===================================================================================================================================");
                        
                        System.out.println("\n");
                        System.out.println("Drivers Lists (List Last Updated Time : "+ a.getTime()+ ")"); 
                        System.out.println("(current time : "+ dtf.format(current)+ ")");
                        System.out.println("===================================================================================================================================");
                        System.out.printf("%10s %15s %18s %20s %20s \n", "Driver","Status","Capacity","Location","Customer");
                        
                        queueDriver.display();
                        System.out.println("===================================================================================================================================");
                        
                        
                               
                               
                
                         break;
                case "B":
                        
                         String choosen = view.display();
                         if(choosen.equalsIgnoreCase("exit")){
                            break;
                         }
                         else if(choosen.equalsIgnoreCase("a")){
                             
                             System.out.println("Enter the details of the customer you want to create (name, Expected arrival time, capacity, starting point, destination) \n(Enter "+"exit "+"to go back to homepage)");
                             String inputCustomer = scan.nextLine();
                             
                             
                             String[] inputCustomerBreak = inputCustomer.split(" ");
                             
                             queueCustomer.add(inputCustomerBreak);
                             
                             Customer customer = new Customer(inputCustomerBreak[0],inputCustomerBreak[1],Integer.parseInt(inputCustomerBreak[2]),inputCustomerBreak[3]+inputCustomerBreak[4],inputCustomerBreak[5]+inputCustomerBreak[6]);
                             
                             System.out.println("The request is received, please choose your driver... ");
                             
                            
                             
                             break;
                         }
                         else if(choosen.equalsIgnoreCase("b")){
                             System.out.println("Pleasae Enter Aspect that need to update: ");
                             System.out.println("Name                 : n "
                                             +"\nExpected Arriva Time : e "
                                             +"\nCapacity             : c" 
                                             +"\nStarting Point       : s" 
                                             +"\nDestination          : d" 
                                             +"\n>>");
                             
                             String inputAspect = scan.nextLine();
                             
                             System.out.print("Please Enter Customer Name To Update Requests : ");
                             
                             String inputName = scan.nextLine();
                             
                             System.out.println("Please Enter New Update To Update Requests : ");
                             
                             String inputNewUpdate = scan.nextLine();
                             
                             queueCustomer.update(inputName, inputAspect, inputNewUpdate);
                             
                             break;
                             
                             
                             
                         }
                         else{
                             System.out.println("Invalid input");
                             break;
                         }
                         
                case "C":System.out.println("\nAre you trying to add or remove a driver? (Enter "+"exit"+" to go back to homepage): ");
                         
                         System.out.println("Options : ");
                         
                         System.out.println("A - Add new driver " + "\nB - Remove driver");
                         
                         String input = scan.nextLine();
                         
                         if(input.equalsIgnoreCase("exit")){
                             break;
                         }
                          
                         else if(input.equalsIgnoreCase("a")){
                             System.out.println("Enter the details of the driver you want to create (name, capacity, location) : ");
                             String inputDriver = scan.nextLine();
                             String[] inputDriverBreak = inputDriver.split(" ");
                             
                             Driver driver = new Driver(inputDriverBreak[0],Integer.parseInt(inputDriverBreak[1]),inputDriverBreak[2]+inputDriverBreak[3]);
                             
                             queueDriver.add(inputDriverBreak);
                             
                             System.out.println("Driver is successfully registered!");
                         }
                         else if(input.equalsIgnoreCase("b")){
                             
                            System.out.println("\n");
                            System.out.println("Drivers Lists (List Last Updated Time : "+ a.getTime()+ ")"); 
                            System.out.println("(current time : "+ dtf.format(current)+ ")");
                            System.out.println("===================================================================================================================================");
                            System.out.println("Driver A   Status         Capacity      Location      Customer " );
                            queueDriver.display();
                            System.out.println("===================================================================================================================================");
                            
                            System.out.println("\nEnter the driver name you want to select (Enter "+"exit" + " to go back to homepage): ");
                            
                            
                            String deleteDriver = scan.nextLine();
                            
                            if(deleteDriver.equalsIgnoreCase("exit")){
                                break;
                            }
                            
                            
                            
                            queueDriver.delete(deleteDriver);
                            
                            System.out.println("\n");
                            System.out.println("Drivers Lists (List Last Updated Time : "+ a.getTime()+ ")"); 
                            System.out.println("(current time : "+ dtf.format(current)+ ")");
                            System.out.println("===================================================================================================================================");
                            System.out.println("Driver A   Status         Capacity      Location      Customer " );
                            queueDriver.display();
                            System.out.println("===================================================================================================================================");
                            
                         }
                         
                         
                         
                         
                         
                         
                default: 
            }
            
        }
        
        
        
        
            
    }
         
}

     
    

