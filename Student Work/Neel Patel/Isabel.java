import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;


public class Isabel {
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan = new Scanner (new File ("isabel (1).dat")); // scanning in the data file
		
		String month_types[] = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}; // array with all of the months
		
		ArrayList <String> name_list = new ArrayList<String>(); // array consisting the name
		ArrayList <DayOfWeek> day_list = new ArrayList<DayOfWeek>(); // array consisting the day of the week of "name" birthday
		ArrayList <String> month_list = new ArrayList<String>(); // array consisting the month of "name" birthday
		ArrayList <Integer> date_list = new ArrayList<Integer>(); //array consisting the date of "name" birthday
		ArrayList <Integer> year_list = new ArrayList<Integer>(); // array consisting the year of "name" birthday
		
		ArrayList<Order> list = new ArrayList<Order>(); // ArrayList to store an object (Order) consisting of ArrayList: name_list, day_list, month_list, date_list, year_list
		
		//COLLECTING THE DATA
		while (scan.hasNext()) { // looping through all of the data
			String str[] = scan.nextLine().split(" "); // splitting each line on a space to retrieve: name, year, month, and date 
			
			String name = str[0]; // name
			String month = month_types[Integer.parseInt(str[2])-1]; // month
			int date = Integer.parseInt(str[3]); // date
			int year = Integer.parseInt(str[1]); // year
			
			LocalDate date1 = LocalDate.of(year,Integer.parseInt(str[2]),date); // creating a LocalDate object to find the day of the week of the provided date
			DayOfWeek day = date1.getDayOfWeek(); // day of the week 
			
			
			name_list.add(name); // adding name to name_list
			day_list.add(day); // adding day to day_list
			month_list.add(month); // adding month to month_list
			date_list.add(date); // adding date to date_list
			year_list.add(year); // adding year to year_list
			
		}
		
		//COMPARING THE ELEMENTS
		for (int i = 0; i < name_list.size(); i++) {
			Order order1 = new Order(name_list.get(i),day_list.get(i),month_list.get(i),date_list.get(i),year_list.get(i)); // creating a object (Order) of all of the info collected
			list.add(order1); // adding the object into ArrayList: list
			Comparator<Order> comp1 = (a,b)-> a.day.compareTo(b.day); // comparing the day of different birthday
			Comparator<Order> comp2 = (a,b)-> a.name.compareTo(b.name); // comparing the name of the people
			
			list.sort(comp1.thenComparing(comp2)); // first sorting the ArrayList: list, by day and then name
		}
		
		//PRINTING THE FINAL OUTPUT
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%-12s%s%s%s%s%s%d%s%d", list.get(i).getName(), ": ",list.get(i).getDay(), ", ", list.get(i).getMonth()," ",list.get(i).getDate(),", ", list.get(i).getYear()); // formatting the output to print
			System.out.println(); // going to next line "enter"
		}
		
		
	}
}


//class to compare elements in the ArrayList: name_list, day_list, month_list, date_list, year_list
class Order{ 
	
	String name;
	DayOfWeek day;
	String month;
	int date;
	int year;

	public Order(String name, DayOfWeek day, String month, int date, int year) {
		this.name = name;
		this.day = day;
		this.month = month;
		this.date = date;
		this.year = year;
	}
	
	//METHODS TO RETURN DIFFERENT ELEMENTS
	public String getName() {
		return name;
	}
	public String getDay() {
		String day_str = day.toString(); // converting the type DayOfWeek into type String ( converting enum type of getDayOfWeek() method to a string type using toString() )
		day_str = day_str.substring(0,1).toUpperCase() + day_str.substring(1,day_str.length()).toLowerCase(); // formating the day into first letter capital and rest of them lowercase because the toString() method on an enum (DayOfWeek) capitalizes all of the letters)
		return day_str;
	}
	public String getMonth() {
		return month;
	}
	public int getDate() {
		return date;
	}
	public int getYear() {
		return year;
	}
	
}
