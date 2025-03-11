package DevLewi.keyGenerators.service;

import DevLewi.crypto_utils.CryptoUtils; // Import the crypto utils
import DevLewi.keyGenerators.dto.EncryptionResponse;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;

@Service
public class CryptoService implements ICryptoService{
    @Override
    public EncryptionResponse encryptText(String text) throws Exception {
        SecretKey key = CryptoUtils.generateKey();
        String encryptedText = CryptoUtils.encrypt(text, key);
        return new EncryptionResponse(encryptedText, CryptoUtils.keyToString(key));
    }

    @Override
    public String decryptText(String encryptedData, String keyString) throws Exception {
        SecretKey key = CryptoUtils.stringToKey(keyString);
        return CryptoUtils.decrypt(encryptedData, key);
    }
}