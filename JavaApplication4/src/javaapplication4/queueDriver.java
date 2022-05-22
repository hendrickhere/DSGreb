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
public class queueDriver {
   
    Queue<String> qName = new Queue<>();
    //Queue<Integer> qId = new Queue<>();
    Queue<String> qStatus = new Queue<>();
    Queue<Integer> qCapacity = new Queue<>();
    Queue<String> qLocation = new Queue<>();
    
    int sizeId = 0;
    
     public void add(String[] a){
        
        qName.enqueue(a[0]);  
        //qStatus.enqueue();
        qCapacity.enqueue(Integer.parseInt(a[1]));
        qLocation.enqueue(a[2] + " "+ a[3]);
        //qId.enqueue(++sizeId);
        
    }
     
    
    public void display(){
        
        
        
        for(int i = 0 ; i < qName.getSize() ; i++){
           System.out.printf("%8s %18s %15s %25s  %15s \n",qName.getElement(i),"status ", qCapacity.getElement(i), qLocation.getElement(i),"Customer");
            
        }
        
        
    }
    
    public void delete(String a){
        int size = qName.getSize();
        for(int i = 0 ; i < size ; i++){
            if(a.equalsIgnoreCase(qName.getElement(i))){
                
                qName.remove(i);
                //qId.remove(i);
                //qStatus.remove(i);
                qCapacity.remove(i);
                qLocation.remove(i);
                System.out.println("Driver "+ a +" has been removed");
                
                
                
            }
            else{
                                
            }
        }
    }
    
}
