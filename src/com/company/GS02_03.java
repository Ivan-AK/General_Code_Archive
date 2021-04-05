
/* All notes are made going through the loop for the first time.*/

package com.company;

public class GS02_03 {

    public static final int Stairs = 20; //The number of steps. A lot of things are based on this. However, it may be changed at will

    public static String drawStep() { //Our function that will draw the stairs when called
        String step = "";
        for(int i = 0; i < GS02_03.Stairs; i++) {
            int initial_space = (5 * (GS02_03.Stairs - i - 1)); //Calculation of initial spacing
            for(int s = 0; s <= initial_space; s++){ //Places the initial spaces according to how many steps there should be
                step = step + " ";
            }
            step +=   " o  ******"; //Line 1
            for(int c = 1; c <= i; c++) { //Having c start at 1 will stop spacing being placed on the top line
                for (int b = 0; b < 5; b++) {
                    step = step + " "; //This loop will place the units of spacing I'm using (5 spaces)
                }
            }
            step += "*\n"; //The back wall
            for(int s = 0; s <= initial_space; s++){ //Initial space of line 2
                step = step + " ";
            }
            step +=  "/|\\ *"; //Line 2
            for(int c = 0; c <= i; c++) {
                for (int b = 0; b < 5; b++) {
                    step = step + " "; //Unit of spacing for line 2
                }
            }
            step += "*\n"; //back wall of line 2
            for(int s = 0; s <= initial_space; s++){
                step = step + " ";
            }
            step += "/ \\ *"; //line 3
            for(int c = 0; c <= i; c++) {
                for (int b = 0; b < 5; b++) {
                    step = step + " "; //Unit of spacing for line 3
                }
            }
            step = step + "*\n"; //back wall
        }
        for(int f = 0; f <= 6 + (5 * GS02_03.Stairs); f++) { //this loop builds the floor
            step = step + "*";
        }

        /* The loop, defined by the integer i, will repeat this method of building steps, adjusting for the difference
        *  in spacing as the steps go down. The floor is built last and built only ONCE, being the last line of the ASCII.*/

        return(step); //returns the complete set of stairs
    }

    public static void main(String[] args) {
        System.out.print(drawStep()); //This prints out the completed set of stairs returned from the drawStep method
    }
}