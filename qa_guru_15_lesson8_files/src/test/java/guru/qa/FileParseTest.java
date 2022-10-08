package guru.qa;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class FileParseTest {

    ClassLoader cl = FileParseTest.class.getClassLoader();

    @Test
    void pdfTest() throws Exception{
        InputStream is = cl.getResourceAsStream("logi.pdf");
        PDF pdf = new PDF(is);
        assertThat(pdf.text).contains("LIGHTSPEED Wireless Gaming Mouse");

    }
}
