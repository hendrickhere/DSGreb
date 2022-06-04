/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication4;

/**
 *
 * @author hongjun
 */
public class jvosjvs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(calculateDistance(3.0721, 101.6063, 3.0641, 101.6161));
        System.out.println(calculateDistance(3.0736, 101.5874, 3.0721, 101.6063));
        System.out.println(calculateDistance(3.0327, 101.6188, 3.0641 ,101.6161));
        double result = calculateDistance(3.0721, 101.6063, 3.0641, 101.6161);
        b(result);
        
        
    }
     public static double calculateDistance(double startingLatitude,double startingLongtitude, double destinationLatitude, double destinationLongtitude){
        // Calculate the distance between each latitude and longtitude
        double distLa = Math.toRadians(destinationLatitude - startingLatitude);
        double distLong = Math.toRadians(destinationLongtitude - startingLongtitude);
        
        // Implementing Haversine formula
        double temp = Math.pow(Math.sin(distLa/2), 2) + Math.cos(Math.toRadians(startingLatitude)) * Math.cos(Math.toRadians(destinationLatitude))
                      * Math.pow(Math.sin(distLong/2), 2);
        
        double result = 2 * Math.asin(Math.sqrt(temp));
        
        // Radius of earth in kilometers
        double radius = 6371;
        
        return result * radius;
        
        
    }
     
     public static void b(double a){
         int second = 0;
         for(int i = 0 ; i < a ; i++){
             second++;
         }
         System.out.println(second);
     }
    
}
