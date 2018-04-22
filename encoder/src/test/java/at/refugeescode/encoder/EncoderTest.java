package at.refugeescode.encoder;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.util.function.Consumer;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class EncoderTest {

    @Autowired
    private Encoder encoder;

    @MockBean
    private RestTemplate restTemplate;

    @Value("${morse.url}")
    private String morseUrl;

    @Test
    void encode() {
        String message = "hello";
        Stream.of(message.split(""))
                .forEach(mockEncode());

        String encoded = encoder.encode(message);
        assertEquals("H E L L O", encoded);
    }

    private Consumer<String> mockEncode() {
        return letter -> when(restTemplate.postForObject(morseUrl, letter, String.class))
                .thenReturn(letter.toUpperCase());
    }
}