import java.io.*;
import java.util.*;
public class Rec2 {
	
	public static void printSameEnd(int n)
	  {
	    if(n<=0)
	      return;
	    
	    if (n != 0)
	    {
	      printSameEnd(n-10);
	    }
	    System.out.print(n + " ");
	  }
	static void recur1 (int n) 
	{
	  if (n > 0)
	  {
	    recur1 (n - 2);
	  }
	  System.out.print (n + " ");
	}
	
	public static double mystery(int n) 
	{
	  if (n > 0)
	  {
		mystery(n-1);  
	   // return mystery(n - 1);
	  }
	  return n;
	}
	public static void mystery1(String digits, int n) 
	{
	  System.out.println(digits);

	  digits = digits.substring(n);

	  if (n > 0)
	  {
	    mystery1(digits, n - 1);
	  }
	}
	public static void mystery3 (int a, int b) 
	{ 
	  if (a < b) 
	  {
	    mystery3(a, b-1);
	  }
	  if (b < a) 
	  {
	    mystery3(a - 1, b);
	  }
	  System.out.println(a + " " + b);
	}
	public static void announce(int n)
	{
	  if (n > 1)
	  {
	    announce(n / 2);
	    System.out.println(n);
	  }
	  System.out.println("here");
	}
	
	public static void recur(int n)
	{
	  if (n % 10 != 0)
	  {
	    recur(n - 7);
	  }
	  System.out.print(n / 10);
	}
	public static void main(String[] args) {
		printSameEnd(41);
	
	
}
}
