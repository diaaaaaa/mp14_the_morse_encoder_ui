package at.refugeescode.morse;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class Morse {

    private Parser parser;

    private Map<String, String> morse;

    public Morse(Parser parser) {
        this.parser = parser;
        morse = parser.loadMorseDictionary();
    }

    public String encode(String letter) {
        return morse.get(letter.toUpperCase());
    }
}
