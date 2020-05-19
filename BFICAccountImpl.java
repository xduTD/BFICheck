package BFICheck;

import java.util.LinkedHashMap;

public class BFICAccountImpl implements BFICAccount {
	
	
	//输入个人信息，用构造器实现
	public BFICAccount() {
		
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
	}
		
	//创建中间Block
	private void createNormalBlock() {
	}
		
	@Override//创建分叉Block（后面不允许有新的Block）
	public void reVerify() {
	}
		
	//检查链是否有效
	private Boolean checkValidity() {
		return null;
	}
	
}
