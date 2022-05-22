/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication4;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author hongjun
 */
public class Queue<E> {
    final private LinkedList list = new LinkedList();
    E[] e;

    public Queue(E[] e) {
        this.e = e;
        list.addAll(Arrays.asList(e));        
    }
    
    public Queue(){
    }
    
    public void enqueue(E e){
        list.addLast(e);
    }
    
    public E dequeue(){
       E result = (E)list.removeFirst();
       return result;
    }
    
    public E getElement(int i){
        return (E)list.get(i);
    }
    
    public E peek(){
        return (E)list.getFirst();
    }
    
    public int getSize(){
        return list.size();
    }
    
    public boolean contains(E e){
        return list.contains(e);
    }
    
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    public void set(int i, E e){
        list.set(i, e);
    }
    
    public void remove(int i){
        list.remove(i);
    }
    
    
    @Override
    public String toString(){
        return "list : " + list.toString();
    }
}
