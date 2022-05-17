/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DSL12;

import static DSL12.MyQueue.palindrome.palindrome;

/**
 *
 * @author nevil
 */
public class DSL7 {

    public static void main(String[] args) {
        //Have an initialize queue items consists of Durian and Blueberry in a fruitQ
        String[] fruit = {"Durian", "Blueberry"};
        MyQueue<String> fruitQ = new MyQueue<>(fruit);

        //Then add new items in the following order: Apple, Orange, Grapes, Cherry. 
        fruitQ.enqueue("Apple");
        fruitQ.enqueue("Orange");
        fruitQ.enqueue("Grapes");
        fruitQ.enqueue("Cherry");

        //Display the queue.
        System.out.println(fruitQ.toString());

        //Show the top item.
        System.out.println("Top item: " + fruitQ.peek());

        //Get the queue size.
        System.out.println("Queue size: " + fruitQ.getSize());

        //Delete Durian
        fruitQ.remove("Durian");

        //Get item in index position of 2
        System.out.println("Item in index position of 2: " + fruitQ.getElement(2));

        //Check whether the queue consists of Cherry
        System.out.println("Queue consists of Cherry: " + fruitQ.contains("Cherry"));

        //Check whether the queue consists of Durian
        System.out.println("Queue consists of Durian: " + fruitQ.contains("Durian"));

        //Display the queue using the isEmpty() condition.
        System.out.print("Queue: ");
        while (!fruitQ.isEmpty()) {
            System.out.print(fruitQ.dequeue() + " ");
        }

        System.out.println("");

        //Question 2
        System.out.println();
        System.out.println(palindrome("agdsagf"));
        System.out.println(palindrome("abccba"));

    }

}
