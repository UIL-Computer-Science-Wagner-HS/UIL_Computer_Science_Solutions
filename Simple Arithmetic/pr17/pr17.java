package simpleArithmetic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class pr17 {

	private static double process(ArrayList<Double> scores, double difficulty) {
		//Remove the lowest and highest
		scores.remove(Collections.min(scores));
		scores.remove(Collections.max(scores));

		//Average
		double sum = 0;
		for (double score : scores)
			sum += score;
		sum /= scores.size();

		double finalScore = sum * difficulty;
		return finalScore;
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr17.dat"));
		int no = Integer.parseInt(scan.nextLine());
		while (no-- > 0) {
			String[] currentLine = scan.nextLine().split(" ");
			ArrayList<Double> scores = new ArrayList<>();	//Store scores in ArrayList<Double>
			for (String a : currentLine)
				scores.add(Double.parseDouble(a));
			scores.remove(scores.size() - 1);				//Remove the last one, which was the difficulty
			double difficulty = Double.parseDouble(currentLine[currentLine.length - 1]);
			System.out.printf("%.3f%n", process(scores, difficulty));
		}
		scan.close();
	}
}
