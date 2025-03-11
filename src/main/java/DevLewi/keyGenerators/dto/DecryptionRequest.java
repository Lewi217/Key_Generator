package DevLewi.keyGenerators.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DecryptionRequest {
    private String encryptedData;
    private String base64Key;
}
