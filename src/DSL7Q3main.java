
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nevil
 */
public class DSL7Q3main {
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


