/**
 * 
 */
package invitationalA2021;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Ian Fernandes
 *
 */
public class Ethan {
	static TreeMap<Integer, Point> mappings;
	
	static double getDistance() {
		double distance = 0;
		List<Integer> keys = new ArrayList<Integer>(mappings.keySet());
		for(int i = 0; i<keys.size()-1; i++) {
			int firstRow = mappings.get(keys.get(i)).x, firstCol = mappings.get(keys.get(i)).y;
			int secondRow = mappings.get(keys.get(i+1)).x, secondCol = mappings.get(keys.get(i+1)).y;
			distance += Math.sqrt(Math.pow(secondRow-firstRow, 2) + Math.pow(secondCol-firstCol, 2));
		}
		return distance;
	}
	
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("ethan.dat"));
		int n = scan.nextInt();
		for(int i = 0; i<n; i++) {
			int d = scan.nextInt();
			mappings = new TreeMap<>();
			for(int r = 0; r<d; r++)
				for(int c = 0; c<d; c++)
					mappings.put(scan.nextInt(), new Point(r, c));
			System.out.printf("Case %d distance: %.4f%n", i+1, getDistance());
		}
	}
}
