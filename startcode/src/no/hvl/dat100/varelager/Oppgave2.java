package no.hvl.dat100.varelager;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;

public class Oppgave2 {
	static final String SEP = "-----------------";

	public static void printReverseString(String input) 
	{
		int n = input.length();
		
		StringBuilder tmp = new StringBuilder(n);
		tmp.setLength(n);
		
		for(int i=0; i<n; i++) {
			tmp.setCharAt((n - 1) - i, input.charAt(i));
		}
		
		System.out.printf("\"%s\" reversed is \"%s\"%n", input, tmp);
	}
	
	public static String formatCurrency(double amount) 
	{
		return java.text.MessageFormat.format("{0,number,currency}", amount);	
	}
	
	public static void testMessageFormat() 
	{
		double planet = 23.50;
		String event = "a disturbance in the Force";

		String result = java.text.MessageFormat.format(
		    "At {1,time} on {1,date,short}, there was {2} on planet {0,number,currency}.",
		    planet, new java.util.Date(), event);	
		System.out.println(result);
		
		long currentTimeMillis = System.currentTimeMillis();
		
		String dt = java.text.MessageFormat.format("{0,date,short} {0,time} {1}", currentTimeMillis);		
		System.out.println(dt);
		
		String sf = java.text.MessageFormat.format("{0,number,#}", 1.5555);		
		System.out.println(sf);
		
	
		System.out.printf("%.0f%n", 1.5355);		
	}
	
	public static void main(String[] args) 
	{
		testMessageFormat();
		System.out.println(formatCurrency(666666666.666));
		
		int numFakeInput = 7;
		String[] fakeInput = {"", "0", "01", "012", "0123", "01234", "012345", "0123456"};
		
		System.out.println("Innskrevne ord ("+numFakeInput+")");
		System.out.println(Arrays.toString(fakeInput));
		System.out.println(SEP);
		
		String searchStr = "i";
		
		System.out.println("Mønstergjenkjenning");
		System.out.printf("Søkemønster \"%s\"%n", searchStr);
		for(int i=0; i<fakeInput.length; i++) {
			if(fakeInput[i].indexOf(searchStr) > -1) {
				System.out.printf("Ord[%d] = \"%s\" inneholder \"%s\"%n", i, fakeInput[i], searchStr);
			}
		}
		System.out.println(SEP);
		
		String subStr;
		System.out.println("Midterste tegn eller bokstav");
		for(int i=0; i<fakeInput.length; i++) {
			String s = fakeInput[i];
			int len = s.length();
			if(len == 0) {
				subStr = "";
			}else if(len == 1) {
				subStr = s.substring(0, 1);
			}else if(len % 2 == 0) {
				subStr = s.substring((len / 2) - 1, (len / 2) + 1);
			}else {
				subStr = s.substring((len / 2) - 1, (len / 2) + 2);			
			}
			System.out.printf("\"%s\" (len: %d) => \"%s\"%n", s, len, subStr);			
		}
		System.out.println(SEP);
		
		printReverseString("Baklengs");
		System.out.println(SEP);		
		
		String[] fakeInput2 = {"Det","Deta", "var","en","veldig","fin","dag","i","skogen"};
		String s1 = findStringThatIsFirstInUnicodeAlphabet(fakeInput2);
		System.out.printf("streng som \"kommer først\" i unicode \"%s\"%n", s1);
		String s2 = findStringThatIsFirstInUnicodeAlphabetBuiltin(fakeInput2);
		System.out.printf("streng som \"kommer først\" i unicode \"%s\"%n", s2);		
		System.out.printf("alternativer var %s%n", Arrays.toString(fakeInput2));
	}
	
	static String findStringThatIsFirstInUnicodeAlphabet(String[] arr) 
	{
		if(arr.length == 0) 
		{
			throw new IllegalArgumentException("array must be non-empty");
		}
		
		String found = arr[0];
		for(int i=1; i<arr.length; i++) 
		{
			if(compareTo(arr[i], found) < 0) 
			{
				found = arr[i];
			}
		}
		return found;
	}
	
	static String findStringThatIsFirstInUnicodeAlphabetBuiltin(String[] arr) 
	{
		if(arr.length == 0) 
		{
			throw new IllegalArgumentException("array must be non-empty");
		}
		
		String found = arr[0];
		for(int i=1; i<arr.length; i++) 
		{
			if(arr[i].compareTo(found) < 0) 
			{
				found = arr[i];
			}
		}
		return found;
	}
	
	static int compareTo(String a, String b) 
	{
		if((a == null) && (b == null)) {
			return 0;
		}else if(a == null) {
			return -1;
		}else if(b == null) {
			return 1;
		} 
		
		int diff;
				
		int n1 = a.length();
		int n2 = b.length();
		
		int maxIter = Math.min(n1, n2);		
		
		for(int i=0; i<maxIter; i++) 
		{
			diff = a.charAt(i) - b.charAt(i);
			
			if(diff < 0) 
			{
				return -1;
			}
			else if (diff > 0) 
			{
				return 1;
			}
		}

		if(n1 < n2) 
		{
			return -1;
		}
		else if(n1 > n2) 
		{
			return 1;
		}
		
		return 0;
	}
}