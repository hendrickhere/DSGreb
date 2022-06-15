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
        Graph<String,Double> g = new Graph<>();


        customerView view = new customerView();
        queueCustomer queueCustomer = new queueCustomer();
        queueDriver queueDriver = new queueDriver();
        HomePage a = new HomePage();

        int count = 0;
        boolean result = true;
        String inputCustomer = "";
        String[] inputCustomerBreak = null;
//        g.addVertex("a");
//        g.addVertex("b");
//        g.addVertex("c");
//        g.addUndirectedEdge("a", "b", 1);
//        g.addUndirectedEdge("b", "c", 2);
//        g.addUndirectedEdge("a", "c", 5);
//
//        // Move to itself (incase driver is at the location of the customer)
//        g.addEdge("a", "a", 0);
//        g.addEdge("b","b",0);
//        g.addEdge("c", "c", 0);







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
                    String choosen = view.display();
                    Date bdate = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("HHmm");
                    String btime = dateFormat.format(bdate);
                    DateTimeFormatter b_dtf = DateTimeFormatter.ofPattern("HHmm");
                    Customer customer;
                    String selectDriver="";
                    if(choosen.equalsIgnoreCase("exit")){
                        break;
                    }
                    else if(choosen.equalsIgnoreCase("a")){

                        System.out.print("Enter the details of the customer you want to create (name, Expected arrival time, capacity, starting point, destination) \n(Enter "+"exit "+"to go back to homepage)\n>>");
                        inputCustomer = scan.nextLine();

                        if(inputCustomer.equalsIgnoreCase("exit")){
                            break;
                        }
                        inputCustomerBreak = inputCustomer.split(" ");

                        queueCustomer.add(inputCustomerBreak);

                        customer = new Customer(inputCustomerBreak[0],inputCustomerBreak[1],Integer.parseInt(inputCustomerBreak[2]),inputCustomerBreak[3]+inputCustomerBreak[4],inputCustomerBreak[5]+inputCustomerBreak[6]);
                        System.out.println("\nThe request is received, please choose your driver... ");
                        System.out.println("\nDriver Availability:");
                        System.out.println("Drivers Lists (List Last Updated Time : "+ btime+ ")");
                        System.out.println("(current time : "+ dtf.format(current)+ ")");

                        System.out.println("===================================================================================================================================");
                        System.out.printf("%10s %20s %30s %20s \n", "Driver","Capacity","Estimated Arrival Time","Reputation");

                        int timedif = Integer.parseInt(b_dtf.format(current))-Integer.parseInt(btime);
                        queueDriver.qArrivalTime=new Queue<>();
                        for(int i = 0 ; i < queueDriver.qName.getSize() ; i++){
//
                            String[] drvLoc= queueDriver.qLocation.getElement(i).split(" ");
                            int toCusAdd = (int) calculateDistance(Double.parseDouble(drvLoc[0]), Double.parseDouble(drvLoc[1]), Double.parseDouble(inputCustomerBreak[3]), Double.parseDouble(inputCustomerBreak[4]));
                            int fromCustoDes = (int) calculateDistance(Double.parseDouble(inputCustomerBreak[3]), Double.parseDouble(inputCustomerBreak[4]), Double.parseDouble(inputCustomerBreak[5]), Double.parseDouble(inputCustomerBreak[6]));
//                            String[] driverArvTime=queueDriver.arrivalTime(dtf.format(current),toCusAdd,fromCustoDes).split(":");
                            queueDriver.qArrivalTime.enqueue(queueDriver.arrivalTime(dtf.format(current),toCusAdd,fromCustoDes));
                            queueDriver.qPickupTime.enqueue(queueDriver.pickupTime(dtf.format(current),toCusAdd));
                            if (customer.getCapacity()<=queueDriver.qCapacity.getElement(i))
                            {
//                                System.out.println("(customer : "+ customer.getArrivalTime()+ ")");
//                                System.out.println("(timediff : "+timedif+ ")");
//                                System.out.println("(TIME : "+ Integer.parseInt(queueDriver.qArrivalTime.getElement(i))+ ")");
//                                System.out.println("(TIME2 : "+ (Integer.parseInt(queueDriver.qArrivalTime.getElement(i))+timedif)+ ")");
                                String[] driverArvTime = queueDriver.qArrivalTime.getElement(i).split(":");
                                String arriveTimedrv = driverArvTime[0]+driverArvTime[1];
                                if(Integer.parseInt(arriveTimedrv)<=(Integer.parseInt(customer.getArrivalTime())+timedif))
                                {
                                    System.out.printf("%10s %20s %30s %20s \n",queueDriver.qName.getElement(i), queueDriver.qCapacity.getElement(i),queueDriver.qArrivalTime.getElement(i),queueDriver.qReputation.getElement(i));


                                }
                            }

                        }
                        System.out.println("===================================================================================================================================");
                        System.out.print("\nEnter the driver name you want to select (Enter "+"exit "+"to go back to homepage):\n>>");
                        String pickDriver = scan.nextLine();

                        if(pickDriver.equalsIgnoreCase("exit")){
                            break;
                        }
                        if(queueDriver.select(pickDriver))
                        {
                            System.out.println(pickDriver+" is on the way to pick you up.");
                            selectDriver=pickDriver;

                        }

                        break;
                    }

                    else if(choosen.equalsIgnoreCase("b")){
                        System.out.println("Please Enter Aspect that need to update: ");
                        System.out.print("Name                 : n "
                                +"\nExpected Arrival Time : e "
                                +"\nCapacity             : c"
                                +"\nStarting Point       : s"
                                +"\nDestination          : d"
                                +"\n>>");

                        String inputAspect = scan.nextLine();

                        System.out.print("Please Enter Customer Name To Update Requests : ");

                        String inputName = scan.nextLine();

                        System.out.print("Please Enter New Update To Update Requests : \n(Enter "+"exit "+"to go back to homepage)\n>> ");

                        String inputNewUpdate = scan.nextLine();
                        if(inputNewUpdate.equalsIgnoreCase("exit")){
                            break;
                        }
                        queueCustomer.update(inputName, inputAspect, inputNewUpdate);
                        Customer updatedCustomer=null ;
                        int updateCusQPos=-1;
                        boolean foundRecord=false;
                        for(int i = 0 ; i < queueCustomer.qName.getSize() ; i++){


                            if(queueCustomer.qName.getElement(i).equalsIgnoreCase(inputName)){
                                updatedCustomer = new Customer(queueCustomer.qName.getElement(i),queueCustomer.qTime.getElement(i),queueCustomer.qCapacity.getElement(i),queueCustomer.qStartingPoint.getElement(i),queueCustomer.qDestination.getElement(i));

                                updateCusQPos=i;
                                foundRecord=true;
                                break;
                            }

                        }
                        if(!foundRecord)
                        {
                            System.out.println("\nYour request is not found in the system! Please create new request.");
                            break;
                        }
                        System.out.println("\nDriver Availability:");
                        System.out.println("Drivers Lists (List Last Updated Time : "+ btime+ ")");
                        System.out.println("(current time : "+ dtf.format(current)+ ")");

                        System.out.println("===================================================================================================================================");
                        System.out.printf("%10s %20s %30s %20s \n", "Driver","Capacity","Estimated Arrival Time","Reputation");
                        int timedif = Integer.parseInt(b_dtf.format(current))-Integer.parseInt(btime);
                        queueDriver.qArrivalTime=new Queue<>();
                        for(int i = 0 ; i < queueDriver.qName.getSize() ; i++){
                            String[] drvLoc= queueDriver.qLocation.getElement(i).split(" ");

                            String[] cusStartLoc= (queueCustomer.qStartingPoint.getElement(updateCusQPos)).split(" ");
                            String[] cusDesLoc= (queueCustomer.qDestination.getElement(updateCusQPos)).split(" ");



                            int toCusAdd = (int) calculateDistance(Double.parseDouble(drvLoc[0]), Double.parseDouble(drvLoc[1]), Double.parseDouble(cusStartLoc[0]), Double.parseDouble(cusStartLoc[1]));
                            int fromCustoDes = (int) calculateDistance(Double.parseDouble(cusStartLoc[0]), Double.parseDouble(cusStartLoc[1]), Double.parseDouble(cusDesLoc[0]), Double.parseDouble(cusDesLoc[1]));
                            queueDriver.qArrivalTime.enqueue(queueDriver.arrivalTime(dtf.format(current),toCusAdd,fromCustoDes));
                            queueDriver.qPickupTime.enqueue(queueDriver.pickupTime(dtf.format(current),toCusAdd));
//                            String[] driverArvTime=queueDriver.arrivalTime(dtf.format(current),toCusAdd,fromCustoDes).split(":");

                            if (updatedCustomer.getCapacity()<=queueDriver.qCapacity.getElement(i))
                            {
                                String[] driverArvTime = queueDriver.qArrivalTime.getElement(i).split(":");
                                String arriveTimedrv = driverArvTime[0]+driverArvTime[1];
                                if(Integer.parseInt(arriveTimedrv)<=(Integer.parseInt(updatedCustomer.getArrivalTime())+timedif))
                                {
                                    System.out.printf("%10s %20s %30s %20s \n",queueDriver.qName.getElement(i), queueDriver.qCapacity.getElement(i),queueDriver.qArrivalTime.getElement(i),queueDriver.qReputation.getElement(i));

//                                    System.out.printf("%10s %20s %30s %20s \n",queueDriver.qName.getElement(i), queueDriver.qCapacity.getElement(i),"1234",df.format(rating)+"/5.0");

                                }

                            }

                        }
                        System.out.println("===================================================================================================================================");
                        System.out.print("\nEnter the driver name you want to select (Enter "+"exit "+"to go back to homepage):\n>>");
                        String pickDriver = scan.nextLine();
                        if(pickDriver.equalsIgnoreCase("exit")){
                            break;
                        }
                        if(queueDriver.select(pickDriver))
                        {
                            System.out.println(pickDriver+" is on the way to pick you up.");
                            selectDriver=pickDriver;

                        }
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
                        //if(!(g.hasVertex(inputDriverBreak[2]))){
                        //System.out.println("Location unavailable");
                        //break;
                        //}
                        Driver driver = new Driver(inputDriverBreak[0],Integer.parseInt(inputDriverBreak[1]),inputDriverBreak[2]);

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
    public static int calculateDistance(double startingLatitude,double startingLongtitude, double destinationLatitude, double destinationLongtitude){
        // Calculate the distance between each latitude and longtitude
        double distLa = Math.toRadians(destinationLatitude - startingLatitude);
        double distLong = Math.toRadians(destinationLongtitude - startingLongtitude);

        // Implementing Haversine formula
        double temp = Math.pow(Math.sin(distLa/2), 2) + Math.cos(Math.toRadians(startingLatitude)) * Math.cos(Math.toRadians(destinationLatitude))
                * Math.pow(Math.sin(distLong/2), 2);

        double result = 2 * Math.asin(Math.sqrt(temp));

        // Radius of earth in kilometers
        double radius = 6371;

        double timeDistance= result * radius;
        int second = 0;
        for(int i = 0 ; i < timeDistance ; i++){
            second++;
        }
        return second/60;

    }
}

     
    

