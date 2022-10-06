package guru.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SimpleJunitExamplesTest {
    @Disabled("не запускается до починки бага JIRADefect-1111")
    @Test
    void simpleTest0() {
        Assertions.assertEquals("Str","Str");}

    @DisplayName("простой тест")
    @Test
    void simpleTest1() {
        Assertions.assertEquals("Str","Str");
    }
}
