/*PR 79Problem: 	Write a program that censors certain words from a line of text. The letters in the censored words are to be replaced by asterisks (*). The censored word may appear alone or may be contained in a word. If a censored word is contained in a censored word, the longest word should be removed. If a line contains more than one censored word, all instances should be removed.
 
Input: 	The first line of the data set is a list of words to censor. Each word is separated by a single space. On each of the following lines, there is a sentence. Letters may be uppercase or lowercase.
 
 
data file: 	pr79.dat
 
Output: 	Output each sentence with the censored words replaced with asterisks.
 
Assumptions: 	Censored words will not be over lapping (i.e. the end of one word is not the beginning of another) even though a censored word could be entirely contained in a censored word. 
 
Sample Input: 	
the at rich poor chocolate ice
The richest people in the world are chocolate lovers.
Poor Richard's Almanac is the best choice for getting sage advice.
Rich chocolate and licorice threaten the rich and poor alike. 
 
Sample Output: 
*** ****est people in *** world are ********* lovers.
**** ****ard's Almanac is *** best cho*** for getting sage adv***.
**** ********* and licor*** thre**en *** **** and **** alike.

 * 
 * 
 * 
 * PR 77Problem: Write a program that will print the letters of a string so the letters in the range A .. M are printed

on the first line and the letters in the range N .. Z are printed on the second line.

Input: The first line of the data set is an integer that represents the number of lines that follow. Each of
the remaining lines contains a sentence in uppercase letters of the alphabet. Each word is
separated by one space.

data file: pr77.dat
Output: Output the letters of each string so the letters in the range A .. M are printed on the first line and
the letters in the range N .. Z are printed on the second line. Non-alphabetic characters are to be
printed on both rows. Print at least one blank line between data sets.

Assumptions: None.
Sample Input:
2
TODAY IS DECEMBER 25, THE HAPPIEST DAY OF THE YEAR!
NOW IS THE TIME FOR ALL GOOD MEN TO COME TO THE AID OF THEIR COUNTRY.
Sample Output:
DA I DECEMBE 25, HE HA IE DA F HE EA !
TO Y S R 25, T PP ST Y O T Y R!
I HE IME F ALL G D ME C ME HE AID F HEI C .
NOW S T T OR OO N TO O TO T O T R OUNTRY.*/

package cs3;
import java.io.*;
import java.util.*;
public class pr77 {
	static String ast(String s){
		String ans = "";
		for(int i = 0; i<s.length(); i++)
			ans+="*";
		return ans;
		
	}
public static void main(String...args) throws IOException{
	Scanner scan = new Scanner(new File("pr77.dat"));
	int noSets = scan.nextInt();
	scan.nextLine();
	
	while(noSets-->0){
		String str = scan.nextLine();
		String str1 = str.replaceAll("[N-Z]"," ");
		System.out.println(str1);
		str1 = str.replaceAll("[A-M]"," ");
		System.out.println(str1);
		System.out.println();
		
	}
	scan.close();
	scan =  new Scanner(new File("pr79.dat"));
	String[] arr = scan.nextLine().split("\\s+");
	Arrays.sort(arr,(a,b)->b.length()-a.length());
	while(scan.hasNextLine()){
	String str2 = scan.nextLine();
	String s3 = "";
	for(String s: arr){
	
		str2 = str2.replaceAll("(?i)"+s,ast(s) );
		
	}
	System.out.println(str2);
	
	}
		
		
	}
}
