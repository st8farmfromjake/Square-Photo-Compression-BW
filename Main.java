// Name: Jake Shumate
//Date: 9/28/2023     
//Email: jake.shumate33823@gmail.com or jshumate@mocs.flsouthern.edu
//Class #:CSC 3280 002
//Project Name: FSCrecurse
//Honor Code: 
//I, Jake Shumate, will practice academic and personal integrity and excellence of character and expect the same from others.” 

//importing the java utils 
import java.util.*;

public class Main {

    //START OF MOCS MATH PROBELM
    //wrapper method for mocs math
    public static long MocsMath(long n) {
        //calls the sum factorial function
        return sumFactorial(n);
    }

    //Recursive Factorial method
    public static long factorial(long n) {
        //base case for a factorial
        if (n == 0) {
            return 1;
        }
        else {
            //return the factorial answer
            return n * factorial(n - 1);
        }
    }

    public static long sumFactorial(long n) {
        if (n == 0) {
            //if the n is 0 then return one (math rule
            return 1;
        }
        else {

            //add every factorial and return the final sum
            return factorial(n) + sumFactorial(n - 1);
        }

    }
    //END OF MOCSMATH FUNCTIONS

    //START OF MOCSSHAPER FUNCTIONS
    public static void mocsShapeWrapper(int start, int max) {
        //make starting string
        String startingString = "";
        for (int i = 0; i < start; i++) {
            //adding the * to the starting string
            startingString += "*";
        }
        //makes the ending string after you make the start so you know where to start from
        String endingString = mocsShapeRecursionStart(startingString, start, max);
        //call the second half of the pyramid method
        mocsShapeRecursionEnd(endingString, start, max);

    }

    //for the starting shape
    public static String mocsShapeRecursionStart(String startingString, int start, int max) {
        if (startingString.length() == max) {
            //if it hits the peak then return the string after printing it
            System.out.println(startingString);
            return startingString;
        }
        else {
            System.out.println(startingString);
            return mocsShapeRecursionStart(startingString + "*", start, max);
        }
    }

    //for the ending shape (going backwards
    public static String mocsShapeRecursionEnd(String endingString, int start, int max) {
        if (endingString.length() == start) {
            //if it hits the start then its done
            System.out.println(endingString);
            return endingString;
        }
        else {
            System.out.println(endingString);
            //return the substring recursively
            return mocsShapeRecursionEnd(endingString.substring(1), start, max);

        }
    }
    //END OF MOCS SHAPE

    //START OF MOCS GAME FUNCTIONS
    //Wrapper function
    public static String mocsGameWrapper(int money) {
        if (mocsGameRecursion(money)) {
            //if the game returns true then it will hit this
            return "Solvable";
        }
        else {
            //if its false then it will hit this
            return "Not Solvable";
        }
    }

    public static boolean mocsGameRecursion(int money) {
        //GOAL: get exactly 42 dollars
        //BASE CASES
        if (money == 42) {
            //If money is $42
            return true;
        }

        //RECURSION CASES
        else {
            //If the amount of money is divisible by 5 it will enter
            if (money >= 42 && (money % 5 == 0 || (money % 3 == 0 || money % 4 == 0) || money % 2 == 0)) {
                //will check if you money-42 hits the base case (if money-42 is 42 then it will 
                boolean solved1 = false;
                boolean solved2 = false;
                boolean solved3 = false;
                if (money % 5 == 0) {
                    //If the amount of money is divisible by 5 do the rule
                    solved1 = mocsGameRecursion(money - 42);
                }
                if (money % 2 == 0) {
                    //If the amount of money is divisible by 2 do the rule
                    solved2 = mocsGameRecursion(money / 2);
                }
                if (money % 3 == 0 || money % 4 == 0) {
                    if (money % 10 == 0 || (money % 100) / 10 == 0) {
                        //If one of the last two numbers is zero its impossible to get it right (will just do money-0)
                        solved3 = false;
                    }
                    else {
                        solved3 = mocsGameRecursion(money - ((money % 10) * ((money % 100) / 10)));
                    }
                }
                //If one of the boolean variable ever gets changed to true it will return true
                return solved1 || solved2 || solved3;
            }
        }
        //If it NEVER FINDS a value that is 42 then its not possible to solve
        //NEEDS RETURN VALUE HERE
        return false;
    }
    //END OF MOCS GAME FUNCTION

    //START OF MOCS COMPRESS FUNCTION
    public static int[][] mocsCompressWrapper(int[][] matrix, int threshhold) {
        return mocsCompressRecursion(matrix, threshhold);
    }

    public static int[][] mocsCompressRecursion(int[][] matrix, int threshhold) {
        //Thinking: must divide the total area in quadricnts
        //How to do that:
        //1a: top right quadrient columns: (matrix.length-matrix.length/2 to matrix[].length)
        //1b: top right quadrient rows: (0 to matrix.length-matrix.length/2)
        //2a: top left quadrient columns: (0 to matrix.length-matrix.length/2)
        //2b: top left quadrient rows: (0 to matrix.length-matrix.length/2)
        //3a: bottom right quadrient columns: (matrix.length-matrix.length/2 to matrix[].length)
        //3b: bottom right quadrient rows: (matrix.length-matrix.length/2 to matrix[].length)
        //4a: bottom left quadrient columns: (0 to matrix.length/2)
        //4b: bottom left quadrient rows: (matrix.length-matrix.length/2 to matrix[].length)

        //backEnd(middle to end) = (matrix[].length)-(matrix.length-matrix.length/2)
        //frontEnd (start to middle) = (matrix.length-matrix.length/2)
        //Problem thinking:
        //sum of TRQuad = 0
        //sum of TLQuad = 0
        //sum of BRQuad = 0
        //sum of BLQuad = 0
        //Within the ifs:
        //average of TRQuad = sumOfTRQuad / BackEnd
        //average of TLQuad = sumOfTLQuad / BackEnd
        //average of BRQuad = sumOfBRQuad / BackEnd
        //average of BLQuad = sumOfBLQuad / BackEnd
        //Possible base case:
        //FOUR BASE CASES?
        //if averageOfTRQuad is >= threshhold
        //if averageOfTLQuad is >= threshhold
        //if averageOfBRQuad is >= threshhold
        //if averageOfBLQuad is >= threshhold
        //START OF CODE FINALLY
        //Break it up into quadrents first
        if (matrix.length == 1) {
            //if the matrix is a 1x1 then return that matrix, cannot be compressed anymore
            return matrix;
        }
        else {

            //initializing all the sums, the halfway point, and the total area
            int sumOfAll1 = 0;
            int sumOfAll0 = 0;
            int matrixArea = matrix.length * matrix.length;
            int middle = matrix.length / 2;
            //counting all nums in matrix
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    //counting all the 1s and 0s
                    if (matrix[i][j] == 1) {
                        sumOfAll1++;
                    }
                    else {
                        sumOfAll0++;
                    }
                }
            }

            //calculate the average
            double averageOf1WholeBoard = ((double) ((sumOfAll1 * 100 / matrixArea)));
            double averageOf0WholeBoard = ((double) ((sumOfAll0 * 100 / matrixArea)));

            //see if the board/quad/matrix is majority 1
            if (averageOf1WholeBoard >= threshhold) {
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix.length; j++) {
                        //assign the whole matrix 1
                        matrix[i][j] = 1;
                    }
                }
                //return the whole matrix
                return matrix;
            }

            //check if the whole matrix meets 0 threshhold
            if (averageOf0WholeBoard >= threshhold) {
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix.length; j++) {
                        //assign the whole matrix 0
                        matrix[i][j] = 0;
                    }
                }
                //return the whole matrix
                return matrix;
            }
            //if fit doesnt meet threshhold
            
            //making new quadraints
            int[][] TLQuad = new int[middle][middle];
            int[][] TRQuad = new int[middle][middle];
            int[][] BLQuad = new int[middle][middle];
            int[][] BRQuad = new int[middle][middle];

            //for navigating through the quads
            int row = 0;
            int col = 0;
            //top left
            for (int i = 0; i < middle; i++) {
                for (int j = 0; j < middle; j++) {
                    TLQuad[i][j] = matrix[i][j];

                }

            }
            //recursivly call the quad and compress
            TLQuad = mocsCompressRecursion(TLQuad, threshhold);
            row = 0;
            col = 0;
            //top right
            for (int i = 0; i < middle; i++) {
                for (int j = middle; j < matrix.length; j++) {
                    TRQuad[row][col] = matrix[i][j];
                    col++;
                }
                row++;
                col = 0;
            }
            row = 0;
            col = 0;
            //recursivly call the quad and compress
            TRQuad = mocsCompressRecursion(TRQuad, threshhold);
            //bottom left
            for (int i = middle; i < matrix.length; i++) {
                for (int j = 0; j < middle; j++) {
                    BLQuad[row][col] = matrix[i][j];
                    col++;
                }
                row++;
                col = 0;
            }
            row = 0;
            col = 0;
            //recursivly call the quad and compress
            BLQuad = mocsCompressRecursion(BLQuad, threshhold);

            //bottom right
            for (int i = middle; i < matrix.length; i++) {
                for (int j = middle; j < matrix.length; j++) {
                    BRQuad[row][col] = matrix[i][j];
                    col++;
                }
                col = 0;
                row++;
            }
            row = 0;
            col = 0;
            //recursivly call the quad and compress
            BRQuad = mocsCompressRecursion(BRQuad, threshhold);

            //making the new matrix to return
            int[][] newMatrix = new int[matrix.length][matrix.length];
            for (int i = 0; i < middle; i++) {
                for (int j = 0; j < middle; j++) {
                    //assigning all the values to the new matrix
                    newMatrix[i][j] = TLQuad[i][j];
                    newMatrix[i][j + middle] = TRQuad[i][j];
                    newMatrix[i + middle][j] = BLQuad[i][j];
                    newMatrix[i + middle][j + middle] = BRQuad[i][j];
                }
            }
            //return the compressed matrix
            return newMatrix;

        }

    }

    //END OF MOCS COMPRESS FUNCTION
    public static void main(String[] args) {
        int numCommands;
        String[] command;
        Scanner in = new Scanner(System.in);

        // Scan the # of commands from the user
        numCommands = Integer.parseInt(in.nextLine());

        // Now do a for loop over the number of commands
        for (int i = 0; i < numCommands; i++) {
            // Scan the next command
            command = in.nextLine().split(" ");

            if (command[0].equals("MocsMath")) {
                // We call the WRAPPER method MocsMath()
                System.out.print("MocsMath: ");
                System.out.println(MocsMath(Long.parseLong(command[1])));
                System.out.println("");

            }

            else if (command[0].equals("MocsShape")) {
                // We call the WRAPPER method MocsShape()
                System.out.println("MocsShape: ");
                mocsShapeWrapper(Integer.parseInt(command[1]), Integer.parseInt(command[2]));

            }
            else if (command[0].equals("MocsGame")) {
                // We call the WRAPPER method MocsGame()
                System.out.print("MocsGame:  ");
                System.out.println(mocsGameWrapper(Integer.parseInt(command[1])));
                System.out.println("");

            }
            else if (command[0].equals("MocsCompress")) {
                // We call the WRAPPER method MocsCompress()
                System.out.println("MocsCompress:");
                //first parameter is the size of the arrays
                //and the second is the threshhold (percentage) if number is 75 then it means 75%

                //making 2d array (the matrix will always be square (8x8) (4x4) (2x2) (25x25)
                int size = Integer.parseInt(command[1]);
                int threshhold = Integer.parseInt(command[2]);
                int[][] matrix = new int[size][size];
                for (int j = 0; j < size; j++) {
                    String[] line = in.nextLine().split("", 10000);
                    for (int k = 0; k < size; k++) {
                        matrix[j][k] = Integer.parseInt(line[k]);
                    }
                }
                //Getting compressed image
                int[][] answer = mocsCompressWrapper(matrix, threshhold);

                //Printing Answer
                for (int j = 0; j < answer.length; j++) {
                    System.out.println("");
                    for (int k = 0; k < answer.length; k++) {
                        System.out.print("" + answer[j][k]);
                    }
                }
                System.out.println("");
            }
            // Error
            else {
                System.out.println("Should not be seeing this (error in main)");
            }
        }
    }

}
