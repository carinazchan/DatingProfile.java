/*
Carina Zelda Chan
2367721
carchan@chapman.edu
CPSC-231-04
Mastery Project 1: Recursion and Intro to Classes - Harmonic
*/

/*
OVERVIEW:
Harmonic.java calculates the harmonic number in two differerent ways
(iterative & recursive) given the user input.
*/

//NOTES
/*
D+I = Declare+Initialize
*/


//IMPORT
import java.util.Scanner;

/*
Harmonic class

description:
given user input, calculates the harmonic number in two ways (iterative, recursive)
*/
public class Harmonic {

  /*
  calcIterativeHarmonic method

  return, description - type:
  harmonicNum, calculated harmonic number given int n - double

  parameter, description - type:
  n, user input number to be calculated - int
  */
  public static double calcIterativeHarmonic(int n) {
    int i;
    double harmonicNum = 0.0; //D+I harmonicNum
    //For-loop: calculating harmonicNum
    for (i=1; i<n+1; i++) {
      harmonicNum += 1.0/i;
      //System.out.println(harmonicNum); - checking if for-loop running properly
    }

    return harmonicNum;
  }

  /*
  calcRecursiveHarmonic method

  return, description - type:
  harmonicNumR, calculated harmonic number given int n - double

  parameter, description - type:
  n, user input number to be calculated - int
  */
  public static double calcRecursiveHarmonic(int n) {
    double harmonicNumR = 0.0; //D+I harmonicNumR
    //If n has not reached 0, calculate harmonicNumR
    if (n>0) {
      harmonicNumR += (1.0/n + calcRecursiveHarmonic(n-1));
    }

    return harmonicNumR;
  }


  //main method START
  public static void main (String [] args) {

    Scanner scnr = new Scanner(System.in); //Declare scnr

    System.out.print("Please input an integer: "); //Prompt user for int
    int n = scnr.nextInt(); //D+I n with user input int

    //System.out.println(n); - checking if scnr.nextInt works properly

    //Method calls - printing
    System.out.println(calcIterativeHarmonic(n));
    System.out.println(calcRecursiveHarmonic(n));
  }

}
