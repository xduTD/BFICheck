package BFICheck;

import java.util.LinkedHashMap;

/*
 * 输入个人信息（创建账户时） 核验 （用户）
 * 读取tag（用户）
 * 读取上一个block的信息
 * 读取第一个block的信息
 * 输出验证信息（用户）
 * 获取上一个block的hash
 * 创建起始block（用户）
 * 创建中间的block（用户）
 * 创建临时不可读取hash的block
 * check isValid 检查链是否有效
 */

//只要是public都是直接与Manager交互的，private是仅被其他function调用的，不与Manager交互
public interface BFICAccount {	
	//验证信息
	public void verify();
	
	//在已有block的条件下再次验证信息   创建分叉Block（后面不允许有新的Block）
	public void reVerify();
	
}
