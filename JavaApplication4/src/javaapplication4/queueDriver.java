/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication4;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author hongjun
 */
public class queueDriver {
   
    Queue<String> qName = new Queue<>();
    //Queue<Integer> qId = new Queue<>();
    Queue<String> qStatus = new Queue<>();
    Queue<Integer> qCapacity = new Queue<>();
    Queue<String> qLocation = new Queue<>();
    Queue<String> qArrivalTime = new Queue<>();
    Queue<String> qPickupTime = new Queue<>();
    Queue<Double> qReputation = new Queue<>();
    Queue<String> qCustomer = new Queue<>();
    String[] status = {"not available","available"};
    
    
    
    public void add(String[] a){
        
        qName.enqueue(a[0]);  
        
        qCapacity.enqueue(Integer.parseInt(a[1]));
        qLocation.enqueue(a[2]);
        //qId.enqueue(++sizeId);
        //qReputation.enqueue((double)Math.random()*5);
        addAdditional();
        qCustomer.enqueue("-");
        
    }
    
    
    
    public void addAdditional(){
      
        
        qStatus.enqueue(status[1]);
        double rep = (double)Math.random()*5;
        qReputation.enqueue(rep);
        
    }
    
    
    
    
    public String arrivalTime(String time, int weightDriverSource, int weightSourceDestination){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime lt = LocalTime.parse(time);
        
        int minute = 0;
        for(int i = 0 ; i < weightDriverSource ; i++){
            minute++;
        }
        for(int i = 0 ; i< weightSourceDestination ; i++){
            minute++;
        }
        
        return formatter.format(lt.plusMinutes(minute));
        
        
    }
    
    public String pickupTime(String time, int weightDriverSource){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime lt = LocalTime.parse(time);
        
        int minute = 0;
        for(int i = 0 ; i < weightDriverSource ; i++){
            minute++;
        }
        
        return formatter.format(lt.plusMinutes(minute));
        
    }
    
    
    
    public void customer(String customerName, int index){
        qCustomer.set(index, customerName);
        qStatus.set(index, status[0]);
    }
     
    
    public void display(){
        
          
        for(int i = 0 ; i < qName.getSize() ; i++){
           System.out.printf("%9s %20s %13d %18s  %18s \n",qName.getElement(i),qStatus.getElement(i),qCapacity.getElement(i), qLocation.getElement(i),qCustomer.getElement(i));
            
        } 
        
    }
    
    
    public void displayDriverAva(){
     
        for(int i = 0 ; i < qName.getSize() ; i++){
           if(qStatus.getElement(i).equalsIgnoreCase("not available")){
               continue;
           }
           System.out.printf("%8s %15s %20s %25.1f  %s  \n",qName.getElement(i),qCapacity.getElement(i), qArrivalTime.getElement(i),qReputation.getElement(i),"/5.0");
            
        }
         //for(int i = 0 ; i < qName.getSize() ; i++){
           //System.out.printf("%8s %18s %15d %25s  %15s \n",qName.getElement(i),"status ",qCapacity.getElement(i), qLocation.getElement(i),"Customer");
            
        //} 
        
    }
    
    public void delete(String a){
        //int size = qName.getSize();
        for(int i = 0 ; i < qName.getSize() ; i++){
            if(a.equalsIgnoreCase(qName.getElement(i))){
         
                qName.remove(i);
                //qId.remove(i);
                qStatus.remove(i);
                qCapacity.remove(i);
                qLocation.remove(i);
                qCustomer.remove(i);         
                qReputation.remove(i);
                                
                System.out.println("Driver "+ a +" has been removed");        
            }
            
        }
    }
    
}
