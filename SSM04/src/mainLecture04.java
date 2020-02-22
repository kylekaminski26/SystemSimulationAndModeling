import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
//import java.util.Scanner;

public class mainLecture04 {
	public static void main(String args[]) {
		String fileName = "data.txt";
		Random randy = new Random();
//		Scanner sc = new Scanner(System.in); // use if not hard coding file names

		try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(fileName))) {
			String fileContent = "This is a sample of text.\n";
			buffWrite.write(fileContent);
			buffWrite.write(fileContent);
			buffWrite.close();
			System.out.println("File created.");
		} catch (Exception ex) { // Catch any type of error
			System.out.println("Something went wrong with writing the file.");
			System.exit(1); // End the program
		}

		System.out.println("Job complete.");

		fileName = "sample1.txt";
		try (BufferedReader buffRead = new BufferedReader(new FileReader(fileName))) {
			String line = buffRead.readLine();
			while (line != null) {
				System.out.println(line);
				line = buffRead.readLine();
			}
			buffRead.close();
		} catch (Exception ex) {
			System.out.println("Something went wrong with writing the file.");
			System.exit(1); // End the program
		}

		// Create a file (named sample2)
		// and fill it with 25 random doubles
		// 5 on a line for 5 lines
		//
		fileName = "sample3.csv";
		try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(fileName))) {
			double dNum;
			String temp;
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					dNum = randy.nextDouble();
					dNum = round3Places(dNum);
					temp = String.valueOf(dNum);
					buffWrite.write("\"" + temp + "\",");
					// buffWrite.write('"' + temp + '"' + ",");
				}
				buffWrite.write("\r\n");
			}
			buffWrite.close();
			System.out.println("Random File created.");
		} catch (Exception ex) { // Catch any type of error
			System.out.println("Something went wrong with writing the file.");
			System.exit(1); // End the program
		}

		// Assignment 4
		System.out.println("\n***********************\n");
		System.out.println(roundNPlaces(1.23456, 4)); // 1.2346
		System.out.println(roundNPlaces(9.42111, 1)); // 9.4
		System.out.println(roundNPlaces(7.756, 0)); // 7.0
		System.out.println(roundNPlaces(12.2566676, -1)); // 10
		System.out.println(roundNPlaces(12.2566676, -2)); // 0
	}

	/*
	 * Rounds a double to the nearest 2 decimal places.
	 * 
	 * @param double value
	 * 
	 * @returns the rounded double
	 */
	static double round2Places(double dNum) {
		double dTemp = dNum;
		dTemp += 0.005;
		dTemp *= 100;
		int iTemp = (int) dTemp;
		dTemp = (double) iTemp;
		dTemp /= 100;
		return dTemp;
	}

	/*
	 * Rounds a double to the nearest 3 decimal places.
	 * 
	 * @param double value
	 * 
	 * @returns the rounded double
	 */
	static double round3Places(double dNum) {
		double dTemp = dNum;
		dTemp += 0.0005;
		dTemp *= 1000;
		int iTemp = (int) dTemp;
		dTemp = (double) iTemp;
		dTemp /= 1000;
		return dTemp;
	}

	
	//Assignment 4
	/*
	 * Rounds a double to the nearest n decimal places.
	 * 
	 * @params (double) the base number and (integer) the place to round to.
	 * 
	 * @return the rounded double
	 */
	static double roundNPlaces(double dNum, int n) {
		// i.e. roundNPlaces(1.23456, 4) returns 1.2346
		// i.e. roundNPlaces(9.42111, 1) returns 9.4
		// i.e. roundsNPlaces (7.756, 0) returns 7.0
		// i.e. roundNPlaces (12.2566676, -1) returns 10
		// i.e. roundNPlaces (12.2566676, -2) returns 0
		double dTemp = dNum;
		dTemp += Math.pow(1, n) * 0.00005;
		dTemp *= Math.pow(10, n);
		int iTemp = (int) dTemp;
		dTemp = (double) iTemp;
		dTemp /= Math.pow(10, n);
		return dTemp;
	}
}
