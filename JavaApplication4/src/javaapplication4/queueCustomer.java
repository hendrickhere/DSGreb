/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication4;

import java.util.Formatter;

/**
 *
 * @author hongjun
 */
public class queueCustomer {
    Queue<String> qName = new Queue<>();
    Queue<String> qStatus = new Queue<>();
    Queue<String> qTime = new Queue<>();
    Queue<Integer> qCapacity = new Queue<>();
    Queue<String> qStartingPoint = new Queue<>();
    Queue<String> qDestination = new Queue<>();
    String[] status = {"pending","waiting","picked up","reached"};
    
    public void add(String[] a){
        
        qName.enqueue(a[0]);
        qTime.enqueue(a[1]);
       
        qCapacity.enqueue(Integer.parseInt(a[2]));
        qStartingPoint.enqueue(a[3]);
        qDestination.enqueue(a[4]);
        addAdditional();
        
    }
    
    public void addAdditional(){
         qStatus.enqueue(status[0]);
    }
    
    public void changeStatus(String customerName, String updatedStatus){
        if(qName.contains(customerName)){
            int index = qName.getIndex(customerName);
            qStatus.set(index, updatedStatus);
        }
    }
    
    
    public void display(){
        for(int i = 0 ; i < qName.getSize() ; i++){
            System.out.printf("%8s %18s %15s %25d %20s %20s \n",qName.getElement(i), qStatus.getElement(i),qTime.getElement(i), qCapacity.getElement(i), qStartingPoint.getElement(i), qDestination.getElement(i));
            
        }
        
    }
    
    public void update(String name, String aspect,String newUpdate){
        for(int i = 0 ; i < qName.getSize() ; i++){
            if(qName.getElement(i).equalsIgnoreCase(name)){
                if(aspect.equalsIgnoreCase("n")){
                    qName.set(i, newUpdate);
                }
                else if(aspect.equalsIgnoreCase("e")){
                    qTime.set(i, newUpdate);
                }
                else if(aspect.equalsIgnoreCase("c")){
                    qCapacity.set(i, Integer.parseInt(newUpdate));
                }
                else if(aspect.equalsIgnoreCase("s")){
                    qStartingPoint.set(i, newUpdate);
                }
                else if(aspect.equalsIgnoreCase("d")){
                    qDestination.set(i, newUpdate);
                }
                else{                  
                }
                    
            }
        }
    }
    
    
    
    
    
    
    
}
