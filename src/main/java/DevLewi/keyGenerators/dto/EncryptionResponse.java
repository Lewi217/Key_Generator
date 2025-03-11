package DevLewi.keyGenerators.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EncryptionResponse {
    private String encryptedData;
    private  String base64Key;
}
