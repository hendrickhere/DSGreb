/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author hongjun
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        
        Scanner scan = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");  
        LocalDateTime current = LocalDateTime.now(); 
        Graph<String,Integer> g = new Graph<>();
        
       
        customerView view = new customerView();
        queueCustomer queueCustomer = new queueCustomer();
        queueDriver queueDriver = new queueDriver();
        HomePage a = new HomePage();
        
        int count = 0;
        boolean result = true;
        String inputCustomer = "";
        String[] inputCustomerBreak = null;
        g.addVertex("a");
        g.addVertex("b");
        g.addVertex("c");
        g.addUndirectedEdge("a", "b", 1);
        g.addUndirectedEdge("b", "c", 2);
        g.addUndirectedEdge("a", "c", 5);
        
        // Move to itself (incase driver is at the location of the customer)
        g.addEdge("a", "a", 0);
        g.addEdge("b","b",0);
        g.addEdge("c", "c", 0);
        
        
        
        
        
        

        while(result){
            a.display();
            
            

            switch(a.input()){
                case "A":
                         
                        if(queueCustomer.qName.getSize()> 0){
                            for(int i = 0 ; i< queueDriver.qName.getSize(); i++){
                             Date date = new Date();
                             SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
                             
                             if(dateFormat.parse(dateFormat.format(date)).after(dateFormat.parse(queueDriver.qPickupTime.getElement(i)))){
                                 queueCustomer.qStatus.set(i, "picked up");
                             }
                             
                             if(dateFormat.parse(dateFormat.format(date)).after(dateFormat.parse(queueDriver.qArrivalTime.getElement(i)))){
                                 queueCustomer.qStatus.set(i, "reached");
                                 //queueDriver.qLocation.set(i, );
                             }
                      
                             
                          }
                        }
                         
                        
                        System.out.println("\nSystem Dashboard : ");
                        System.out.println("");
                        System.out.println("Requests Lists (List Last Updated Time : "+ dtf.format(current)+ ")"); 
                        System.out.println("(current time : "+ a.getTime()+ ")");
                        System.out.println("===================================================================================================================================");
                        System.out.printf("%10s %15s %30s %15s %20s %20s\n", "Customer","Status","Expected Arrival Time","Capacity","Starting Point","Destination");
                        
                        queueCustomer.display();
                        System.out.println("===================================================================================================================================");
                        
                        System.out.println("\n");
                        System.out.println("Drivers Lists (List Last Updated Time : "+ dtf.format(current)+ ")"); 
                        System.out.println("(current time : "+ a.getTime()+ ")");
                        System.out.println("===================================================================================================================================");
                        System.out.printf("%10s %15s %18s %20s %20s \n", "Driver","Status","Capacity","Location","Customer");
                        
                        queueDriver.display();
                        System.out.println("===================================================================================================================================");
                        
                        
                               
                               
                
                         break;
                         
                         
                case "B":
                         Date date = new Date();
                         SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
                           
                         
                       
                         String choosen = view.display();
                         if(choosen.equalsIgnoreCase("exit")){
                            break;
                         }
                         else if(choosen.equalsIgnoreCase("a")){
                             
                             System.out.println("Enter the details of the customer you want to create (name  Expected arrival time  capacity  starting point  destination) \n(Enter "+" exit "+"to go back to homepage)");
                             System.out.println("\nAvailable route : ");
                             g.printEdges();
                             
                             System.out.print(">> ");
                             inputCustomer = scan.nextLine();
                             
                             if(inputCustomer.equalsIgnoreCase("exit")){
                                 break;
                             }
                             
                             inputCustomerBreak = inputCustomer.split(" ");
                             
                             if(!(g.hasEdge(inputCustomerBreak[3], inputCustomerBreak[4]))){
                                 System.out.println("Route not found");
                                 break;
                             }
                             
                             queueCustomer.add(inputCustomerBreak);
                             
                             Customer customer = new Customer(inputCustomerBreak[0],inputCustomerBreak[1],Integer.parseInt(inputCustomerBreak[2]),inputCustomerBreak[3],inputCustomerBreak[4]);
                             String timeNow = dateFormat.format(date);
                             
                             
                             
                             for(int i = 0 ; i < queueDriver.qName.getSize() ; i++){
                                    int weightDriverToSource = g.getEdgeWeight(queueDriver.qLocation.getElement(i), inputCustomerBreak[3]) ;
                                    int weightSourceToLocation =  g.getEdgeWeight(inputCustomerBreak[3], inputCustomerBreak[4]);
                                    queueDriver.qArrivalTime.enqueue(queueDriver.arrivalTime(timeNow,weightDriverToSource, weightSourceToLocation));
                                    queueDriver.qPickupTime.enqueue(queueDriver.pickupTime(timeNow, weightDriverToSource));
                                    if(queueDriver.qArrivalTime.getSize()> queueDriver.qName.getSize()){
                                        queueDriver.qArrivalTime.dequeue();
                                        queueDriver.qPickupTime.dequeue();
                                    }
                             }
                  
                                                         
                             //while(true){
                                 
                                 System.out.println("The request is received, please choose your driver available in your location) ... ");
                                 
                                 //Print out available driver list
                                 queueDriver.displayDriver(current);
                                       
                 
                                 System.out.print("Please choose your driver in your location (Enter \"exit\" to exit): ");
                                 System.out.print(">> ");
                                 String inputDriver = scan.nextLine();
                                 
                                 if(inputDriver.equalsIgnoreCase("exit")){
                                     //queueDriver.qArrivalTime.dequeue();
                                     //queueDriver.qPickupTime.dequeue();
                                     break;
                                 }
                                 
                                 
                                 int indexCapacity = queueDriver.qName.getIndex(inputDriver);
                                 
                                 if(queueDriver.qCapacity.getElement(indexCapacity) < Integer.parseInt(inputCustomerBreak[2])){
                                     System.out.println("Not enough capacity for driver "+ inputDriver);
                                     break;
                                 }
                                 
                                 
                                 int index = queueDriver.qName.getIndex(inputDriver);
                                 queueDriver.customer(inputCustomerBreak[0], index);
                                 

                                 
                                 if(!(queueDriver.qName.contains(inputDriver))){
                                     System.out.println("Driver not found");
                                 }
                                 
                                 else{
                                    System.out.println("Driver "+ inputDriver + " is on the way to pick you up");                   
                                     
                                 
                                 
//                                    Timer timer = new Timer();
//                                    timer.schedule(new TimerTask() {
//                                    @Override
//                                    public void run() {
//                                        System.out.println("Driver Availability : ");
//
//                                        System.out.println("\n");
//                                        System.out.println("Drivers Lists (List Last Updated Time : "+ dtf.format(current)+ ")"); 
//                                        System.out.println("(current time : "+ a.getTime()+ ")");
//                                        System.out.println("===================================================================================================================================");
//                                        System.out.printf("%10s %15s %20s %20s \n", "Driver","Capacity","Estimated Arrival Time","Reputation");
//
//                                        queueDriver.displayDriverAva();
//
//                                        System.out.println("===================================================================================================================================");
//
//
//
//                                    }
//                                    }, 0, 50000);
                                    queueCustomer.changeStatus(inputCustomerBreak[0], "waiting");
                                    count++;
                                    break;
                                    }
                                 //break;
                             //}
                       
                             
                            
                         
                             
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
                             if(!(g.hasVertex(inputDriverBreak[2]))){
                                 System.out.println("Location unavailable");
                                 break;
                             }
                             Driver driver = new Driver(inputDriverBreak[0],Integer.parseInt(inputDriverBreak[1]),inputDriverBreak[2]);
                             
                             queueDriver.add(inputDriverBreak);
                             
                             
                             System.out.println("Driver is successfully registered!");
                             break;
                         }
                         else if(input.equalsIgnoreCase("b")){
                             
                            System.out.println("\n");
                            System.out.println("Drivers Lists (List Last Updated Time : "+ a.getTime()+ ")"); 
                            System.out.println("(current time : "+ dtf.format(current)+ ")");
                            System.out.println("===================================================================================================================================");
                            System.out.printf("%10s %15s %18s %20s %20s \n", "Driver","Status","Capacity","Location","Customer");
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
                            System.out.printf("%10s %15s %18s %20s %20s \n", "Driver","Status","Capacity","Location","Customer");
                            queueDriver.display();
                            System.out.println("===================================================================================================================================");
                            
                            break;
                         }
                         
//                case "D":   
//                    while(true){
//                                System.out.print("\nAdd available places (exp. Subang Puchong Cheras) Press\" exit\" to exit: ");
//                                String[] inputPlace = scan.nextLine().split(" ");
//                                if(inputPlace[0].equalsIgnoreCase("exit")){
//                                    break;
//                                }
//                                for(int i = 0 ; i< inputPlace.length ; i++){
//                                        g.addVertex(inputPlace[i]);
//                                }
//                                for(int i = 0 ; i < inputPlace.length ; i++){
//                                       System.out.println("Added "+ inputPlace[i] +" successfully");
//                                }
//                            
//                            
//                            
//                                System.out.print("\nAdd available route (From, To , Km) Press\" exit\" to exit: ") ;
//                                String inputRoute = scan.nextLine();
//                                String[] inputRouteBreak = inputRoute.split(" ");
//                                if(inputRoute.equalsIgnoreCase("exit")){
//                                    break;
//                                }
//                                
//                                g.addUndirectedEdge(inputRouteBreak[0], inputRouteBreak[1], Integer.parseInt(inputRouteBreak[2]));
//                                
//                                System.out.println("Route added suceesfully");
//                                
//                                
//                                
//                            
//                            }
//                            
//                            break;
                         
                         
                         
                         
                         
                         
                default: 
                    
                        
            }
            
        }
        
        
        
        
            
    }
    
    
 
         
}

     
    

