package com.iemr.mmu.utils.AESEncryption;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iemr.mmu.utils.config.ConfigProperties;

public class AESEncryptionDecryption {
	
	//private static Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	private static Logger logger = LoggerFactory.getLogger(ConfigProperties.class);
	private static SecretKeySpec secretKey;
	private static byte[] key;
	final static String secret = "amrith$%2022@&*piramalswasthya!#";

	public static void setKey(final String myKey) {
		MessageDigest sha = null;
		try {
			key = myKey.getBytes("UTF-8");
			sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
			secretKey = new SecretKeySpec(key, "AES");
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}


	public String encrypt(String strToEncrypt) throws Exception {
		 String encryptedString=null;
		try {
			setKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			encryptedString= Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
		} catch (Exception e) {
			logger.error("Error while encrypting: "+e.toString());
			throw new Exception("Error while encrypting: "+e.toString());
		}
		return encryptedString;
	}


	public static String decrypt(String strToDecrypt) throws Exception {
		 String decryptedString=null;
		try {
			setKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			decryptedString= new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (Exception e) {
			logger.error("Error while decrypting: "+e.toString());
			throw new Exception("Error while decrypting: "+e.toString());
		}
		return decryptedString;
	}

}
