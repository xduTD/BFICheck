package BFICheck;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class BFICAccountImpl implements BFICAccount, Serializable {
	private String corporate = null;
	private String password = null;
	private String email = null;
	private String verifyNumber = null;
	private String privateKey = null;
	private String publicKey = null;
	private LinkedList<BFICBlock> blockLinkedList = new LinkedList<>();
	
	//输入个人信息，用构造器实现
	public BFICAccountImpl(String corporate, String password, String email, String verifyNumber) {
		this.corporate = corporate;
		this.password = password;
		this.email = email;
		this.verifyNumber = verifyNumber;
	}
	
	public String getName() {
		return corporate;
	}
	
	public boolean checkPassword(String passwd) {
		if (this.password == passwd) {
			return true;
		}
		return false;
	}
	
	//生成私钥
	private void generatePrivateKey() {
		
	}
	
	//向Manager返回私钥
	public String getPrivateKey() {
		return privateKey;
	}
	
	//生成公钥
	private void generatePublicKey() {
		
	}
	
	//读取tag，被其他函数调用
	private String getTag() {
		return null;
	}
	
	//读取上一个block的信息
	private LinkedHashMap readLastBlockInfor(String tag) {
		return blockLinkedList.getLast().getTransactions();
	}
		
	//读取第一个block的信息
	private LinkedHashMap readFirstBlockInfor(String tag) {
		return blockLinkedList.getFirst().getTransactions();
	}
		
	@Override//验证信息，打印验证信息，并生成新block，
	public void verify() {
	}
		
	//获取上一个block的hash
	private String getLastHash() {
		return null;
	}
		
	//创建起始Block
	public void createInitialBlock() {
		/* mention：需要随机生成一个tag，可以用Random模块（定义并引用Utilities内的函数）
		 * 建议生成大随机数，然后block内的个人信息transaction用key-value存储，采用数字签名算法，key为公钥，value为tag经公钥加密后的值
		 */
		BFICBlock block = new BFICBlock();
		
	}
		
	//创建中间Block
	private void createNormalBlock() {
		BFICBlock block = new BFICBlock();
	}
	
	@Override//创建分叉Block（后面不允许有新的Block）
	public void reVerify() {
		/*
		 * mention：只有在已有普通block的条件下才能创建次block，可以添加变量，想想怎么解决一下这个问题
		 * 检验是否有新的非期望block生成（tag是否泄露）
		 */
		
	}
		
	//检查链是否有效
	private Boolean checkValidity() {
		/*
		 * 计算前一个block的hash，与后一个block的prevousHash对比，相同则证明block有效
		 * 全部block有效即链有效
		 */
		return null;
	}
	
}
