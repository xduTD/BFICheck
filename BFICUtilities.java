package BFICheck;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//This Class only contains utility functions
public class BFICUtilities {
	// TODO: prompt and scan a valid string to return
	public static String scanString(Scanner scan, String prompt) {
		String str = null;
		
		System.out.println(prompt);
		do {
			str = scan.nextLine();
		} while (!str.isBlank());
		return str;
	}
	
	//TODO: prompt without enter and scan informations
	public static String scanStr(Scanner scan, String prompt) {
		String str = null;
		
		System.out.print(prompt);
		do {
			str = scan.nextLine();
		} while (!str.isBlank());
		return str;
	}
	
	//TODO: prompt, scan email and check its validity
	public static String scanEmail(Scanner scan, String prompt) {
		String email = null;
		boolean flag = false;
		
		System.out.print(prompt);
		do {
			email = scan.next();
			//正则表达式检验email是否合法
			Pattern pattern = Pattern.compile(BFICConstants.EMAIL_REGEX);
			Matcher matcher = pattern.matcher(email);
			flag = matcher.matches();
			if (!flag) {
				System.out.print("Invalid email. \nPlease check and input again:");
			}
		} while (!flag);
		return email;
	}
	
	//TODO: check legitimacy of informations
	public static boolean checkInfor(String corporate, String email, String verifyNumber) {
		//需要进行邮箱验证等，暂时先放在这里
		return true;
	}
	
	
}
