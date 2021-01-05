/** Change.java - add your solutiuon to program 3 of homework 1 here.
 * 
 */
import java.util.Scanner;

public class Change {
    
    public static final void main(String[] args) {
        System.out.println("This program helps a chashier issue correct change.");
        
        float due, received, change;
        
        Scanner s = new Scanner(System.in);
        System.out.println("Please input the amount due: ");
            due = s.nextFloat();
        System.out.println("Please input the amount received from the customer: ");
            received = s.nextFloat();
        
        if (received < due) {
            System.out.println("Insufficient funds to make the purchase.");
        }
        
        if (received == due) {
            System.out.println("No change");
        }
        
        else if (received > due) {
                    
            change = (received - due) * 100; // converts to pennies
            
            int dollars = (int) change / 100;
            change = change % 100;
                
            int quarters = (int) change / 25;
            change = change % 25;
            
            int dimes = (int) change / 10;
            change = change % 10;
            
            int nickles = (int) change / 5;
            change = change % 5;
            
            int pennies = (int) change;
        
            System.out.println("Distribute: " + dollars + " dollars, " + quarters + " quarters, " + dimes + " dimes, " + nickles + " nickles, and " + pennies + " pennies." );

        }

    }

}