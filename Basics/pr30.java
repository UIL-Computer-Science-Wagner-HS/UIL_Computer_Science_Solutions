package strings;

public class pr30 {
	public static void main(String[] args) {
		String word = "ASTRONAUT";
		System.out.printf("First Letter : %c%n", word.charAt(0));
		System.out.printf("Last Letter : %c", word.charAt(word.length()-1));
	}
}
