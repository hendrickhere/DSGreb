package DSL12;

import java.util.Scanner;

public class MyQueue<E> {

    private static boolean palindrome(String agdsagf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private java.util.LinkedList<E> list = new java.util.LinkedList<>();

    public MyQueue(E[] e) {
        for (E element : e) {
            this.enqueue(element);
        }
    }

    public MyQueue() {
    }

    public void enqueue(E e) {
        list.addLast(e);
    }

    public E dequeue() {
        return list.removeFirst();
    }

    public E getElement(int i) {
        return list.get(i);
    }

    public E peek() {
        return list.getFirst();
    }

    public int getSize() {
        return list.size();
    }

    public boolean contains(E e) {
        for (E element : list) {
            if (element.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        if (list.size() > 0) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Queue: " + list.toString();
    }

    public void remove(E e) {
        list.remove(e);
    }

    public E last() {
        return list.removeLast();
    }

    public void replace(E e) {
        list.removeFirst();
        list.addFirst(e);
    }

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

    public class palindrome {

        public static boolean palindrome(String str) {
            String[] ch = new String[str.length()];
            for (int i = 0; i < str.length(); i++) {
                ch[i] = String.valueOf(str.charAt(i));
            }
            MyQueue<String> palindrome = new MyQueue<>(ch);
            while (palindrome.getSize() > 1) {
                if (!palindrome.dequeue().equals(palindrome.last())) {
                    return false;
                }
            }
            return true;
        }
    }
}
