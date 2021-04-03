import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Pablo {
	
	static double getDistance(double startLat, double startLon, double endLat, double endLon) {
		double a = Math.pow(Math.sin(Math.toRadians((endLat-startLat)/2)), 2);
		a += Math.cos(Math.toRadians(startLat)) * Math.cos(Math.toRadians(endLat)) * Math.pow(Math.sin(Math.toRadians((endLon-startLon)/2)), 2);
		double c = 2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double d = 6371 * 1000 * c;
		return d;
	}
	
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("pablo.dat"));
		int num = Integer.parseInt(scan.nextLine());
		while(num-->0) {
			String[] nextLine = scan.nextLine().split("\\s+");
			double startLat = Double.parseDouble(nextLine[0]);
			double startLon = Double.parseDouble(nextLine[1]);
			double endLat = Double.parseDouble(nextLine[2]);
			double endLon = Double.parseDouble(nextLine[3]);
			
			double result = getDistance(startLat, startLon, endLat, endLon);
			System.out.printf("The distance between (%.5f, %.5f) and (%.5f, %.5f) is %.0f meters.%n", startLat, startLon, endLat, endLon, result);
		}
	}
}
