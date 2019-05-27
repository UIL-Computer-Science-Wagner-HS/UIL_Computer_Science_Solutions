import java.util.*;
import java.io.*;

public class Nandita {
	
	public static void process(String month,String day, String year) {
		int intMonth, intDay = Integer.parseInt(day.substring(0,day.length()-1)),intYear = Integer.parseInt(year);
		ArrayList<String> months = new ArrayList<String>(Arrays.asList("january","february","march", "april", "may", "june","july","august","september","october","november","december"));
		intMonth = months.indexOf(month.toLowerCase())+1;
		System.out.printf("%02d/%02d/%s%n",intMonth, intDay, year.substring(year.length()-2));
		System.out.printf("%02d.%02d.%s%n",intDay,intMonth,year);
		System.out.printf("%s-%02d-%02d%n",year,intMonth,intDay);
		System.out.println("=====");
	}

	public static void main(String[] args)throws IOException {
		Scanner scan = new Scanner(new File("nandita.dat"));
		while(scan.hasNextLine()) {
			process(scan.next(),scan.next(),scan.next());
		}
		scan.close();

	}

}
