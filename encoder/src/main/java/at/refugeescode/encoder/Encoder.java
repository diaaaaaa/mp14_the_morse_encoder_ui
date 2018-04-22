package at.refugeescode.encoder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class Encoder {

    private RestTemplate restTemplate;

    @Value("${morse.url}")
    private String morseUrl;

    public Encoder(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String encode(String message) {
        return Stream.of(message.split(""))
                .map(letter -> restTemplate.postForObject(morseUrl, letter, String.class))
                .collect(Collectors.joining(" "));
    }
}
