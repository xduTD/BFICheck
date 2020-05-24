package BFICheck;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * This class should be a singleton and operate all accounts
 * 通过manager类创建多个account来模拟真实多个account上链的情况
 * 
 */

public class BFICManager {
	//arraylist存储当前所有account账号，并且序列化存储在硬盘中,启动Manager时自动加载
	private ArrayList<BFICAccountImpl> accountList = null;
	//构造singleton单例模式
	private static BFICManager managerSingleton = null;
	//构造器私有化，只有内部方法才可调用， 保证singleton的实现
	private BFICManager() {}
	//对外返回实例化对象
	public static BFICManager getInstance() {
		if (managerSingleton == null) {
			managerSingleton = new BFICManager();
		}
		return managerSingleton;
	}
	
	
	//main函数作为程序入口进入操作菜单
	public static void main(String args[]) {
		//为降低函数的耦合性，将scan当作参数逐级传递
		Scanner scan = new Scanner(System.in);
		//BFICManager实例化
		BFICManager systemManager = BFICManager.getInstance();
		//加载已保存到硬盘的对象（反序列化）
		systemManager.readLocalAccount();
		//前往操作界面
		systemManager.operatingInterface(scan);
	}
	
	
	//操作界面
	private void operatingInterface(Scanner scan) {
		String prompt = null;
		String command = null;
		System.out.println("Welcome to Blockchain For Information Check System\n");
		
		do {
			prompt = "Pause \'1\' to Register      Pause \'2\' to Log in     Pause \'0\' to Quit";
			command = BFICUtilities.scanString(scan, prompt);
			switch (command) {
				case "1":
					registerAccount(scan); //转到创建账号
					break;
				case "2":
					loginAccount(scan); //转到登录账号
					break;
				case "0":
					break;
			} 
		} while(!(command == "0"));
		scan.close();
	}
	
	
	//加载文件中已创建对象
	private void readLocalAccount() throws ClassNotFoundException, IOException{
		accountList = BFICUtilities.load();
	}
	
	
	//创建账号
	private void registerAccount(Scanner scan) {
		String prompt = null;
		String corporate = null;//法人
		String email = null;
		String verifyNumber = null;//Id or License
		String password = null;
		
		System.out.println("Register Interface");
		//scan corporate
		prompt = "Input the corporate/person name of this account:";
		corporate = BFICUtilities.scanStr(scan, prompt);
		//scan password
		prompt = "Input the password of this account";
		password = BFICUtilities.scanStr(scan, prompt);
		//scan email
		prompt = "Input your email for concat:";
		email = BFICUtilities.scanEmail(scan, prompt);
		//scan verifyNumber
		prompt = "Input your personal id number or business license number for verification only:";
		verifyNumber = BFICUtilities.scanStr(scan, prompt);
		
		Boolean verification = BFICUtilities.checkInfor(corporate, email, verifyNumber);
		//验证通过则创建账户，不通过则提示失败
		if (verification) {
			BFICAccountImpl newAccount = new BFICAccountImpl(corporate, password, email, verifyNumber);
			accountList.add(newAccount);
			BFICUtilities.save(accountList);
			System.out.println("Your new account have been saved");
		} else {
			System.out.println("Failed to create an account");
		}
	}
	
	
	//验证登录
	private BFICAccountImpl verifyLogin(Scanner scan) {
		BFICAccount account = null;
		String prompt = null;
		String corporate = null;
		String password = null;
		//输入用户名和密码：
		prompt = "Input your corporate:";
		corporate = BFICUtilities.scanStr(scan, prompt);
		prompt = "Input your password:";
		password = BFICUtilities.scanStr(scan, prompt);
		//遍历，找到用户名相同的account验证password是否相同
		for (int index = 0; index < accountList.size(); index++) 
		{
			account = accountList.get(index);
			if (account.getName() == corporate) {
				if (account.checkPassword(password)) {
					System.out.println(account.getName() + ", successfully login");
					return (BFICAccountImpl) account;
				} 
			} else {
				System.out.println("No such account.Please check and try again!");
				return null;
			}
		}
		System.out.println("Password wrong. Please check again!");
		return null;
	}
	
	
	//登录账号(二级主操作界面)
	private void loginAccount(Scanner scan) {
		//本应连接到MySQL数据库，但是因为时间紧促，只好先写个java代替
		String prompt = null;
		String command = null;
		//验证登录信息
		BFICAccountImpl account = verifyLogin(scan);
		if (account != null) {
			prompt = "Enter your operation:\n"
				+ "Pause \'1\' to verify an item      Pause \'2\' to build a new chain      Pause \'0\' to quit";
			command = BFICUtilities.scanString(scan, prompt);
			switch (command) {
				case "1" :
					//转到account的verify方法，验证并生成新block
					account.verify();
					break;
				case "2" :
					//转到account本身的createInitialBlock方法
					account.createInitialBlock();
					break;
				case "0" :
					System.out.println("Return to main page");
					break;
			}
		}
	}
		
}
