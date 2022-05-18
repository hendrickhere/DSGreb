
import DSL12.MyQueue;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author nevil
 */
public class SharesQueue {

    private MyQueue<Share> q = new MyQueue<>();
    private double revenue = 0;

    public void buy(int unit, double price) {
        q.enqueue(new Share(unit, price));
    }
    if (unit

    == 0) 
    return;
        if (q.isEmpty () 
        ) {
            System.out.println("No shares to sell!");
    }

    
        else {
// queue is not empty 
            Share temp = q.peek().
        int shareUnit = temp.getUnit();

// first share’s unit >= sell unit
        if (shareUnit >= unit) {
            revenue += temp.sellUnit(unit, sellPrice);

// if all unit is sold
            if (temp.getUnit() == 0) {
                q.dequeue();
            }
        } else {
// first share’s unit < sell unit
            revenue += temp.sellUnit(shareUnit, sellPrice);
            q.dequeue();
// recursive call to the next bought share
            sell(unit - shareUnit, sellPrice);
        }

    }

    String getRevenue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void sell(int unit, double price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

public double getRevenue(){
        return revenue;
    }
    
    @Override
public String toString(){
        return q.toString();
    }
}

// Main method

