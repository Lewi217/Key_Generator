package DevLewi.keyGenerators.controller;

import DevLewi.keyGenerators.dto.DecryptionRequest;
import DevLewi.keyGenerators.dto.DecryptionResponse;
import DevLewi.keyGenerators.dto.EncryptionRequest;
import DevLewi.keyGenerators.dto.EncryptionResponse;
import DevLewi.keyGenerators.response.ApiResponse;
import DevLewi.keyGenerators.service.CryptoService;
import DevLewi.keyGenerators.utils.exceptions.ApiResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static DevLewi.keyGenerators.utils.exceptions.ApiResponseUtils.REQUEST_ERROR_MESSAGE;
import static DevLewi.keyGenerators.utils.exceptions.ApiResponseUtils.REQUEST_SUCCESS_MESSAGE;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/crypto")
@RequiredArgsConstructor
public class CryptoController {
    private final CryptoService cryptoService;

    //encrypt
    @PostMapping("/encrypt")
    public ResponseEntity<ApiResponse> encrypt(@RequestBody EncryptionRequest request){
        try{
            EncryptionResponse response = cryptoService.encryptText(request.getText());
            return ResponseEntity.ok().body(new ApiResponse(REQUEST_SUCCESS_MESSAGE, response));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ApiResponse(REQUEST_ERROR_MESSAGE, e.getMessage()));
        }
    }

    @PostMapping("/decrypt")
    public ResponseEntity<ApiResponse> decrypt(@RequestBody DecryptionRequest request) {
        try {
            String decryptedText = cryptoService.decryptText(request.getEncryptedData(), request.getBase64Key());
            DecryptionResponse response = new DecryptionResponse();
            response.setDecryptedText(decryptedText);
            return ResponseEntity.ok().body(new ApiResponse(REQUEST_SUCCESS_MESSAGE, response));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ApiResponse(REQUEST_ERROR_MESSAGE, e.getMessage()));
        }
    }


}
