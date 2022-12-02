package lesson_13_jenkins;

import lesson_13_jenkins.helpers.Attach;
import lesson_13_jenkins.helpers.Properties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.selenide.AllureSelenide;

public class BaseTest {

    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://github.com";
        Configuration.browser = Properties.browser();
        Configuration.browserVersion = Properties.browserVersion();
        Configuration.browserSize = Properties.browserSize();
        if (!Properties.remoteUrl().equals("")) {
            Configuration.remote = Properties.remoteUrl();
        }
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}