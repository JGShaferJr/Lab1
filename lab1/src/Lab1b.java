/**
 * CS 2003 - Lab 1. Code to compute the average of doubles from an input
 * file.  NOTE: add data members and methods at your convenience. Use
 * the most accurate data types. You can reuse bits of code from
 * the class Lab1a.
 *
 *@author Jerry Shafer
 *@since 08/30/2017
 *@version 1.0
 */

import java.util.Scanner;
import java.util.Vector;
import java.io.File;
import java.io.IOException;

public class Lab1b {
    
	Vector <Double> dblVector; //stores the data retrieved from file

    /** Constructor: calls method readFile that reads the doubles
     * contained in the file and computes the
     * average of the elements.
     */
    public Lab1b(String filename) {
	readFile(filename);
    }

    /** Reads double from a file named "src/Lab1b.dat" and
     * computes the average of the elements contained in the file 
     * containing the doubles 
     */
    public void readFile(String filename) {
    	try {
	    File inputFile = new File(filename);
	    Scanner input = new Scanner(inputFile);
	    dblVector = new Vector<Double>();
	    double elt = 0.0, avg = 0.0; 
	    int count=0; //counter for data retrieved from file
	    // store all elements in a vector
	    while (input.hasNextDouble()== true) {
	    elt = input.nextDouble();
		count++;
		dblVector.addElement(elt); // stores values in vector
		avg += elt; // accumulates values 
	    }
	    // print on the terminal each elements of intVector
	    System.out.printf("There are %d doubles in the input file:\n",
			       count);
	    for (double value: dblVector)
		System.out.printf("%.5f ",value);
	    System.out.println();
	    
	    //calculate average
	    avg = avg / count;
	    //output results
	    System.out.printf("The average of the doubles in the input file is %.5f\n",avg);
	    input.close();
	} 
	catch (IOException e) {
	    System.err.println("IOException in reading input file!!!");
	}	
    } //end readFile()
    
    

    /** main : creates a Lab1b Object with the filename passed in
     * argument*/
    public static void main(String args[]) {
	
    new Lab1b("src/Lab1b.dat");
    } //end main
    
} //end class Lab1b
