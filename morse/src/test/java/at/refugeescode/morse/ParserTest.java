package at.refugeescode.morse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ParserTest {

    @Autowired
    private Parser parser;

    @Test
    void loadMorseDictionary() {
        Map<String, String> morse = parser.loadMorseDictionary();
        assertNotEquals(1, morse.size());
    }
}