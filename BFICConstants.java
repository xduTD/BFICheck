package BFICheck;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * 只存放常量和不变的对象，所有均用public static final修饰
 */
public class BFICConstants {
	//正则表达式，邮箱格式：
	public static final String EMAIL_REGEX = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
	//RSA加密幂数：
	public static final int power = 537;
	//序列化读写对象，储存file的文件：
	public static final File objectFile = new File("objectFile.dat");
	public static final FileOutputStream fileOutStream = new FileOutputStream(BFICConstants.objectFile);
	public static final ObjectOutputStream objOutStream = new ObjectOutputStream(BFICConstants.fileOutStream);		
	public static final FileInputStream fileInStream = new FileInputStream(BFICConstants.objectFile);
	public static final ObjectInputStream objInStream = new ObjectInputStream(BFICConstants.objInStream);
}
