package at.refugeescode.encoder;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/encode")
public class EncoderEndpoint {

    private Encoder encoder;

    public EncoderEndpoint(Encoder encoder) {
        this.encoder = encoder;
    }

    @PostMapping
    String encode(@RequestBody String message) {
        return encoder.encode(message);
    }

}
