package BFICheck;

import java.util.Scanner;

/*
 * This class should be a singleton and operate all accounts
 * 通过manager类创建多个account来模拟真实多个account上链的情况
 * 
 */

public class BFICManager {
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
					logInAccount(scan); //转到登录账号
					break;
				case "0":
					break;
			} 
		} while(!(command == "0"));
		scan.close();
	}
	
	
	//创建账号
	private void registerAccount(Scanner scan) {
		String prompt = null;
		String corporate = null;//法人
		String email = null;
		String verifyNumber = null; //Id or License
		String privateKey = null;
		
		
	}
	
	
	//登录账号
	private void logInAccount(Scanner scan) {
		//本应连接到MySQL数据库，但是因为时间紧促，只好先写个java代替
		
	}
	
	
}
