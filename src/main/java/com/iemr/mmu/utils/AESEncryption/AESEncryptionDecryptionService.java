package com.iemr.mmu.utils.AESEncryption;

public interface AESEncryptionDecryptionService {

	public String encrypt(String strToEncrypt) throws Exception;

	public String decrypt(String strToDecrypt) throws Exception;

}
