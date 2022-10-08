package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.devtools.v85.io.IO;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class SelenideFileTest {

    @Test
    void selenideFileDownloadTest() throws Exception {
        open("https://github.com/selenide/selenide/blob/master/README.md");
        File downloadedFile = $("#raw-url").download();
        try(InputStream is = new FileInputStream(downloadedFile);)
        {byte[] fileSource = is.readAllBytes();
            String fileContent = new String(fileSource, StandardCharsets.UTF_8);
            assertThat(fileContent).contains("Selenide is a framework for writing easy-to-read and easy-to-maintain automated tests in Java.");
        }
    }

    @Test
    void uploadFile() throws Exception{
        open("https://fineuploader.com/demos.html");
        $("input[type='file']").uploadFromClasspath("tmnt.jpg");
        $("span[class='qq-upload-file-selector qq-upload-file']").shouldHave(Condition.text("tmnt.jpg"));
    }


}
