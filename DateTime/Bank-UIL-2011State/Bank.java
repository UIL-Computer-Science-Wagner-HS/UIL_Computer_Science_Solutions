import java.io.*;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Bank {
	static List<Entry> list = new ArrayList();

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("bank.dat"));
		double balance = 0;
		while(scan.hasNextLine()){
			String entDate = scan.next();
			double add = scan.nextDouble();
			scan.nextLine();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate d = LocalDate.parse(entDate,formatter);
			list.add(new Entry(d,add));}
		
			int currentMonth = list.get(0).date.getMonthValue();
			int currentYear = list.get(0).date.getYear();
			balance = list.get(0).amt;
			for(int i = 1; i<list.size(); i++){
				LocalDate temp = list.get(i-1).date;
				while(temp.getYear()<list.get(i).date.getYear()){
					balance = 1.02*balance;
					temp = temp.plusMonths(1);
				}
				while(temp.getMonthValue()<list.get(i).date.getMonthValue()){
					balance = 1.02*balance;
					temp = temp.plusMonths(1);
				}
				//System.out.println("Year "+temp.getYear()+" Month "+temp.getMonthValue()+" banance "+ balance);
				
				
					balance+=list.get(i).amt;
					
					
				}
			System.out.println("$"+(1.0*(int)(balance*100)/100));
				
			}
			
		}
		
	


class Entry {
	LocalDate date;
	double amt;

	public Entry(LocalDate date, double amt) {
		super();
		this.date = date;
		this.amt = amt;
	}

}
