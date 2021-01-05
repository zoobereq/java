/** Minutes.java - add your solutiuon to program 2 of homework 1 here.
 * 
 */
import java.util.Scanner;

public class Minutes {
    
    public static final void main(String[] args) {
    
        System.out.println("This program converts the number of hours, days, weeks, and years (ignoring lap years), into minutes. Complete the following steps for a successful conversion.");
        
        Scanner s = new Scanner(System.in);
        System.out.println("Please input the number of hours using integers: ");
            int hours = s.nextInt();
        System.out.println("Please input the number of days using integers: ");
            int days = s.nextInt();
        System.out.println("Please input the number of weeks using integers: ");
            int weeks = s.nextInt();
        System.out.println("Please input the number of years using integers: ");
            int years = s.nextInt();
        
        int minutes = ((hours * 60) + (days * 1440) + (weeks * 10080) + (years * 525600));
        System.out.println("There are approximately " + minutes + " minutes in " + hours + " hours " + days + " days " + weeks + " weeks and " + years + " years.");    
        
    }
    
    
}