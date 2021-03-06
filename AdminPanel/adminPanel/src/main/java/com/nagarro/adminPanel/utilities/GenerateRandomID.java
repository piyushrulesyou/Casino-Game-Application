package com.nagarro.adminPanel.utilities;

/**
 * This class generates the random unique ID for each user.
 * 
 * @author piyushagarwal01
 *
 */
public class GenerateRandomID {

	/**
	 * This method returns the random unique ID for each user.
	 * 
	 * @param emailID
	 * @param contactNumber
	 * @param customerName
	 * @return
	 */
	public static String generateID(String emailID, String contactNumber, String customerName) {

		String firstPart = emailID.substring(0, 3).toLowerCase();

		int randOne = (int) (Math.random() * 100);

		String secondPart = contactNumber.substring(0, 3);

		int randTwo = (int) (Math.random() * 100);

		String thirdPart = customerName.substring(0, 3).toLowerCase();

		int randThree = (int) (Math.random() * 100);

		String finalID = firstPart + randOne + secondPart + randTwo + thirdPart + randThree;

		finalID = finalID.replaceAll("\\s", "");

		return finalID;
	}

}
