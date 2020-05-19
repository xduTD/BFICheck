package BFICheck;

import java.util.Scanner;

//This Class only contains utility functions
public class BFICUtilities {
	// TODO: prompting and scan a valid order to return
	public static String scanString(Scanner scan, String prompt) {
		String str = null;
		
		System.out.println(prompt);
		do {
			str = scan.nextLine();
		} while (!str.isBlank());
		return str;
	}
	
	
}
