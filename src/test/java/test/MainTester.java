package test;

import java.util.Arrays;

import static calculators.CategoryCalculator.*;
import static csv.readers.CsvReader.*;
import static csv.readers.CsvWriter.*;

public class MainTester {

	public static void main(String[] args) {
		
		System.out.println("All positive vehicle transactions: \t" +
				categoryCalculator(
						csvToListOfArrays("C:\\Users\\sgadi\\Documents\\Autoplaza Accounting\\transactions\\01-january.csv", "--"), 
						"vehicle", 
						true)
				);
				
		System.out.println("All negative vehicle transactions: \t" +
				categoryCalculator(
						csvToListOfArrays("C:\\Users\\sgadi\\Documents\\Autoplaza Accounting\\transactions\\01-january.csv", "--"), 
						"vehicle", 
						false)
				);
		
		System.out.println("All negative vehicle transactions less than -$2,000: \t" +
				categoryCalculator(
						csvToListOfArrays("C:\\Users\\sgadi\\Documents\\Autoplaza Accounting\\transactions\\01-january.csv", "--"), 
						"vehicle", 
						false,
						false,
						-2000.00)
				);
		
		System.out.println("All negative vehicle transactions more than -$2,000: \t" +
				categoryCalculator(
						csvToListOfArrays("C:\\Users\\sgadi\\Documents\\Autoplaza Accounting\\transactions\\01-january.csv", "--"), 
						"vehicle", 
						false,
						true,
						-2000.00)
				);
		
		System.out.println(
				categoryCalculator(
						csvToListOfArrays("C:\\Users\\sgadi\\Documents\\Autoplaza Accounting\\transactions\\01-january.csv", "--"), 
						"vehicle")
				);
		
//		System.out.println(
//				categoryCalculator(
//						csvToListOfArrays("C:\\Users\\sgadi\\Documents\\Autoplaza Accounting\\transactions\\01-january.csv", "--"), 
//						"")
//				);
		
//		System.out.println(
//				writeToCsv(csvToListOfArrays("C:\\Users\\sgadi\\Documents\\Autoplaza Accounting\\transactions\\01-january.csv", "--", ""),
//						"C:\\Users\\sgadi\\Documents\\Autoplaza Accounting\\output", "test");
//				);
	}
	
}
