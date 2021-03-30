import java.util.Set;
import java.util.TreeSet;

class RealAnagrams {
	static Set<String> answers = new TreeSet<>();
	
	static void anagram(String str, int start, int end) {
		if(start==end) {
			answers.add(str);
			return;
		}
		
		for(int i = start; i<=end; i++) {
			str = swap(str, start, i);
			anagram(str, start+1, end);
			str = swap(str, start, i);
		}
	}
	
	static String swap(String str, int first, int second) {
		StringBuilder sb = new StringBuilder(str);
		sb.setCharAt(first, str.charAt(second));
		sb.setCharAt(second, str.charAt(first));
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String str = "abc";
		anagram(str, 0, str.length()-1);
		answers.forEach(System.out::println);
	}
}