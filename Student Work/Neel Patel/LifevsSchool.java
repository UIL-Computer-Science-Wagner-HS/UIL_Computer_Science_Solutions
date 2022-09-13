import java.io.*;
import java.util.*;



public class LifevsSchool {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("life.dat"));
		int n = scan.nextInt();
		scan.nextLine();
		int day = 1;

		while (n-- > 0) {
			String date_list [] = scan.nextLine().split(" ");
			String class_list [] = scan.nextLine().split(" ");
			
			//date start time
			String[] date = date_list[0].split(":");
			String s_date = date[0] + "" + date[1]; 
			int start_date = Integer.parseInt(s_date);

			
			//date end time
			String[] date2 = date_list[1].split(":");
			String e_date = date2[0] + "" + date2[1]; 
			int end_date = Integer.parseInt(e_date); 

			
		
			
			int num = 1;
			
			for (int i = 0; i < class_list.length; i=i+2) {
					//class start time
				
					String[] class_ = class_list[i].split(":");
					String s_class = class_[0] + "" + class_[1]; 
					int start_class = Integer.parseInt(s_class); 	
					
					//class end time
					String[] class2_ = class_list[i+1].split(":");
					String e_class = class2_[0] + "" + class2_[1]; 
					int end_class = Integer.parseInt(e_class); 
					
					
					if ((start_class >= start_date && start_class <= end_date) || (end_class >= start_date && end_class <= end_date)) {
						System.out.println("DAY #" + day + " CONFLICT WITH CLASS #" +(num));
					}
					num++;
					
				}
				
			day++;
			
			}
			
		
	}
}