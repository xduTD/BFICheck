package BFICheck;

import java.io.Serializable;
import java.util.LinkedHashMap;

public class BFICAccountImpl implements BFICAccount, Serializable {
	private String corporate = null;
	private String email = null;
	private String verifyNumber = null;
	private String privateKey = null;
	
	//输入个人信息，用构造器实现
	public BFICAccountImpl(String corporate, String email, String verifyNumber) {
		this.corporate = corporate;
		this.email = email;
		this.verifyNumber = verifyNumber;
	}
	
	//读取tag，被其他函数调用
	private String getTag() {
		return null;
	}
	
	//读取上一个block的信息
	private LinkedHashMap readLastBlockInfor(String tag) {
		return null;
	}
		
	//读取第一个block的信息
	private LinkedHashMap readFirstBlockInfor(String tag) {
		return null;
	}
		
	@Override//验证信息
	public void verify() {
	}
		
	//获取上一个block的hash
	private String getLastHash() {
		return null;
	}
		
	//创建起始Block
	private void createInitialBlock() {
		/* mention：需要随机生成一个tag，可以用Random模块
		 * 建议生成大随机数，然后block内的个人信息transaction用key-value存储，采用数字签名算法，key为公钥，value为tag经公钥加密后的值
		 */
	}
		
	//创建中间Block
	private void createNormalBlock() {
	}
		
	@Override//创建分叉Block（后面不允许有新的Block）
	public void reVerify() {
		//mention：只有在已有普通block的条件下才能创建次block，可以添加变量，想想怎么解决一下这个问题
	}
		
	//检查链是否有效
	private Boolean checkValidity() {
		return null;
	}
	
}
