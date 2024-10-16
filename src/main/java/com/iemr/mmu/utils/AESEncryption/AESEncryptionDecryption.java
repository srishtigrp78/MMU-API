/*
* AMRIT – Accessible Medical Records via Integrated Technology
* Integrated EHR (Electronic Health Records) Solution
*
* Copyright (C) "Piramal Swasthya Management and Research Institute"
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.mmu.utils.AESEncryption;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/*
*
*
DE40034072 - Internal path disclosure - AES Encryption and Decryption
*
*
*/
@Component
public class AESEncryptionDecryption {

	private Logger logger = LoggerFactory.getLogger(AESEncryptionDecryption.class);
	private static SecretKeySpec secretKey;
	private byte[] key;
	private final String secret = "amrith$%2022@&*piramal@@swasthya!#";
	private static final int IV_SIZE = 12;
	private static final int TAG_SIZE = 128;

	public void setKey(String myKey) {
		try {
			key = myKey.getBytes("UTF-8");
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
			secretKey = new SecretKeySpec(key, "AES");
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			logger.error("context", e);
		}
	}

	public String encrypt(String strToEncrypt) throws Exception {
		if (secretKey == null)
			setKey(secret);
		Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

		// Generate IV
		byte[] iv = new byte[IV_SIZE];
		SecureRandom random = new SecureRandom();
		random.nextBytes(iv);
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, new GCMParameterSpec(TAG_SIZE, iv));

		byte[] encryptedBytes = cipher.doFinal(strToEncrypt.getBytes("UTF-8"));
		byte[] encryptedIvAndText = new byte[IV_SIZE + encryptedBytes.length];
		System.arraycopy(iv, 0, encryptedIvAndText, 0, IV_SIZE);
		System.arraycopy(encryptedBytes, 0, encryptedIvAndText, IV_SIZE, encryptedBytes.length);

		return Base64.getEncoder().encodeToString(encryptedIvAndText);
	}

	public String decrypt(String strToDecrypt) throws Exception {
		if (secretKey == null)
			setKey(secret);

		byte[] encryptedIvAndText = Base64.getDecoder().decode(strToDecrypt);
		byte[] iv = Arrays.copyOfRange(encryptedIvAndText, 0, IV_SIZE);
		byte[] encryptedBytes = Arrays.copyOfRange(encryptedIvAndText, IV_SIZE, encryptedIvAndText.length);

		Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
		cipher.init(Cipher.DECRYPT_MODE, secretKey, new GCMParameterSpec(TAG_SIZE, iv));
		byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

		return new String(decryptedBytes, "UTF-8");
	}
}
