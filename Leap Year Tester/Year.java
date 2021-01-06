/*
*
* @author your name here
* @date 2/19/2018
*
* This class represents a calendar year.
*
* It contains a method that determines if
* the year is a leap year.
*
*/


public class Year{

   //instance variables
   private int year;
   private boolean leap;

   //class object constructor
   public Year(int y) {
       year = y;
   }

   //method checking for leap year
   public boolean isLeapYear() {
       if (year < 1582) {
           leap = false;
       }
       else if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
            leap = true;
       }
       else {
           leap = false;
       }
       return leap;
   }
}
