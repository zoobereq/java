/** F2C.java - add your solutiuon to program 1 of homework 1 here.
 * 
 */
import java.util.Scanner;

public class F2C {
    
    public static final void main(String[] args) {
            Scanner s = new Scanner(System.in);
        
            System.out.println("Please input the temperature in Farenheit to be converted to Celcius: ");
            int fahrenheit = s.nextInt();
        
            int celcius = (( 5 * (fahrenheit - 32)) / 9);
            System.out.println(fahrenheit + " degrees Farenheit is " + celcius + " degrees Celcius.");     
    }    
}