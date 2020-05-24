package BFICheck;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
	
	
	//TODO: 序列化将列表上所有对象写到硬盘上
	public static void save(ArrayList<BFICAccountImpl> accountList) {
		try {//不需按序输入，用for-each循环覆盖文件
			for (BFICAccountImpl account : accountList) {
				BFICConstants.objOutStream.writeObject(account);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Failed to save account");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed to save account");
		} 
	}
	
	/*
	@Overload//TODO: 序列化单个对象写入硬盘
	public static void save(BFICAccountImpl newAccount) {
		try {//
			BFICConstants.objOutStream.writeObject(newAccount);		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Failed to save account");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed to save account");
		} 
	}
	*/
	
	//TODO: 反序列化返回硬盘上所有account对象组成的arraylist
	public static ArrayList<BFICAccountImpl> load() throws IOException, ClassNotFoundException {
		ArrayList<BFICAccountImpl> accountList = new ArrayList<BFICAccountImpl>();
		try {
			while (BFICConstants.fileInStream.available() > 0) {
				accountList.add((BFICAccountImpl) BFICConstants.objInStream.readObject());
			}
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
		return accountList;
	}
	
	
	//TODO: 查询输入信息是否为真
	public static boolean checkInfor(String corporate, String email, String verifyNumber) {
		//需要进行邮箱验证等，暂时先放在这里
		return false;
	}
	
	
}
