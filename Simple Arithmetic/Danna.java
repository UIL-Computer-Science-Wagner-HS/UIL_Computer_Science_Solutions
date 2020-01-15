import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Program for 2017 UIL Invitational B Programming Competition
 * 
 * Note that this code could have been shorter, but I wanted to demonstrate the
 * use of Object-Oriented Programming as well as Enums.
 * 
 * @author fernandesi2244
 *
 */
public class Danna {

	/**
	 * Enum to represent BMI category.
	 *
	 */
	enum Category {
	UNDERWEIGHT, NORMAL, OVERWEIGHT, OBESE;
	}

	/**
	 * Class to represent a student with a height and weight.
	 */
	static class Student {
		private double height, weight, BMI;
		Category type;

		/**
		 * Construct a new student.
		 * 
		 * @param heightInMeters the student's height in meters
		 * @param weightInKilos  the student's weight
		 */
		public Student(double heightInMeters, double weightInKilos) {
			height = heightInMeters;
			weight = weightInKilos;
			calculateBMI();
		}

		/**
		 * Calculate the student's BMI.
		 */
		private void calculateBMI() {
			BMI = weight / Math.pow(height, 2);
			determineCategory();
		}

		/**
		 * Determine the BMI category of the student.
		 */
		private void determineCategory() {
			if (BMI < 18.5)
				type = Category.UNDERWEIGHT;
			else if (BMI >= 18.5 && BMI <= 24.9)
				type = Category.NORMAL;
			else if (BMI >= 25 && BMI <= 29.9)
				type = Category.OVERWEIGHT;
			else
				type = Category.OBESE;
		}
	}

	/**
	 * List of students who were surveyed
	 */
	private static ArrayList<Student> students = new ArrayList<>();

	/**
	 * Height conversion to get from inches to meters
	 */
	private static final double HEIGHT_CONVERSION = 0.0254;

	/**
	 * Weight conversion to get from pounds to kilograms
	 */
	private static final double WEIGHT_CONVERSION = 0.453592;

	/**
	 * Process input and handle according to program specifications.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("danna.dat"));
		while (scan.hasNextLine()) {
			String[] currentLine = scan.nextLine().split("\\s");
			int heightInInches = Integer.parseInt(currentLine[0]);
			int weightInPounds = Integer.parseInt(currentLine[1]);

			students.add(new Student(heightInInches * HEIGHT_CONVERSION, weightInPounds * WEIGHT_CONVERSION));
		}

		// Keep track of how many students are in each category
		int noUnderweight = 0, noNormal = 0, noOverweight = 0, noObese = 0;

		// Cycle through each student and print their statistics
		for (Student current : students) {
			Category category = current.type;
			System.out.printf("%d %d %.2f %s%n", (int) (current.height / HEIGHT_CONVERSION),
					(int) (current.weight / WEIGHT_CONVERSION), current.BMI, category.toString().toLowerCase());
			if (category == Category.UNDERWEIGHT)
				noUnderweight++;
			else if (category == Category.NORMAL)
				noNormal++;
			else if (category == Category.OVERWEIGHT)
				noOverweight++;
			else
				noObese++;
		}

		// Print general statistics about the data individuals.
		System.out.println(students.size() + " total students surveyed");
		System.out.printf("%.2f%% underweight%n", 100.0 * noUnderweight / students.size());
		System.out.printf("%.2f%% normal%n", 100.0 * noNormal / students.size());
		System.out.printf("%.2f%% overweight%n", 100.0 * noOverweight / students.size());
		System.out.printf("%.2f%% obese%n", 100.0 * noObese / students.size());

		scan.close();
	}
}
