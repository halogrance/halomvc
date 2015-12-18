

package until.trade;

import java.io.UnsupportedEncodingException;


/**
 * 
 * Title:数据类型转换
 * 
 * Description:
 * 
 * Copyright: Copyright (c) 2012-5-17
 * 
 * Company: Wuhan TianYu Co., Ltd.
 * 
 * @author 沈韶敏
 * 
 * @version 1.0
 */
public class DataTypeConvert {
	/**
	 * HEX_FF 十六进制数FF
	 */
	private static final short HEX_FF = 0xff;
	
	/**
	 * THREE 十进制数3
	 */
	private static final int THREE = 3;
	
	/**
	 * FOUR 十进制数4
	 */
	private static final int FOUR = 4;
	
	/**
	 * EIGHT 十进制数8
	 */
	private static final int EIGHT = 8;
	
	/**
	 * SIXTEEN 十进制数16
	 */
	private static final int SIXTEEN = 16;
	
	/**
	 * TWENTY_FOUR 十进制数24
	 */
	private static final int TWENTY_FOUR = 24;

	/**
	 * int To ByteArray
	 * @param n int
	 * @return ByteArray
	 * 2012-6-2 上午11:28:41
	 * @author 沈韶敏
	 */
	public static byte[] intToByteArray(int n) {
		byte[] b = new byte[FOUR];
		b[0] = (byte) (n & HEX_FF);
		b[1] = (byte) (n >> EIGHT & HEX_FF);
		b[2] = (byte) (n >> SIXTEEN & HEX_FF);
		b[THREE] = (byte) (n >> TWENTY_FOUR & HEX_FF);
		return b;
	}

	/**
	 * Short To ByteArray
	 * @param n short
	 * @return ByteArray
	 * 2012-6-2 上午11:37:48
	 * @author 沈韶敏
	 */
	public static byte[] shortToByteArray(short n) {
		byte[] b = new byte[2];
		b[1] = (byte) (n & HEX_FF);
		b[0] = (byte) (n >> EIGHT & HEX_FF);
		return b;
	}

	/**
	 * ByteArray To int
	 * @param b ByteArray
	 * @return int
	 * 2012-6-2 上午11:38:55
	 * @author 沈韶敏
	 */
	public static int byteArrayToInt(byte[] b) {
		int iOutcome = 0;
		byte bLoop;
		for (int i = 0; i < FOUR; i++) {
			bLoop = b[i];
			iOutcome += (bLoop & HEX_FF) << (EIGHT * i);
		}
		return iOutcome;
	}

	/**
	 * ByteArray To Short
	 * @param b ByteArray
	 * @return short
	 * 2012-6-2 上午11:39:29
	 * @author 沈韶敏
	 */
	public static short byteArrayToShort(byte[] b) {
		short iOutcome = 0;
		byte bLoop;
		for (int i = 0; i < 2; i++) {
			bLoop = b[i];
			iOutcome += (bLoop & HEX_FF) << (EIGHT * i);
		}
		return iOutcome;
	}

	/**
	 * ByteArray To String
	 * @param b ByteArray
	 * @return String
	 * 2012-6-2 上午11:40:18
	 * @author 沈韶敏
	 */
	public static String byteArrayToString(byte[] b) {
		String retStr = "";
		try {
			retStr = new String(b, "GBK");
		} catch (UnsupportedEncodingException e) {
		}
		return retStr.trim();
	}

	/**
	 * String To ByteArray
	 * @param str String
	 * @return ByteArray
	 * 2012-6-2 上午11:40:52
	 * @author 沈韶敏
	 */
	public static byte[] stringToByteArray(String str) {
		byte[] retBytes = null;
		try {
			retBytes = str.getBytes("GBK");
		} catch (UnsupportedEncodingException e) {
		}
		return retBytes;
	}
}
