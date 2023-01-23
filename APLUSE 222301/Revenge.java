/*


Program Name: Revenge.java		Input File: revenge.dat
After being forced to take the punishment, you decide to get some revenge on the tournament organizers (even though you broke the rule first, you dummy) in the most juvenile way: rearranging the letters on all the displays present. However, since you’re not very good at coming up with funny phrases on the fly, you’ve decided to just move them systematically into an incomprehensible phrase. Your method works as following: reverse the string, split the string in half, then repeat the process until each portion is only one character long. Then, combine all the portions back together to make one big scrambled phrase. If a string is of odd length, the second half can be one character longer than the first.
Input
The first line will contain a single integer n that indicates the number of data sets that follow.  Each data set will start contain a phrase on a single line that may contain spaces.

Output
For each phrase, use the splitting and reversing method to rearrange the characters in the phrase, then output the result.
Example Input File
3
Concessions
Match Schedule
Restrooms down the hall and to the left
Example Output to Screen
issonnCosce
echledutMa Sch
dnt laal l tef oethoo mseRrsththe od wn
Explanation
For the first case, the process is as follows:

Concessions
snoissecnoC
snois secnoC
sions Conces
si ons Con ces
is sno noC sec
i s s no n oC s ec
i s s on n Co s ce
i s s o n n C o s c e
issonnCosce

*/
import java.io.*;
import java.util.*;
public class Revenge {
	// helper method to reverse elements of the array between left and right inclusive
	static void rev(char[] arr, int left, int right) {
		//char[] nArr = new char[right-left+1];
		for(int i = 0; i<=(right-left)/2; i++) {
			char swap = arr[i+left];
			arr[i+left]= arr[right-i];
			arr[right-i] = swap;
			
			
		}
		
		
	}
	static void sort(char[] arr, int left, int right) {
		if(left<right) {
			rev(arr,left,right);//reverse
		int mid = (left+right+1)/2;  // find midpoint
		sort(arr,left,mid-1);// sort left of the midpoint
		//System.out.println(right);
		sort(arr,mid,right);
		
		
		
		}
	}
	
	
public static void main(String... args) throws IOException {

	Scanner scan = new Scanner(new File("revenge.dat"));
	int noSets = scan.nextInt();
	scan.nextLine();
	while (noSets-- > 0) {
		String str = scan.nextLine();
		char[] arr = str.toCharArray();
		sort(arr, 0, arr.length-1);
		//rev(arr,0,2);
		System.out.println(arr);

	}

}
}
