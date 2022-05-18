/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nevil
 */
public class DSL3 {
    // Share class
public class Share {
    private int unit;
    private double price;
    
    public Share(int unit, double price){
        this.unit = unit;
        this.price = price;
    }
    
    public double getSharePrice(){
        return price;
    }
    
    public int getUnit(){
        return unit;
    }
    
     public double sellUnit(int unit, double sellPrice){
     this.unit -= unit;
     return (sellPrice - price) * unit;
    }
    
    @Override
    public String toString(){
        return "[" + Integer.toString(unit) +", $"+ Double.toString(price) + " ]";
    }
}

// SharesQueue class
public class SharesQueue {
    private MyQueue<Share> q = new MyQueue<>();
    private double revenue = 0;
 
    public void buy(int unit, double price) {
        q.enqueue(new Share(unit, price));
    }
        if (unit == 0) return;
        if (q.isEmpty()) {
            System.out.println("No shares to sell!");
        } else {
// queue is not empty 
            Share temp = q.peek().
            int shareUnit = temp.getUnit();
            
// first share’s unit >= sell unit
            if (shareUnit >= unit){
                revenue += temp.sellUnit(unit, sellPrice);
                
// if all unit is sold
                if (temp.getUnit() == 0){
                    q.dequeue();
                }
            }else{
// first share’s unit < sell unit
                revenue += temp.sellUnit(shareUnit, sellPrice);
                q.dequeue();
// recursive call to the next bought share
                sell(unit - shareUnit, sellPrice);
            }
 
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
public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^(Buy|Sell) (\\d+) shares at \\$(\\d+) each$");
        SharesQueue q = new SharesQueue();
        
        while (true){
            
            System.out.println("Enter your query (In format 'Buy / Sell x shares at $y each'): ");
            String query = sc.nextLine();
            Matcher matcher = pattern.matcher(query);
            
            if (!matcher.find()) {
                System.out.println("Final Capital Gain / Loss: " + q.getRevenue());
                break;
            }
            
            int unit = Integer.valueOf(matcher.group(2));
            double price = Double.valueOf(matcher.group(3));
            
            if (matcher.group(1).equals("Buy")){
                System.out.println("Buying now...");
                q.buy(unit, price);
            }
            else{
                System.out.println("Selling the shares now...");
                q.sell(unit, price);
                System.out.println("Total Capital Gain/ Loss: " + q.getRevenue());
            }
            
            System.out.println("Queue [Share, price]: " + q);
        }   
    }
}

    
}
