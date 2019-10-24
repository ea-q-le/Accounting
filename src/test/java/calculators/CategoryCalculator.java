package calculators;

import java.util.List;

public class CategoryCalculator {

	/**
	 * Given a List of String[] and the category name,
	 * returns the total amount within the List for the category as double.
	 * @param lines given as List of String[] representing each line
	 * @param category as a String
	 * @return total amount for the matching category as a double
	 */
	public static double categoryCalculator(List<String[]> lines, String category) {
		double retSum = 0.0;
		
		for (String[] each : lines) {
			if (each[4].trim().equalsIgnoreCase(category)) {
				retSum += Double.valueOf( each[3] );
			}
		}
		
		return Math.round(retSum * 100.0) / 100.0;
	}
	
	/**
	 * Overridden method which given a List of String[] and the category name,
	 * if boolean value is passed in as true, it will calculate only positive transactions,
	 * else it will calculate and return negative transactions.
	 * @param lines given as a List of String[] representing each line
	 * @param category as a String
	 * @param isDeposit as a boolean whether deposits or withdrawals are requested
	 * @return total amount of matching category and values as a double
	 */
	public static double categoryCalculator(List<String[]> lines, String category, boolean isDeposit) {
		double retSum = 0.0;
		
		for (String[] each : lines) {
			if (each[4].trim().equalsIgnoreCase(category)) {
				double temp = Double.valueOf( each[3] );
				if (temp > 0) {
					if (isDeposit) {
						retSum += temp;
					}
				} else {
					if (!isDeposit) {
						retSum += temp;
					}
				}
			}
		}
		
		return Math.round(retSum * 100.0) / 100.0;
	}
	
	/**
	 * TODO - Write a Javadoc description HERE
	 * @param lines
	 * @param category
	 * @param isDeposit
	 * @param isLarger
	 * @param threshold
	 * @return
	 */
	public static double categoryCalculator(List<String[]> lines, String category, boolean isDeposit, boolean isLarger, double threshold) {
		double retSum = 0.0;
		
		for (String[] each : lines) {
			if (each[4].trim().equalsIgnoreCase(category)) {
				double temp = Double.valueOf( each[3] );
				if (temp > 0) {
					if (isDeposit) {
						if (isLarger) {
							if (temp > threshold) {
								retSum += temp;
							}
						}else {
							if (temp < threshold) {
								retSum += temp;
							}
						}
					}
				} else {
					if (!isDeposit) {
						if (!isLarger) {
							if (temp < threshold) {
								retSum += temp;
							}
						}else {
							if (temp > threshold) {
								retSum += temp;
							}
						}
					}
				}
			}
		}
		
		return Math.round(retSum * 100.0) / 100.0;
	}
}
