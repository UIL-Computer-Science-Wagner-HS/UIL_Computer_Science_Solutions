package cs3;

import java.io.*;
import java.util.*;

public class JedhiMaster1 {
	public static void main(String... args) throws IOException {
		String str1 = "II WAANT TO GO TO MISSISSIPPI ALTHOUHG IWANT NO VOWWEELLLLS";
		// no vowels except the starting vowel
		String str2 = str1.replaceAll("(\\S)[AEIOU]+", "$1");
		System.out.println(str2);
		str2 = str1.replaceAll("(\\w)\\1+", "$1");
		System.out.println(str2);
	}

}
