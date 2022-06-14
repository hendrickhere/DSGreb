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
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hongjun
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        
        Scanner scan2 = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");  
        LocalDateTime current = LocalDateTime.now(); 
        Graph<String,Double> g = new Graph<>();
        
       
        customerView view = new customerView();
        queueCustomer queueCustomer = new queueCustomer();
        queueDriver queueDriver = new queueDriver();
        HomePage a = new HomePage();
        
        int count = 0;
        boolean result = true;
        String inputCustomer = "";
        String[] inputCustomerBreak = null;
        String inputDriver = "";
        ArrayList listPickedDriver = new ArrayList();
        ArrayList listPickedCustomer = new ArrayList();
        ArrayList listCustomerDest = new ArrayList();
        ArrayList listRate = new ArrayList();
        

        
        
        
        
        

        while(result){
            a.display();
            
            

            switch(a.input()){
                case "A":
                        
//                        Timer timer = new Timer();
//                        timer.schedule(new TimerTask() {
//                        @Override
//                        public void run() {
//                           
//                            if(queueCustomer.qName.getSize()> 0){
//                                for(int i = 0 ; i< listPickedDriver.size(); i++){
//                                    //System.out.println("i = " + i);
//                                    //System.out.println("picked customer : " + listPickedCustomer.get(i));      
//                                    //System.out.println("picked driver : " + listPickedDriver.get(i));
//                                    Date date = new Date();
//                                    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
//
//                                    try {
//                                        //System.out.println("Arraylist Size : " + queueDriver.qReputation.getElement(i).size());
//                                        
//                                        //if the time exceeds the picked up time, change the customer status to picked up
//                                        if(dateFormat.parse(dateFormat.format(date)).after(dateFormat.parse(queueDriver.qPickupTime.getElement((int)listPickedDriver.get(i))))){
//                                            if(queueCustomer.qStatus.getElement((int)listPickedCustomer.get(i)).equalsIgnoreCase("reached")){
//                                                continue;
//                                            }
//                                            else{
//                                                queueCustomer.qStatus.set((int)listPickedCustomer.get(i), "picked up");
//                                                
//                                            }
//                                        }
//                                    } catch (ParseException ex) {
//                                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//                                    }
//
//                                    try {
//                                        //if the time exceeds the arrival time, change the customer status to arrived
//                                        if(dateFormat.parse(dateFormat.format(date)).after(dateFormat.parse(queueDriver.qArrivalTime.getElement(((int)listPickedDriver.get(i)))))){
//                                            if(queueCustomer.qStatus.getElement((int)listPickedCustomer.get(i)).equalsIgnoreCase("reached")){
//                                                continue;
//                                            }else{
//                                                queueCustomer.qStatus.set((int)listPickedCustomer.get(i), "reached");
//                                                queueDriver.qLocation.set((int)listPickedDriver.get(i), (String)listCustomerDest.get(i));
//                                                queueDriver.qStatus.set((int)listPickedDriver.get(i), "available");
//                                                queueDriver.qCustomer.set((int)listPickedDriver.get(i), "-");
//                                                
//                                                
//                                                System.out.println("Driver "+ queueDriver.qName.getElement((int)listPickedDriver.get(i)) + " has reached the destination... ");
//                                                System.out.println("Please rate driver "+ queueDriver.qName.getElement((int)listPickedDriver.get(i)));
//                                                System.out.print(">>");
//                                                int inputRate = scan2.nextInt();
//                                                queueDriver.qReputation.getElement((int)listPickedDriver.get(i)).add((double)inputRate);
//                                                
//                                                calculateRating(queueDriver.qReputation);
//                                                
//                                                timer.cancel();
//                                                
//                                                
//                                                
//                                            }
//                                            
//                                            
//                                        }
//                                    } catch (ParseException ex) {
//                                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//                                    }
//
//                              }
//                           }
//                            
//
//                        }
//                        }, 0, 5000);
                    
                       
                            if(queueCustomer.qName.getSize()> 0){
                                for(int i = 0 ; i< listPickedDriver.size(); i++){

                                    Date date = new Date();
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");


                                        
                                        //if the time exceeds the picked up time, change the customer status to picked up
                                        if(dateFormat.parse(dateFormat.format(date)).after(dateFormat.parse(queueDriver.qPickupTime.getElement((int)listPickedDriver.get(i))))){
                                            if(queueCustomer.qStatus.getElement((int)listPickedCustomer.get(i)).equalsIgnoreCase("reached")){
                                                continue;
                                            }
                                            else{
                                                queueCustomer.qStatus.set((int)listPickedCustomer.get(i), "picked up");
                                                
                                            }
                                        }
                                    

                                    
                                        //if the time exceeds the arrival time, change the customer status to arrived
                                        if(dateFormat.parse(dateFormat.format(date)).after(dateFormat.parse(queueDriver.qArrivalTime.getElement(((int)listPickedDriver.get(i)))))){
                                            if(queueCustomer.qStatus.getElement((int)listPickedCustomer.get(i)).equalsIgnoreCase("reached")){
                                                continue;
                                            }else{
                                                queueCustomer.qStatus.set((int)listPickedCustomer.get(i), "reached");
                                                queueDriver.qLocation.set((int)listPickedDriver.get(i), (String)listCustomerDest.get(i));
                                                queueDriver.qStatus.set((int)listPickedDriver.get(i), "available");
                                                queueDriver.qCustomer.set((int)listPickedDriver.get(i), "-");
                                                
                                                
                                                //System.out.println("Driver "+ queueDriver.qName.getElement((int)listPickedDriver.get(i)) + " has reached the destination... ");
                                                //System.out.println("Please rate driver "+ queueDriver.qName.getElement((int)listPickedDriver.get(i)));
                                                //System.out.print(">>");
                                                //int inputRate = scan2.nextInt();
                                                //queueDriver.qReputation.getElement((int)listPickedDriver.get(i)).add((double)inputRate);
                                                
                                                
                                                
                                                
                                                
                                                
                                                
                                            }
                                            
                                            
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

                             
                             
                             System.out.print(">> ");
                             inputCustomer = scan.nextLine();
                             
                             if(inputCustomer.equalsIgnoreCase("exit")){
                                 break;
                             }
                             
                             inputCustomerBreak = inputCustomer.split(" ");
                             

                             
                             
                             queueCustomer.add(inputCustomerBreak);
                             
                             listPickedCustomer.add(queueCustomer.qName.getIndex(inputCustomerBreak[0]));
                             
                             
                             String starting = inputCustomerBreak[3]+" "+ inputCustomerBreak[4];
                             String destination = inputCustomerBreak[5]+" "+ inputCustomerBreak[6];
                             double startingLa = Double.parseDouble(inputCustomerBreak[3]);
                             double startingLong = Double.parseDouble(inputCustomerBreak[4]);
                             double destLa = Double.parseDouble(inputCustomerBreak[5]);
                             double destLong = Double.parseDouble(inputCustomerBreak[6]);
                             
                             g.addVertex(starting);
                             g.addVertex(destination);
                             g.addUndirectedEdge(starting, destination, calculateDistance(startingLa,startingLong, destLa, destLong));
                             g.addUndirectedEdge(starting, starting, 0.0);
                             g.addUndirectedEdge(destination, destination, 0.0);
                             
                             listCustomerDest.add((String)destination);
                             
                             //Customer customer = new Customer(inputCustomerBreak[0],inputCustomerBreak[1],Integer.parseInt(inputCustomerBreak[2]),inputCustomerBreak[3],inputCustomerBreak[4]);
                             String timeNow = dateFormat.format(date);
                             
                             for(int i = 0  ; i < queueDriver.qName.getSize(); i++){
                                 String[] array = queueDriver.qLocation.getElement(i).split(" ");
                                 g.addUndirectedEdge(queueDriver.qLocation.getElement(i), starting,calculateDistance(Double.parseDouble(array[0]), Double.parseDouble(array[1]), startingLa, startingLong));
                             }
                             
                             


                                for(int i = 0 ; i < queueDriver.qName.getSize() ; i++){
                                       double weightDriverToSource = g.getEdgeWeight(queueDriver.qLocation.getElement(i), starting) ;

                                       double weightSourceToLocation =  g.getEdgeWeight(starting, destination);


                                       //queueDriver.qArrivalTime.enqueue(queueDriver.arrivalTime(timeNow,weightDriverToSource, weightSourceToLocation));
                                       queueDriver.qArrivalTime.set(i, queueDriver.arrivalTime(timeNow, weightDriverToSource, weightSourceToLocation));
                                       //queueDriver.qPickupTime.enqueue(queueDriver.pickupTime(timeNow, weightDriverToSource));
                                       queueDriver.qPickupTime.set(i, queueDriver.pickupTime(timeNow, weightDriverToSource));
                                       
                                }
                  
                                                         
                             //while(true){
                                 
                                 System.out.println("The request is received, please choose your driver available in your location) ... ");
                                 
                                 //Print out available driver list
                                 queueDriver.displayDriver(current);
                                       
                 
                                 System.out.print("Please choose your driver... (Enter \"exit\" to exit): ");
                                 System.out.print(">> ");
                                 inputDriver = scan.nextLine();
                                 
                                 if(inputDriver.equalsIgnoreCase("exit")){
                                     //queueDriver.qArrivalTime.dequeue();
                                     //queueDriver.qPickupTime.dequeue();
                                     break;
                                 }
                                 
                                 
                                 int index = queueDriver.qName.getIndex(inputDriver);
                                 
                                 // Check if the capacity of the driver is smaller than capacity of customer
                                 if(queueDriver.qCapacity.getElement(index) < Integer.parseInt(inputCustomerBreak[2])){
                                     System.out.println("Not enough capacity for driver "+ inputDriver);
                                     break;
                                 }
                                 
                                 listPickedDriver.add((int)index);
                            
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
                         
                case "C":
                         System.out.println("\nAre you trying to add or remove a driver? (Enter "+"exit"+" to go back to homepage): ");
                         
                         System.out.println("Options : ");
                         
                         System.out.println("A - Add new driver " + "\nB - Remove driver");
                         
                         String input = scan.nextLine();
                         
                         if(input.equalsIgnoreCase("exit")){
                             break;
                         }
                          
                         else if(input.equalsIgnoreCase("a")){
                             System.out.println("Enter the details of the driver you want to create (name, capacity, location) : ");
                             String inputDriver1 = scan.nextLine();
                             String[] inputDriverBreak = inputDriver1.split(" ");
                             //if(!(g.hasVertex(inputDriverBreak[2]))){
                                 //System.out.println("Location unavailable");
                                 //break;
                             //}
                             //Driver driver = new Driver(inputDriverBreak[0],Integer.parseInt(inputDriverBreak[1]),inputDriverBreak[2]);
                             
                             queueDriver.add(inputDriverBreak);
                             g.addVertex(inputDriverBreak[2] +" "+ inputDriverBreak[3]);
                             
                             
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
                    
                         
                default: 
                    
                        
            }
            
        }
        
        
        
        
            
    }
    public static double calculateDistance(double startingLatitude,double startingLongtitude, double destinationLatitude, double destinationLongtitude){
        // Calculate the distance between each latitude and longtitude
        double distLa = Math.toRadians(destinationLatitude - startingLatitude);
        double distLong = Math.toRadians(destinationLongtitude - startingLongtitude);
        
        // Implementing Haversine formula
        double temp = Math.pow(Math.sin(distLa/2), 2) + Math.cos(Math.toRadians(startingLatitude)) * Math.cos(Math.toRadians(destinationLatitude))
                      * Math.pow(Math.sin(distLong/2), 2);
        
        double result = 2 * Math.asin(Math.sqrt(temp));
        
        // Radius of earth in kilometers
        double radius = 6371;
        
        return result * radius;
        
        
    }
    
//    public static void calculateRating(Queue<ArrayList<Double>> q){
//        for(int i = 0 ; i < q.getSize(); i ++){
//            double total = 0;
//            double average = 0;
//            for(int y = 0 ; y < q.getElement(i).size() ; y++){
//                total += (double)q.getElement(i).get(y);
//            }
//            ArrayList list = new ArrayList();
//            if(total == 0){
//                average = total;
//            }else{
//                average = total/q.getElement(i).size();
//            }
//            
//            list.add((double)average);
//            q.set(i, list);
//        }
//    }
    
    
 
         
}

     
    

