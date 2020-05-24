package BFICheck;

import java.util.LinkedHashMap;

public class BFICBlock {
	private String previousHash = null;
	//使用LinkedHashMap来存储每个节点的验证信息
	/*
	 * 使用rsa进行数字签名
	 * tag为随机生成的256bit随机数，使用tag作为链接连到该链上
	 * hashmap中的key为公钥，value为经私钥加密的密文
	 * value经公钥解密后与tag相同，则可以确认商家或个人的身份
	 * 因为私钥是个人持有的，只有此私钥才能将tag加密为key可解密的密文。（身份验证和防抵赖）
	 */
	private LinkedHashMap transactions = null;
	private long timeStamp;
	private String hash = null;
	private String tag = null;
	
	//
	public String getPreviousHash() {
		return previousHash;
	}

	
	public LinkedHashMap getTransactions() {
		return transactions;
	}

	
	public long getTimeStamp() {
		return timeStamp;
	}

	
	public String getHash() {
		return hash;
	}
	
}
