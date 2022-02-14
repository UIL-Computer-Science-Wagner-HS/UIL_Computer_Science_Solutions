import java.io.*;
import java.util.*;
public class Klaudia {
	static Map<String, Character> map = new HashMap<>();
	
	
public static void main(String...args) throws IOException{
	map.put(".-", 'A');
	map.put("-...", 'B');
	map.put("-.-.", 'C');
	map.put("-..", 'D');
	map.put(".", 'E');
	map.put("..-.", 'F');
	map.put("--.", 'G');
	map.put("....", 'H');
	map.put("..", 'I');
	map.put("-.-", 'J');
	map.put("-.-", 'K');
	map.put(".-..", 'L');
	map.put("--", 'M');
	map.put("-.", 'N');
	map.put("---", 'O');
	map.put(".--.", 'P');
	map.put("--.-", 'Q');
	map.put(".-.", 'R');
	map.put("...", 'S');
	map.put("-", 'T');
	map.put("..-", 'U');
	map.put("...-", 'V');
	map.put(".--", 'W');
	map.put("-..-", 'X');
	map.put("-.--", 'Y');
	map.put("--..", 'Z');
	map.put(".----", '1');
	map.put("..---", '2');
	map.put("...--", '3');
	map.put("....-", '4');
	map.put(".....", '5');
	map.put("-....", '6');
	map.put("--...", '7');
	map.put("---..", '8');
	map.put("----.", '9');
	map.put("-----", '0');
	map.put("/", ' ');
	Scanner scan = new Scanner(new File("klaudia.dat"));
	int noSets = scan.nextInt();
	
	scan.nextLine();
	while(noSets-->0){
		String[] arr = scan.nextLine().split(" ");
		for(int i = 0; i<arr.length; i++)
			System.out.print(map.get(arr[i]));
		System.out.println();
		
		
		
	}
}
}