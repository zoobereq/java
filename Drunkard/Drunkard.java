import java.util.Random;
import java.lang.Math;

public class Drunkard {

    //class instance variables
    private int beginx; //initial avenue location that won't be incremented
    private int beginy; //initial street location that won't be incremented
    private int currentx; //curret avenue location
    private int currenty; //current street location

    //class object constructor
    public Drunkard(int avenue, int street) {
        beginx = avenue;
        beginy = street;
        currentx = avenue;
        currenty = street;
    }

    //class methods - mutators

    //moves the drunkard to the next randomly chosen adjacent intersection
    public void step() {
        Random random_number = new Random(); //initializes a random_number object of the Random class
        int random_step = random_number.nextInt(4); //randomly generates a number between 0 and 3 and stores it in random_step

        switch(random_step) {

            case 1:
                currentx = currentx + 1; //the drunkard goes north
                break;
            case 2:
                currenty = currenty + 1; //the drunkard goes east
                break;
            case 3:
                currentx = currentx - 1; //the drunkard goes south
                break;
            case 4:
                currenty = currenty - 1; //the drunkard goes west
                break;

        }


        /*
        //Same as above but with chained if-statements
        //clockwise

        if (random_step == 0) {
            currentx = currentx + 1; //the drunkard goes north
        }

        if (random_step == 1) {
            currenty = currenty + 1; //the drunkard goes east
        }

        if (random_step == 2) {
            currentx = currentx - 1; //the drunkard goes south
        }

        if (random_step == 3) {
            currenty = currenty - 1; //the drunkard goes west
        }
        */

    }

    //moves the drunkard 'steps' intersections from his current location
    //we set the counter to 1, incrementing it by 1 until it is equal to the number of steps.
    //Each incrementation runs the step() method.
    public void fastForward(int steps) {
        for (int i = 1; i <= steps; i = i + 1) {
            step();
        }
    }


    //class methods - accessors

    //returns a String indicating the drunkard’s current location
    public String getLocation() {
        String current_location = "The drunkard is at " + currentx + " avenue, and " + currenty + " street.";
        return current_location;
    }

    //reports the drunkard's distance in blocks from where he started calculated using the Manhattan distance metric
    public int howFar() {
        int total_distance = (Math.abs(currentx - beginx)) + (Math.abs(currenty - beginy));
        return total_distance;

    }
}
