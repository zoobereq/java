public class Zipcode {

  private int numbers; // declare the incance variable numbers
  private String bars; // declare the incance variable bars

    // Construct an instance of the Zipcode class that takes in a sequence of integers and converts them to a barcode string
    public Zipcode(int zip) {
        bars = convert2Digits(zip); // use convert2Digits to convert the zipcode integer into a string of digits to be stored in bars
        numbers = zip;
    }

    // Construct an instance of the Zipcode class that takes a barcode string and converts it to a sequence of integers
    public Zipcode(String barcode) {
        numbers = convert2Zip(barcode); // use convert2Zip to convert a barcode string into numbers
        bars = barcode;
    }

/* From zip to barcode */

    // a method that generates the check digit based on the zip code
    public int digitCheck(int zip) {
        // declare your digit variables - 5 for a 5-digit zip code
        int digit1;
        int digit2;
        int digit3;
        int digit4;
        int digit5;
        int sum;
        int check;

        // parse the zip number into digits
        digit1 = (zip / 10000); // first digit
        digit2 = (zip / 1000) - (digit1 * 10); // second digit
        digit3 = (zip / 100) - ((digit1 * 100) + (digit2 * 10)); // third digit
        digit4 = (zip / 10) - ((digit1 * 1000) + (digit2 * 100) + (digit3 * 10)); // fourth digit
        digit5 = (zip / 1) - ((digit1 * 10000) + (digit2 * 1000) + (digit3 * 100) + (digit4 * 10)); // fifth digit
        sum = digit1 + digit2 + digit3 + digit4 + digit5;
        check = 10 - (sum % 10);
        return check;
    }


    // a method that converts the zip code integer to a string of digits
    public String convert2Digits(int zip) {
        int zipCode = zip;
        int dividend = 10000; // start with the first digit of the zip code
        int currentDigit = 0; // set the index in the loop counter to the first element
        String theBarcode = "";

        for(int i = 0; i < 5; i++) {// for loop iterating over the 5-digit zip code
         currentDigit = zipCode / dividend;
         theBarcode = theBarcode + convert2Barcode(currentDigit);
         zipCode = zipCode % dividend; // move to the next digit
         dividend = dividend / 10; // update dividend to keep zipCode moving
        }

        theBarcode = theBarcode + convert2Barcode(digitCheck(zip)); // add the check digit to the barcode
        return "|" + theBarcode + "|"; // include bars before and after the barcode
    }


    public String convert2Barcode(int digit) { // convert each digit to barcode
        String inBars = "";

        if(digit == 0) {
          inBars = "||:::";
        }
        if(digit == 1) {
          inBars = ":::||";
        }
        if(digit == 2) {
          inBars = "::|:|";
        }
        if(digit == 3) {
          inBars = "::||:";
        }
        if(digit == 4) {
          inBars = ":|::|";
        }
        if(digit == 5) {
          inBars = ":|:|:";
        }
        if(digit == 6) {
          inBars = ":||::";
        }
        if(digit == 7) {
          inBars = "|:::|";
        }
        if(digit == 8) {
          inBars = "|::|:";
        }
        if(digit == 9) {
          inBars = "|:|::";
        }

        return inBars;
    }

    public String getBarcode() {
        return bars; // the varialbe 'bars' stores is the resulting barcode
    }


/* From barcode to zip */

    public int convertBars(String barcode) { // convert from barcode string to digits

      int zipDigit = -1; // declare in check against negative zipcode digits

      if(barcode.equals("||:::")) { // the .equals to compares string content
          zipDigit = 0;
      }
      if(barcode.equals(":::||")) {
          zipDigit = 1;
      }
      if(barcode.equals("::|:|")) {
          zipDigit = 2;
      }
      if(barcode.equals("::||:")) {
          zipDigit = 3;
      }
      if(barcode.equals(":|::|")) {
          zipDigit = 4;
      }
      if(barcode.equals(":|:|:")) {
          zipDigit = 5;
      }
      if(barcode.equals(":||::")) {
          zipDigit = 6;
      }
      if(barcode.equals("|:::|")) {
          zipDigit = 7;
      }
      if(barcode.equals("|::|:")) {
          zipDigit = 8;
      }
      if(barcode.equals("|:|::")) {
          zipDigit = 9;
      }

      return zipDigit;
    }


    public int convert2Zip(String barcode) {//convert from a barcode string to a zipCode int

      // declare method variables
     int digitOne;
     int digitTwo;
     int digitThree;
     int digitFour;
     int digitFive;
     int digitSum;

     String one = barcode.substring(1,6); // this will take the first five bars of the barcode. The actual first bar is not part of the zipcode
          digitOne = convertBars(one); // get first digit of the zipcode
     String two = barcode.substring(6,11); // move to the next five bars of the barcode
          digitTwo = convertBars(two); // get the second digit of the zipcode
     String three = barcode.substring(11,16); // move to the next five bars of the barcode
          digitThree = convertBars(three); // get the third digit of the zipcode
     String four = barcode.substring(16,21); // move to next five bars of the the barcode
          digitFour = convertBars(four); // get the fourth digit of the zipcode
     String five = barcode.substring(21,26); // move to last five bars of the barcode.  The last bar is not part of the zipcode.
          digitFive = convertBars(five); // get the fifth digit of the zipcode
     int digitSum1 = (digitOne * 10000) + (digitTwo * 1000) + (digitThree * 100) + (digitFour * 10) + (digitFive * 1); // sum digits to obtain the zipcode

     return digitSum1;
   }


   public int getZIPcode() {
     return numbers;
   }

}
