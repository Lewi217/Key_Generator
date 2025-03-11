package DevLewi.keyGenerators.service;

import DevLewi.keyGenerators.dto.EncryptionResponse;

public interface ICryptoService {
    EncryptionResponse encryptText(String text) throws Exception;
    String decryptText(String encryptedData, String keyString) throws Exception;
}
