package runner;

import csv.reader_writer.CsvWriter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static calculators.CategoryCalculator.*;
import static csv.reader_writer.CsvReader.*;

public class MainTester {

	public static void main(String[] args) {

		// Total income
		System.out.println("All positive transactions: \t" +
				categoryCalculator(
						csvToListOfArrays("src/test/resources/input/2018-all.csv", ","),
						true
				)
		);

		// Total expense
		System.out.println("All negative transactions: \t" +
				categoryCalculator(
						csvToListOfArrays("src/test/resources/input/2018-all.csv", ","),
						false
				)
		);



		System.out.println("TOTAL vehicle expenses: \t" +
				categoryCalculator(
						csvToListOfArrays("src/test/resources/input/2018-all.csv", ","),
						"vehicle",
						false
				)
		);
		// Purchase prices (vehicle > 2000)
		System.out.println("Vehicle purchases (vehicle > $2,000): \t" +
				categoryCalculator(
						csvToListOfArrays("src/test/resources/input/2018-all.csv", ","),
						"vehicle",
						false,
						false,
						-2000.00
				)
		);
		System.out.println("Vehicle purchases as consignments: \t" +
				categoryCalculator(
						csvToListOfArrays("src/test/resources/input/2018-all.csv", ","),
						"consignment",
						false
				)
		);

		// Recon fees (vehicle < 2000 + inspections) (including labor and parts - labor is to be deducted from 1099 filing as contract labor)
		System.out.println("Vehicle reconditioning expenses (vehicle < $2,000): \t" +
				categoryCalculator(
						csvToListOfArrays("src/test/resources/input/2018-all.csv", ","),
						"vehicle",
						false,
						true,
						-2000.00
				)
		);
		System.out.println("Inspections category expenses: \t" +
				categoryCalculator(
						csvToListOfArrays("src/test/resources/input/2018-all.csv", ","),
						"inspections",
						false
				)
		);
//		//TODO-NOTE:net negative TRANSFERS
//		System.out.println("Net negative transfers: \t" +
//				categoryCalculator(
//						csvToListOfArrays("src/test/resources/input/2018-all.csv", ","),
//						"transfer"
//				)
//		);

		// Salary (including wages and contract labor - commissions are to be deducted from 1099 filing as contract labor)
		// TODO -> this is part of office
		// Rent (office > 500)
		System.out.println("Office expenses >$500 with RENT && SALARY && INTEREST: \t" +
				categoryCalculator(
						csvToListOfArrays("src/test/resources/input/2018-all.csv", ","),
						"office",
						false,
						false,
						-500.00
				)
		);

		// Office/supplies (office < 500) / Travel should be a portion of office expenses / Wages should come out of here too
		System.out.println("Office expenses <$500: \t" +
				categoryCalculator(
						csvToListOfArrays("src/test/resources/input/2018-all.csv", ","),
						"office",
						false,
						true,
						-500.00
				)
		);

		// Temptags / should go where, office?
		System.out.println("Temptags expenses: \t" +
				categoryCalculator(
						csvToListOfArrays("src/test/resources/input/2018-all.csv", ","),
						"temptags",
						false
				)
		);

		// DMV / should go where, office?
		System.out.println("DMV expenses: \t" +
				categoryCalculator(
						csvToListOfArrays("src/test/resources/input/2018-all.csv", ","),
						"dmv",
						false
				)
		);

		// Interest (interest is a category) TODO-> Define logic HERE (it will be part of recon for payments to FLOORING)
		System.out.println("Interest expenses: \t" +
				categoryCalculator(
						csvToListOfArrays("src/test/resources/input/2018-all.csv", ","),
						"interest",
						false
				)
		);

		// Marketing
		System.out.println("Marketing expenses: \t" +
				categoryCalculator(
						csvToListOfArrays("src/test/resources/input/2018-all.csv", ","),
						"marketing",
						false
				)
		);

		// Insurance
		System.out.println("Insurance expenses: \t" +
				categoryCalculator(
						csvToListOfArrays("src/test/resources/input/2018-all.csv", ","),
						"insurance",
						false
				)
		);

		// Taxes & Licenses
		System.out.println("Tax (and licenses): \t" +
				categoryCalculator(
						csvToListOfArrays("src/test/resources/input/2018-all.csv", ","),
						"tax",
						false
				)
		);

		// Utilities
		System.out.println("Utilities: \t" +
				categoryCalculator(
						csvToListOfArrays("src/test/resources/input/2018-all.csv", ","),
						"utilities",
						false
				)
		);

		// Food
		System.out.println("Food expenses: \t" +
				categoryCalculator(
						csvToListOfArrays("src/test/resources/input/2018-all.csv", ","),
						"food",
						false
				)
		);

		// Gas
		System.out.println("Gas expenses: \t" +
				categoryCalculator(
						csvToListOfArrays("src/test/resources/input/2018-all.csv", ","),
						"gas",
						false
				)
		);

		// investment
		System.out.println("Investment expenses: \t" +
				categoryCalculator(
						csvToListOfArrays("src/test/resources/input/2018-all.csv", ","),
						"investment",
						false
				)
		);

		// other
		System.out.println("'Other' expenses: \t" +
				categoryCalculator(
						csvToListOfArrays("src/test/resources/input/2018-all.csv", ","),
						"other",
						false
				)
		);

		// NOT CATEGORIZED
		System.out.println("Uncategorized expenses: \t" +
				categoryCalculator(
						csvToListOfArrays("src/test/resources/input/2018-all.csv", ","),
						false,
						false
				)
		);

		System.out.println("CATEGORIZED expenses: \t" +
				categoryCalculator(
						csvToListOfArrays("src/test/resources/input/2018-all.csv", ","),
						false,
						true
				)
		);

		Set<String> categories = new HashSet<String>();
		List<String[]> lines = csvToListOfArrays("src/test/resources/input/2018-all.csv", ",");
		for (String[] each : lines)
			categories.add(each[4]);
		System.out.println(categories);

		System.out.println("UNCATEGORIZED income: \t" +
				categoryCalculator(
						csvToListOfArrays("src/test/resources/input/2018-all.csv", ","),
						true,
						false
				)
		);
		System.out.println("CATEGORIZED income: \t" +
				categoryCalculator(
						csvToListOfArrays("src/test/resources/input/2018-all.csv", ","),
						true,
						true
				)
		);


		CsvWriter.writeToCsv(
				csvToListOfArrays("src/test/resources/input/2018-all.csv", ","),
				"src/test/resources/output",
				"2018-all"
		);


	}
	
}
