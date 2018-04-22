package at.refugeescode.ui;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Scope("session")
public class Encoder {

    private RestTemplate restTemplate;

    @Value("${encoder.url}")
    private String encoderUrl;

    private String message;

    private String encodedMessage;

    public Encoder(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void encode(Message message) {
        this.message = message.getText();
        encodedMessage = restTemplate.postForObject(encoderUrl, this.message, String.class);
    }

    public String getEncodedMessage() {
        return encodedMessage;
    }

    public String getMessage() {

        return message;
    }
}
