import java.io.*;
import java.util.*;

public class Eric {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("eric.dat")); // scanning in the file with the data
		
		while (scan.hasNext()) {
			String[] temp_arr = scan.nextLine().split(" "); // creating a temporary array with the two numbers stored as a String array
			ArrayList<Integer> arr = new ArrayList <Integer>(); // creating an arraylist to add more numbers later on
			arr.add(Integer.parseInt(temp_arr[0])); arr.add(Integer.parseInt(temp_arr[1])); // adding the elements from the temporary array into the arraylist:arr
			int n1 = arr.get(0); // setting n1 as the first number 
			int n2 = arr.get(1); // setting n2 as the second number
			boolean reached = false; // condition until the arraylsit has the first two number of the arraylist at the end of the arraylist a well
			for (int i = 0; reached != true; i++) { // looping through until the arraylist contains the same beginning adn ending numbers
				int sum = arr.get(i)+arr.get(i+1); // getting the sum of the number 
				if (sum < 10) { // if sum is less than ten, then just adding in the sum into the arr
					arr.add(sum);
				}
				else { // else getting the number that is mod 10 of the sum and adding that into the arr
					arr.add(sum%10);
				}
	
				if (arr.get(arr.size()-1) == n2 && arr.get(arr.size()-2) == n1) { // if the beginning a dnthe ending of the arr are the same, then setting the condition: reached. as true
					reached = true;
				}
			}
			System.out.println(arr.size()); // printing the size of the final series (the amount of numbers in the arr it took to find the same beginning and ending)
		}
	}

}
