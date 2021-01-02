import java.util.Arrays;

public class TransitCalculator {

        // instance variables
        public int numDays;
        public int numRides;

        // class constructor
        public TransitCalculator(int days, int rides) {
            numDays = days;
            numRides = rides;
        }

        // NYC fare options
        public String[] options = {"Pay-per-ride", "7-Day Unlimited", "30-Day Unlimited"};
        public double[] prices = {2.75, 33.00, 127.00};

        // 7-Day Ticket Method
        public double unlimited7Price() {

            double numWeeks;
            double totalCost;
            double ridePrice;


            numWeeks = Math.ceil(numDays / 7);
            totalCost = numWeeks * prices[1];
            ridePrice = totalCost / numRides;

            return ridePrice;
        }

        public double[] getRidePrices() {

            double fare1;
            double fare2;
            double fare3;

            fare1 = prices[0];
            fare2 = unlimited7Price();
            fare3 = prices[2] / numRides;

            double ridePrice[] = {fare1, fare2, fare2};
            return ridePrice;
        }

        // gets the index of the lowest fare in the fares array
        public String getBestFare() {
            double[] bestPrice = getRidePrices();
            int bestPriceIndex = 0;

            for (int i = 0; i < bestPrice.length; i++) {
                if (bestPrice[i] < bestPrice[bestPriceIndex]) {
                    bestPriceIndex = i;
                }
            }
        return "You should get the " + options[bestPriceIndex] + " ticket at " + Math.round(bestPrice[bestPriceIndex] * 100.0) / 100.0 + " per ride.";
        }


        public static void main(String[] args) {
            int tripDays = 16;
            int tripRides = 28;

            TransitCalculator myTrip = new TransitCalculator(tripDays, tripRides);
            System.out.println(myTrip.getBestFare());
        }

}