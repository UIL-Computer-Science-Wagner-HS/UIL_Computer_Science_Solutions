package uil2013;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Isabel {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("isabel.dat"));
		while(scan.hasNextLine()) {
			String[] arr = scan.nextLine().split(" ");
			String name = arr[0];
			int year = Integer.parseInt(arr[1]);
			int mon = Integer.parseInt(arr[2]);
			int day = Integer.parseInt(arr[3]);
			LocalDate d1 = LocalDate.of(year, mon, day);
			DateTimeFormatter formatter= DateTimeFormatter.ofPattern("EEEE MMMM dd, YYYY");
			String ans = ": "+ d1.format(formatter).toString();
			System.out.printf("%-11.11s%s\n",name,ans);
			
		}
	}

}
