package until;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DES {
	public DES() {

	}

//	public static void main(String[] args) {
//		String str = "测试内容";
//		String password = "9898989898989898";
//		String result = DES.encrypt(str, password);
//		System.out.println("加密后：" + new String(result));
//		try {
//			String decryResult = DES.decrypt(result, password);
//			System.out.println("解密后：" + new String(decryResult));
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
//	}

	public static String encrypt(String datasource, String password) {

		try {
			SecureRandom radom = new SecureRandom();
			DESKeySpec desKey = new DESKeySpec(password.getBytes());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey secretKey = keyFactory.generateSecret(desKey);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, radom);
			byte[] buf=cipher.doFinal(datasource.getBytes());
			
			return Base64Utils.encode(buf);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public static String decrypt(String src, String password) throws Exception {

		SecureRandom random = new SecureRandom();
		DESKeySpec desKey = new DESKeySpec(password.getBytes());
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKey);
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.DECRYPT_MODE, secretKey, random);
		byte[] buf = cipher.doFinal(Base64Utils.decode(src.toCharArray()));
		return new String(buf);

	}
}

